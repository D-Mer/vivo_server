create table post
(
    id              int auto_increment
        primary key,
    email           varchar(40)               not null,
    title           varchar(40)               not null,
    description     text                      not null,
    urls            text                      null,
    major           int                       null,
    tag             text                      null,
    commentNum      int         default 0     null,
    commentIds      text                      null,
    price           double      default 0     not null,
    state           varchar(20) default '未完成' not null,
    startTime       datetime                  not null,
    endTime         datetime                  null,
    orderTakerEmail varchar(40)               null,
    constraint orderMajor
        foreign key (major) references major (id)
            on update cascade on delete set null,
    constraint orderTakeEmail
        foreign key (orderTakerEmail) references user (email)
            on update cascade on delete set null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create index orderEmail
    on post (email);

INSERT INTO vivo.post (id, email, title, description, urls, major, tag, commentNum, commentIds, price, state, startTime, endTime, orderTakerEmail) VALUES (0, '0', 'null', 'null', null, 0, null, null, null, 0, '未完成', '2019-05-26 23:25:49', null, null);