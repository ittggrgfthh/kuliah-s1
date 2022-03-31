--sql dibawah ini adalah untuk tugas

--A. 
--buatlah tabel berikut :
--1. tabel mhs
CREATE TABLE mhs (
    nim CHAR(14),
    noktp CHAR(16),
    nama VARCHAR(20),
    PRIMARY KEY (nim)
);

--mengisi values tabel mhs
INSERT INTO mhs VALUES 
    ("A12.2019.06000", "3374080123450001", "Data"),
    ("A12.2019.06001", "3374080123450002", "Leni"),
    ("A12.2019.06002", "3374080123450005", "Rafia"),
    ("A12.2019.06003", "3374080123450006", "Wardah"),
    ("A12.2019.06004", "3374080123450007", "Wahyu Lestari"),
    ("A12.2019.06005", "3374080123450008", "Lukman Nurjadi"),
    ("A12.2019.06008", "3374080123450009", "Satria Piningit");

--2. tabel krs
CREATE TABLE krs (
    nim CHAR(14),
    sks INT,
    PRIMARY KEY (nim)
);

--mengisi values krs
INSERT INTO krs VALUES 
    ("A12.2019.06001", 20),
    ("A12.2019.06002", 22),
    ("A12.2019.06005", 22),
    ("A12.2019.06008", 18);

--3. tabel mhsbank
CREATE TABLE mhsbank (
    noktp CHAR(16),
    bank VARCHAR(10),
    saldo INT
);

--mengisi values tabel mhsbank
INSERT INTO mhsbank VALUES 
    ("3374080123450001", "Mandiri", 1500000),
    ("3374080123450002", "BCA", 7500000),
    ("3374080123450002", "BPD", 1250000),
    ("3374080123450006", "BPD", 2250000),
    ("3374080123450007", "BPD", 250000),
    ("3374080123450007", "BNI", 50000),
    ("3374080123450007", "Mandiri", 1150000),
    ("3374080123450009", "BCA", 2250000);

--B. Jelaskan apa kegunaan dan output perintah berikut :
--1. 
SELECT * 
FROM mhs LEFT OUTER JOIN krs ON mhs.nim = krs.nim;

--2. 
SELECT * 
FROM krs RIGHT OUTER JOIN mhs ON mhs.nim = krs.nim;

--3.
SELECT * 
FROM mhs RIGHT OUTER JOIN krs ON mhs.nim = krs.nim;

--4.
SELECT nim, nama, bank, saldo 
FROM mhs RIGHT OUTER JOIN mhsbank ON mhs.noktp = mhsbank.noktp;

--5.
SELECT * 
FROM mhsbank
WHERE saldo = (SELECT MAX(saldo) FROM mhsbank);

--6.
SELECT nim, nama 
FROM mhs
WHERE EXISTS (SELECT * FROM mhsbank WHERE mhs.noktp = mhsbank.noktp);

--7.
SELECT nim, nama 
FROM mhs
WHERE NOT EXISTS (SELECT * FROM mhsbank WHERE mhs.noktp = mhsbank.noktp);

--8.
SELECT noktp, saldo 
FROM mhsbank
WHERE saldo > ANY (SELECT saldo FROM mhsbank);

--9.
SELECT noktp, saldo 
FROM mhsbank
WHERE saldo < ALL (SELECT saldo FROM mhsbank WHERE bank = "BCA");