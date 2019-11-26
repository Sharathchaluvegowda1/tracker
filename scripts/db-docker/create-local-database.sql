drop database if exists tracker_dev;
drop database if exists tracker_test;

create database tracker_dev;
create database tracker_test;

create user if not exists 'tracker'@'%' identified by 'tracker';
grant all privileges on tracker_dev.* to 'tracker'@'%';
grant all privileges on tracker_test.* to 'tracker'@'%';