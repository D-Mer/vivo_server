create table user
(
    email       varchar(40)       not null
        primary key,
    password    varchar(20)       not null,
    major       int               null,
    secondMajor int               null,
    minor       int               null,
    balance     double default 0  null,
    hobbies     text              null,
    credit      int    default 60 null,
    posts       text              null,
    qq          varchar(20)       null,
    wechat      varchar(20)       null,
    tel         varchar(11)       null,
    constraint userMajor
        foreign key (major) references major (id)
            on update cascade on delete set null,
    constraint userMinor
        foreign key (minor) references major (id)
            on update cascade on delete set null,
    constraint userSecondMajor
        foreign key (secondMajor) references major (id)
            on update cascade on delete set null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO vivo.user (email, password, major, secondMajor, minor, balance, hobbies, credit, posts, qq, wechat, tel) VALUES ('1', '1', 1, 1, 1, 1, '1', 1, '1', '1', '1', '1');