create extension if not exists "uuid-ossp";

create table users (
    id uuid primary key default uuid_generate_v4(),
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(100) not null,
    password varchar(100) not null
);

create table events (
    id uuid primary key default uuid_generate_v4(),
    date date,
    photo varchar(100) not null,
    name varchar(100) not null,
    link varchar(100) not null
);

insert into events (date, photo, name, link) values ('2024-02-02', './resources/images/koval.jpeg', 'Концерт Димы Коваля в Казани', 'https://etokoval.ru');
insert into events (date, photo, name, link) values ('2024-01-08', './resources/images/aranova.jpeg', 'Стендап Лизы Варвары Арановой в Калининграде', 'https://lizavarvara.com');
insert into events (date, photo, name, link) values ('2024-02-02', './resources/images/orlov.jpeg', 'Новый конуерт "Человек с головой собаки" ', 'https://orlovsergey.ru');

