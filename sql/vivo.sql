create table major
(
    id   int auto_increment
        primary key,
    name varchar(20) not null,
    constraint major_name_uindex
        unique (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO vivo.major (id, name) VALUES (0, 'null');
INSERT INTO vivo.major (id, name) VALUES (9, '会计学');
INSERT INTO vivo.major (id, name) VALUES (11, '俄语');
INSERT INTO vivo.major (id, name) VALUES (13, '历史学');
INSERT INTO vivo.major (id, name) VALUES (5, '哲学');
INSERT INTO vivo.major (id, name) VALUES (12, '地质学');
INSERT INTO vivo.major (id, name) VALUES (8, '工商管理');
INSERT INTO vivo.major (id, name) VALUES (6, '新闻学');
INSERT INTO vivo.major (id, name) VALUES (14, '汉语言文学');
INSERT INTO vivo.major (id, name) VALUES (4, '法学');
INSERT INTO vivo.major (id, name) VALUES (7, '经济学');
INSERT INTO vivo.major (id, name) VALUES (3, '考古学');
INSERT INTO vivo.major (id, name) VALUES (10, '英语');
INSERT INTO vivo.major (id, name) VALUES (2, '计算机科学与技术');
INSERT INTO vivo.major (id, name) VALUES (1, '软件工程');



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



create table tag
(
    id   int auto_increment
        primary key,
    name varchar(20) not null,
    constraint tag_name_uindex
        unique (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


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


create table comment
(
    id              int auto_increment
        primary key,
    postId          int         null,
    replierEmail    varchar(40) not null,
    firstCommentId  int         null,
    secondCommentId int         null,
    content         text        null,
    urls            text        null,
    time            datetime    null,
    constraint postId
        foreign key (postId) references post (id)
            on update cascade on delete set null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create index replierEmail
    on comment (replierEmail);

INSERT INTO vivo.comment (id, postId, replierEmail, firstCommentId, secondCommentId, content, urls, time) VALUES (0, 0, 'null', null, null, null, null, null);