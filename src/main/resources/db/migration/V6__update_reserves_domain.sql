-- V6__update_reserves_domain.sql

-- 1) Drop legacy columns that came from the old "asset" model (safe)
ALTER TABLE reserves
    DROP COLUMN IF EXISTS tracking_enabled,
    DROP COLUMN IF EXISTS latitude,
    DROP COLUMN IF EXISTS longitude,
    DROP COLUMN IF EXISTS last_heartbeat;

-- 2) Add new domain columns (add as NULLABLE first to avoid failure on existing rows)
ALTER TABLE reserves
    ADD COLUMN IF NOT EXISTS region VARCHAR(32),
    ADD COLUMN IF NOT EXISTS min_latitude DOUBLE PRECISION,
    ADD COLUMN IF NOT EXISTS max_latitude DOUBLE PRECISION,
    ADD COLUMN IF NOT EXISTS min_longitude DOUBLE PRECISION,
    ADD COLUMN IF NOT EXISTS max_longitude DOUBLE PRECISION;

-- 3) created_at: DB as source of truth
ALTER TABLE reserves
    ADD COLUMN IF NOT EXISTS created_at TIMESTAMP NOT NULL DEFAULT NOW();

-- 4) Backfill bounding box values for existing rows (only if they are NULL)
-- If you already have meaningful values, this will not override them.
UPDATE reserves
SET
    min_latitude  = COALESCE(min_latitude, 0),
    max_latitude  = COALESCE(max_latitude, 1),
    min_longitude = COALESCE(min_longitude, 0),
    max_longitude = COALESCE(max_longitude, 1)
WHERE
    min_latitude IS NULL
   OR max_latitude IS NULL
   OR min_longitude IS NULL
   OR max_longitude IS NULL;

-- 5) Enforce NOT NULL after backfill
ALTER TABLE reserves
    ALTER COLUMN min_latitude SET NOT NULL,
    ALTER COLUMN max_latitude SET NOT NULL,
    ALTER COLUMN min_longitude SET NOT NULL,
    ALTER COLUMN max_longitude SET NOT NULL;

-- 6) Constraints (safe if rerun)
DO $$
    BEGIN
        IF NOT EXISTS (
            SELECT 1 FROM pg_constraint WHERE conname = 'reserves_name_uk'
        ) THEN
            ALTER TABLE reserves ADD CONSTRAINT reserves_name_uk UNIQUE (name);
        END IF;

        IF NOT EXISTS (
            SELECT 1 FROM pg_constraint WHERE conname = 'reserves_lat_bbox_chk'
        ) THEN
            ALTER TABLE reserves ADD CONSTRAINT reserves_lat_bbox_chk CHECK (min_latitude < max_latitude);
        END IF;

        IF NOT EXISTS (
            SELECT 1 FROM pg_constraint WHERE conname = 'reserves_lon_bbox_chk'
        ) THEN
            ALTER TABLE reserves ADD CONSTRAINT reserves_lon_bbox_chk CHECK (min_longitude < max_longitude);
        END IF;
    END
$$;
