create table hibernate_sequence (
next_val bigint
);

insert into hibernate_sequence values ( 1 );

create table user (
    id bigint not null auto_increment,
    active bit not null,
    login varchar(255) not null,
    name varchar(255) not null,
    password varchar(255) not null,
    patronymic varchar(255),
    surname varchar(255) not null,
    primary key (id)
);

create table user_role (
    user_id bigint not null,
    roles varchar(255) not null
);

create index login_password_idx on user (login, password);

create index login_idx on user (login);

alter table user add constraint UK_ew1hvam8uwaknuaellwhqchhb unique (login);

alter table user_role add constraint user_role_fk foreign key (user_id) references user (id);
