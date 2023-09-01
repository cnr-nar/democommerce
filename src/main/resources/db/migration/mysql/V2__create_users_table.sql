CREATE TABLE IF NOT EXISTS users(

user_id         integer       not null auto_increment,
username        varchar(255)  not null,
password        varchar(255)  not null,
user_email      varchar(255)  ,
user_firstname  varchar(255)  ,
user_lastname   varchar(255)  ,
role            enum       ('Admin','User'),
is_active       bit, 

primary key (user_id),
UNIQUE KEY (username)
) engine=InnoDB;

