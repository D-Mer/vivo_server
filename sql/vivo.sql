create table user
(
    id         int auto_increment
        primary key,
    username   varchar(20)                  not null,
    password   varchar(20)                  not null,
    signupDate datetime                     null,
    authority  varchar(20) default 'member' not null,
    constraint user_name_uindex
        unique (username)
);

INSERT INTO vivo.user (id, username, password, signupDate, authority) VALUES (1, 'root', 'root', '2019-05-24 11:45:13', 'root');
INSERT INTO vivo.user (id, username, password, signupDate, authority) VALUES (2, '123456', '123456', '2019-05-24 20:56:15', 'member');