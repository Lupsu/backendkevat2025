DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS vendors;
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS subscriptions;

CREATE TABLE roles (
    role_id INT GENERATED ALWAYS AS IDENTITY,
    role_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (role_id)
);

CREATE TABLE users (
    user_id INT GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(50) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    passwordhash VARCHAR(150) NOT NULL,
    role_id INT NOT NULL,
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles (role_id),
    PRIMARY KEY (user_id)
);

CREATE TABLE vendors (
    vendor_id INT GENERATED ALWAYS AS IDENTITY,
    vendor_name VARCHAR(150) NOT NULL,
    PRIMARY KEY (vendor_id)
);

CREATE TABLE transactions (
    transaction_id INT GENERATED ALWAYS AS IDENTITY,
    user_id INT NOT NULL,
    subscription_id INT NOT NULL,
    buy_price NUMERIC(10,2) NOT NULL,
    purchase_date DATE NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT fk_subscription FOREIGN KEY (subscription_id) REFERENCES subscriptions (subscription_id),
    PRIMARY KEY (transaction_id)
);

CREATE TABLE subscriptions (
    subscription_id INT GENERATED ALWAYS AS IDENTITY,
    subscription_name VARCHAR(150) NOT NULL,
    vendor_id INT NOT NULL,
    subscription_description VARCHAR(500) NOT NULL,
    subscription_erp_price NUMERIC(10,2) NOT NULL,
    CONSTRAINT fk_vendor FOREIGN KEY (vendor_id) REFERENCES vendors (vendor_id),
    PRIMARY KEY (subscription_id)
);

INSERT INTO roles (role_name)
VALUES ('USER'), ('ADMIN');

INSERT INTO users (username, first_name, last_name, email, passwordhash, role_id)
VALUES ('jluuppala', 'Jani', 'Luuppala', 'jani.luuppala@outlook.com', '$2y$10$buRRGcT9FeQBxIQ/B9xeqea7MyL2tXw5HWYpQscWF5rOUoOWxL2G.', 1),
('mmottonen', 'Matti', 'Möttönen', 'matti.mottonen@gmail.com', '$2y$10$mFJ33VZ/cdty1Cf0VzIYDudCwjnQeNqfg5fECSKfzllQWgAW2a.3a', 1),
('appadmin', 'Admin', 'Adminstrator', 'admin@app.com', '$2y$10$RSJWGhTkMY3AMMpqmIzjsOqROjlJH2S3cPS4jU7EoN.QHW.HRtGWK', 2);

INSERT INTO vendors (vendor_name)
VALUES ('Netflix'), ('Disney'), ('HBO'), ('Ruutu+'), ('MTV Katsomo'), ('AppleTV');

INSERT INTO subscriptions (subscription_name, vendor_id, subscription_description, subscription_erp_price)
VALUES ('Basic Plan', 1, 'Allows streaming on one device at a time in standard definition (SD).', 8),
('Standard Plan', 1, 'Allows streaming on two devices simultaneously in high definition (HD).', 15.49),
('Premium Plan', 1, 'Allows streaming on four devices at once in ultra-high definition (4K).', 22.99),
('Basic', 2, 'With advertising.', 10),
('Premium', 2, 'No advertising', 16),
('Basic with Ads', 3, 'Stream on 2 devices at once, Full HD resolution. Includes ads.', 5.99),
('Standard', 3, 'Stream on 2 devices at once, Full HD resolution. No ads. 30 downloads.', 9.99),
('Premium', 3, 'Stream on 4 devices at once, 4K UHD resolution, Dobly Atmos as available. No ads. 100 downloads.', 13.99),
('Ruutu+', 4, 'Ruutu+ mainoksilla', 9.99),
('MTV KAtsomo+', 5, 'MTV Katsomo+ mainoksilla', 7.95),
('Apple TV+', 6, 'Share subscription up to five people, no ads', 9.99);

INSERT INTO transactions (user_id, subscription_id, buy_price, purchase_date)
VALUES (1, 3, 22.99, '2025-01-15'), (1, 5, 16, '2025-02-01'), (2, 9, 9.99, '2024-11-13'), (2, 10, 7.95, '2024-07-10');