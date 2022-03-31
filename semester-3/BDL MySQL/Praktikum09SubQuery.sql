--ini adalah sql untuk tugas praktikum 09 sub query (1 desember 2021)

--sql dibawah ini adalah untuk latihan
--membuat database baru (opsional)
CREATE DATABASE dbpraktikum09_SubQuery;

-- 1.membuat tabel gaji
CREATE TABLE gaji (
    npp CHAR(5),
    nama VARCHAR(20) NOT NULL,
    gaji INT NOT NULL,
    kota VARCHAR(20) NOT NULL
);

--mengisi values tabel gaji
INSERT INTO gaji VALUES 
    ("10001", "Mahendra", 7500000, "Semarang"),
    ("10002", "Maharani", 7000000, "Semarang"),
    ("10003", "Dika", 6500000, "Jakarta"),
    ("10003", "Dimas", 5000000, "Bandung"),
    ("10004", "Dita", 5500000, "Bandung"),
    ("10006", "Damar", 6250000, "Jakarta"),
    ("10005", "Hanif", 5000000, "Solo"),
    ("10007", "Citra", 5750000, "Solo"),
    ("10008", "Indra", 9500000, "Semarang"),
    ("10009", "Melinda", 8000000, "Surabaya"),
    ("10010", "Mitza", 8500000, "Surabaya");

-- 2.buat perintah berikut
SELECT * 
FROM gaji 
WHERE gaji = (SELECT MAX(gaji) FROM gaji);

-- 3.buat tabel mhs dan krs sebagai berikut :
CREATE TABLE mhs (
    nim CHAR(14),
    nama VARCHAR(30) NOT NULL,
    PRIMARY KEY (nim)
);

CREATE TABLE krs (
    nim CHAR(14),
    sks INT,
    PRIMARY KEY (nim)
);

--mengisi values mhs
INSERT INTO mhs VALUES 
    ("A12.2019.06000", "Data"),
    ("A12.2019.06001", "Leni"),
    ("A12.2019.06002", "Rafia"),
    ("A12.2019.06003", "Wardah"),
    ("A12.2019.06004", "Wahyu Lestari"),
    ("A12.2019.06005", "Lukman Nurjadi"),
    ("A12.2019.06008", "Satria Piningit");

--mengisi values krs
INSERT INTO krs VALUES 
    ("A12.2019.06001", 20),
    ("A12.2019.06002", 22),
    ("A12.2019.06005", 22),
    ("A12.2019.06008", 18);

-- 4.buat perintah berikut :
SELECT nim,nama 
FROM mhs
WHERE EXISTS (SELECT * FROM krs WHERE krs.nim = mhs.nim);

-- 5.buat perintah berikut :
SELECT nim, nama 
FROM mhs
WHERE NOT EXISTS (SELECT * FROM krs WHERE krs.nim = mhs.nim);

-- 6.buat perintah berikut :
SELECT nama, gaji 
FROM gaji
WHERE gaji > ANY(SELECT gaji FROM gaji);

-- 7.buat perintah berikut :
SELECT nama, gaji 
FROM  gaji
WHERE gaji < ALL(SELECT gaji FROM gaji WHERE kota = "Semarang");