CREATE TABLE sale (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   price DOUBLE PRECISION,
   description VARCHAR(255),
   payment_method VARCHAR,
   date TIMESTAMP,
   CONSTRAINT pk_sale PRIMARY KEY (id)
);