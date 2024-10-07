CREATE TABLE item (
  id UUID NOT NULL,
   price DOUBLE PRECISION,
   description VARCHAR(255),
   CONSTRAINT pk_item PRIMARY KEY (id)
);