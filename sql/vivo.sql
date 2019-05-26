create table tag
(
    id   int auto_increment
        primary key,
    name varchar(20) not null,
    constraint tag_name_uindex
        unique (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table major
(
    id   int auto_increment
        primary key,
    name varchar(20) not null,
    constraint major_name_uindex
        unique (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table user
(
    email       varchar(40)       not null,
    password    varchar(20)       not null,
    major       int               null,
    secondMajor int               null,
    minor       int               null,
    balance     double default 0  not null,
    hobbies     text              null,
    credit      int    default 60 null,
    orders      text              null,
    qq          varchar(20)       null,
    wechat      varchar(20)       null,
    tel         varchar(11)       null,
    constraint user_email_uindex
        unique (email),
    constraint userMajor
        foreign key (major) references major (id)
            on update cascade,
    constraint userMinor
        foreign key (minor) references major (id)
            on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table user
    add primary key (email);

create table comment
(
    id              int auto_increment
        primary key,
    replierEmail    varchar(20) not null,
    firstCommentId  int         null,
    secondCommentId int         null,
    content         text        null,
    urls            text        null,
    constraint replierEmail
        foreign key (replierEmail) references user (email)
            on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


create table `order`
(
    id              int auto_increment
        primary key,
    email           varchar(20)               not null,
    title           varchar(40)               not null,
    description     text                      not null,
    urls            text                      null,
    major           int                       null,
    tag             text                      null,
    commentIds      text                      null,
    price           double      default 0     not null,
    state           varchar(20) default '未完成' not null,
    startTime       datetime                  not null,
    endTime         datetime                  null,
    orderTakerEmail varchar(20)               null,
    constraint orderEmail
        foreign key (email) references user (email)
            on update cascade,
    constraint orderMajor
        foreign key (major) references major (id)
            on update cascade,
    constraint orderTakerEmail
        foreign key (orderTakerEmail) references user (email)
            on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





