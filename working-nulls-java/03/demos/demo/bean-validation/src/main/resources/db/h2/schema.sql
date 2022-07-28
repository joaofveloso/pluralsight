DROP TABLE books IF EXISTS;

CREATE TABLE books (
  id   INTEGER IDENTITY PRIMARY KEY,
  author VARCHAR(80),
  title VARCHAR(80),
  rating DECIMAL(10, 2),
  price DECIMAL(10, 2),
  pages INTEGER,
  isbn10 VARCHAR(10),
  isbn13 VARCHAR(14),
  publisher VARCHAR(200),
  image VARCHAR(80),
  description VARCHAR(2000)
);