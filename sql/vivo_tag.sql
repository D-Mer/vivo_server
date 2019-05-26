create table tag
(
    id   int auto_increment
        primary key,
    name varchar(20) not null,
    constraint tag_name_uindex
        unique (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

