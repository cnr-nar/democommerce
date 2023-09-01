CREATE TABLE IF NOT EXISTS t_checkout(
checkout_id         integer not null auto_increment,
user_id             integer,
checkout_date       datetime(6) ,
checkout_quantity   integer,
checkout_price      float(53),

PRIMARY KEY(checkout_id),
CONSTRAINT FK_UserOrder FOREIGN KEY (user_id) REFERENCES users(user_id)
)engine=InnoDB;