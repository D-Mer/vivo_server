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