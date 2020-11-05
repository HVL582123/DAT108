DROP SCHEMA IF EXISTS oblig4 CASCADE;
create schema oblig4;
set search_path to oblig4;
CREATE TABLE person 
(
   mobilnr				varchar,
   fnavn			varchar,
   enavn			varchar,
   passord			varchar,
   kjonn				varchar,
   PRIMARY KEY (mobilnr)
);