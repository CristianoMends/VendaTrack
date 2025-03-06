CREATE TABLE item (
    id BIGINT NOT NULL,
    price NUMERIC NOT NULL,
    description VARCHAR(255),
    CONSTRAINT pk_item PRIMARY KEY (id)
);