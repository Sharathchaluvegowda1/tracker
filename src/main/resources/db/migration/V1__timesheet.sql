create table timesheet
(
    id bigint auto_increment,
    project_id bigint not null,
    user_id bigint not null,
    date datetime not null,
    hours int not null,
    constraint timesheet_pk
        primary key (id)
);