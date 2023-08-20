create database coca_starter_db;

use coca_starter_db;

create table user
(
    id           bigint primary key comment "主键id",
    name         varchar(30) not null comment "名称",
    age          tinyint     not null comment "年龄",
    creator      varchar(30) not null comment "创建人",
    modifier     varchar(30) not null comment "修改人",
    created_time datetime    not null comment "创建时间",
    modify_time  datetime    not null comment "修改时间",
    index idx_name (name)
) engine = innoDB,
  CHAR SET utf8mb4;

insert into user(id, name, age, creator, modifier, created_time, modify_time)
values (1, 'z3', 12, '1', '1', now(), now()),
       (2, 'l4', 15, '2', '2', now(), now()),
       (3, 'z5', 17, '3', '3', now(), now());

-- chang column name
-- alter table user rename column modifier_time to modify_time;

