CREATE TABLE IF NOT EXISTS address (
    address_id SERIAL PRIMARY KEY,
    address VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    user_address_address_id INTEGER,
    CONSTRAINT fk_address_id FOREIGN KEY (user_address_address_id) REFERENCES address(address_id)
);