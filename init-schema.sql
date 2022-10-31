
drop database if exists test_db;
create database test_db;
use test_db;
create table t1(
    id int primary key auto_increment,
    uuid varchar(128)
);