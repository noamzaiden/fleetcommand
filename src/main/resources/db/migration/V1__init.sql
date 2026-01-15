create table assets (
                        id bigserial primary key,
                        model varchar(100) not null,
                        latitude double precision,
                        longitude double precision,
                        last_heartbeat timestamp
);

create table incidents (
                           id bigserial primary key,
                           asset_id bigint not null references assets(id),
                           priority varchar(20) not null,
                           status varchar(20) not null,
                           created_at timestamp not null default now()
);
