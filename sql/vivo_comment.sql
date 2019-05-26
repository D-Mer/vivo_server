create table comment
(
    id              int auto_increment
        primary key,
    replierEmail    varchar(40) not null,
    firstCommentId  int         null,
    secondCommentId int         null,
    content         text        null,
    urls            text        null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create index replierEmail
    on comment (replierEmail);

