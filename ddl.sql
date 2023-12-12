create extension if not exists "uuid-ossp";

create table users (
                       id uuid primary key default uuid_generate_v4(),
                       first_name varchar(50) not null,
                       last_name varchar(50) not null,
                       email varchar(50) not null,
                       password varchar(50) not null
);