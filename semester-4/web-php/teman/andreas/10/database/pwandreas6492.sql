CREATE DATABASE pwandreas6492;

USE pwandreas6492;

CREATE TABLE users (
    id INT AUTO_INCREMENT NOT NULL;
    username VARCHAR(255) NOT NULL;
    password VARCHAR(255) NOT NULL;
    status VARCHAR(255);
    PRIMARY KEY (id);
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
