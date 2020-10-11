drop schema if exists dat108oblig3 cascade;

create schema dat108oblig3;
set search_path to dat108oblig3;

create table item (
    id serial primary key,
    beskrivelse varchar(30)
);
