DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;

CREATE TABLE categories (category_id INT GENERATED ALWAYS AS IDENTITY
, category_name VARCHAR(150) NOT NULL
, PRIMARY KEY (category_id));

CREATE TABLE books
(book_id INT GENERATED ALWAYS AS IDENTITY
, category_id INT
, title VARCHAR(150) NOT NULL
, author VARCHAR(150) NOT NULL
, publicationyear NUMERIC(4) NOT NULL
, isbn NUMERIC(30) NOT NULL
, price NUMERIC(10,2) NOT NULL
, PRIMARY KEY (book_id)
, CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories (category_id)
);

CREATE TABLE users
(user_id INT GENERATED ALWAYS AS IDENTITY
, username VARCHAR(150) NOT NULL
, passwordhash VARCHAR(150) NOT NULL
, email VARCHAR(150) NOT NULL
, roletype VARCHAR(150) NOT NULL
);

INSERT INTO categories (category_name)
VALUES ('Fiktio'), ('Fantasia'), ('Lasten');

INSERT INTO books (title, author, publicationyear, isbn, price, category_id)
VALUES ('Sieppari ruispellossa', 'Kai Kuikka', 1995, 1234568790, 19.90, 1),
('Harri Patteri virta loppuu', 'Jaakko Kalevi Romula', 2000, 878654342, 39.90, 2),
('Kaislikossa kuhisee', 'Pasi Punkki', 1984, 1234568111, 29.90, 3);

INSERT INTO users (username, passwordhash, email, roletype)
VALUES ('user', '$2a$12$OvYk4LVNprMP15cY0Cw0nOYJ7loX5NQinYkLq25bLzqaFm0g3Zq..', 'jani@hassu.fi', 'USER'),
('admin', '$2y$10$NulP79iZOilqNpnovQYYkeoluWpSH1N6Lg1tmBGb/CrehJS/3obDm', 'admin@hassu.fi', 'ADMIN');
