drop schema if exists public cascade;
create schema public;

create table applications
(
  id bigserial primary key not null,
  name text not null,
  email text unique not null,
  motivation text,
  accepted bool default false,
  date_created timestamp without time zone default now()
);
