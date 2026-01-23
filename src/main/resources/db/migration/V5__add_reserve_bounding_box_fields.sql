ALTER TABLE reserves
    ADD COLUMN min_latitude  double precision,
    ADD COLUMN max_latitude  double precision,
    ADD COLUMN min_longitude double precision,
    ADD COLUMN max_longitude double precision;
