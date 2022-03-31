-- A. membuat database baru
CREATE DATABASE dbPraktikum14_Index;

-- B. Membuat tabel
-- 1. membuat tabel peserta
CREATE TABLE peserta (nopeserta INT, nama VARCHAR(10), nilai INT);
DELIMITER //
CREATE PROCEDURE insertdata()
    BEGIN
    DECLARE a INT;
    set a = 100000;
    while a < 200001 DO
            INSERT INTO peserta VALUES (a, 'nama', 85);
            set a = a + 1;
    END WHILE;
END //

DELIMITER ;

-- 2. membuat tabel peserta01 (duplikat dari tabel peserta)
CREATE TABLE peserta01 LIKE peserta;
INSERT INTO peserta01 VALUES 
    SELECT * FROM peserta;

-- 3. membuat tabel hasil
CREATE TABLE hasil (nopeserta INT, hasil VARCHAR(10));
DELIMITER //
CREATE PROCEDURE insertdatahasil()
    BEGIN
    DECLARE a INT;
    SET a = 110000;
    WHILE a < 180001 DO
            INSERT INTO hasil VALUES (a, 'Lulus');
            SET a = a + 1;
    END WHILE;
END //
DELIMITER ;
CALL insertdatahasil();

-- C. Buatlah Index:
CREATE INDEX index01 ON peserta(nopeserta);

-- D. Perhatikan waktu yang dibutuhkan !
-- 1. menampilkan beberapa data tabel peserta
SELECT * FROM peserta;
-- 2. menampilkan data tabel peserta01
SELECT * FROM peserta01;
-- 3. menampilkan data tabel hasil
SELECT * FROM hasil;
-- 4. menampilkan data tabel peserta dengan where nopeserta
SELECT * FROM peserta WHERE nopeserta = 110000;
-- 5. menampilkan data tabel peserta01 dengan where nopeserta 
SELECT * FROM peserta01 WHERE nopeserta = 110000;
-- 6. menampilkan data tabel peserta dengan join hasil
SELECT p.nopeserta, p.nama, h.hasil
FROM peserta INNER JOIN hasil h
WHERE p.nopeserta = h.nopeserta;
-- 7. menampilkan data tabel peserta01 dengan join hasil
SELECT p.nopeserta, p.nama, h.hasil
FROM peserta01 p INNER JOIN hasil h
WHERE p.nopeserta = h.nopeserta;
