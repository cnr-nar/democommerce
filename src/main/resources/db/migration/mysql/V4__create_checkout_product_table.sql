CREATE TABLE IF NOT EXISTS t_checkout_products (
checkout_id     integer not null,
product_id      integer not null,
CONSTRAINT FK_CheckProduct FOREIGN KEY (product_id)   REFERENCES products (product_id),
CONSTRAINT FK_CheckCheck   FOREIGN KEY (checkout_id)  REFERENCES t_checkout (checkout_id)
) engine=InnoDB;