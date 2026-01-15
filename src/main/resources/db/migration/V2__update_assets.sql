alter table assets
    add column name varchar(100),
    add column tracking_enabled boolean not null default false,
    drop column model;

