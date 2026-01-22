ALTER TABLE assets RENAME TO reserves;

ALTER TABLE incidents RENAME COLUMN asset_id TO reserve_id;
