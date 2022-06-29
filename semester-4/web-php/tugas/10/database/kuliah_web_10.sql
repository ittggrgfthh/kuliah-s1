CREATE DATABASE kuliah_web_10;

USE kuliah_web_10;

CREATE TABLE users (
    id INT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    status VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO users (
    username,
    password,
    status
) VALUES (
    'mhs',
    'mhs',
    'mhs'
);

CREATE TABLE barang (
    kdbrg CHAR(10),
    nmbrg VARCHAR(50),
    hrgbrg DOUBLE,
    filegbr VARCHAR(50),
    PRIMARY KEY (kdbrg)
);