create tablespace "eu-west-1_tablespace" with (
    replica_placement='{"num_replicas": 1, "placement_blocks":[{"cloud":"aws","region":"eu-west-1","zone":"eu-west-1a","min_num_replicas":1}]}'
);
create tablespace "us-east-1_tablespace" with (
    replica_placement='{"num_replicas": 1, "placement_blocks":[{"cloud":"aws","region":"us-east-1","zone":"us-east-1a","min_num_replicas":1}]}'
);

create table if not exists payment (
    id            int     not null,
    account_id    varchar not null,
    amount        numeric not null,
    geo_partition varchar
) partition by list (geo_partition);

create table if not exists payment_us partition of payment (
    id,
    account_id,
    amount,
    geo_partition,
    primary key (id)
) for values in ('US') tablespace "us-east-1_tablespace";

create table if not exists payment_eu partition of payment (
    id,
    account_id,
    amount,
    geo_partition,
    primary key (id)
) for values in ('EU') tablespace "eu-west-1_tablespace";

create table if not exists payment_default partition of payment (
    id,
    account_id,
    amount,
    geo_partition,
    primary key (id)
) default;


insert into payment values (1, 1001, 105.25, 'US');
insert into payment values (2, 2002, 120.50, 'EU');
insert into payment values (3, 2002, 130.50, 'AP');
insert into payment values (4, 2002, 140.50, 'AP');

