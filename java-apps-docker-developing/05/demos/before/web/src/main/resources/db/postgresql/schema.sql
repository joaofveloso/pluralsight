DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS categories;

CREATE TABLE categories (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX categories_name ON categories (name);

CREATE TABLE books (
  id   SERIAL PRIMARY KEY,
  category_id INTEGER,
  author VARCHAR(80),
  title VARCHAR(80),
  rating NUMERIC(10, 2),
  price NUMERIC(10, 2),
  pages INTEGER,
  isbn10 VARCHAR(10),
  isbn13 VARCHAR(14),
  publisher VARCHAR(200),
  image VARCHAR(80),
  description VARCHAR(2000)
);
ALTER TABLE books ADD CONSTRAINT fk_category_books FOREIGN KEY (category_id) REFERENCES categories (id);