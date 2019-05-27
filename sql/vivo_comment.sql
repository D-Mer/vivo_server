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