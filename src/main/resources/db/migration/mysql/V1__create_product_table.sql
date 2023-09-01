CREATE TABLE IF NOT EXISTS products(
product_id      integer not null auto_increment,
product_desc    varchar(255),
product_name    varchar(255),
product_price   float(53),

primary key (product_id)) engine=InnoDB;
