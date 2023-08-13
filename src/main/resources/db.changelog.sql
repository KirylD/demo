--liquibase formatted sql

--changeset Kiryl Drabysheuski:create-users-table
create table users
(
  id       serial primary key,
  username varchar(64) unique not null
);

--changeset Kiryl Drabysheuski:generate-dummy-users contextFilter:dummy-data
insert into users(username)
values ('user1'), ('user2'), ('user3'), ('user4'), ('user5'), ('user6'), ('user7'), ('user8'), ('user9');
