-- 1. buatlah database penjualan06476 (06476 = 5 digit NIM terakhir)
CREATE DATABASE penjualan06476;
-- a. tabel barang06476
CREATE TABLE barang06476 (
    kode CHAR(5),
    nama VARCHAR(20),
    stock INT,
    satuan CHAR(4),
    harga INT,
    tglkadaluarsa DATE,
    PRIMARY KEY(kode)
);
INSERT INTO barang06476 VALUES
    ('11111','Buku ABC',20,'Buah',5000,'2025-02-18'),
    ('22222','Buku Batik',20,'Buah',7500,'2025-01-28'),
    ('33333','Buku Gelatik',20,'Buah',15000,'2022-10-15'),
    ('44444','Pensil HB',20,'Buah',2000,'2023-12-08'),
    ('55555','Roti Pisang',20,'Buah',4500,'2021-01-07'),
    ('66666','Aqua',20,'Buah',3500,'2022-01-10'),
    ('77777','Freshtea',20,'Buah',40000,'2021-06-15');

-- b. tabel jual06476
CREATE TABLE jual06476 (
    notrans CHAR(5),
    tanggal DATE,
    kode CHAR(5),
    jumlah INT
);
INSERT INTO jual06476 VALUES 
    ('21001','2021-01-04','22222',1),
    ('21001','2021-01-05','44444',2),
    ('21002','2021-01-06','66666',3),
    ('21002','2021-01-07','77777',4);

-- hapus tabel
DROP TABLE jual06476;

-- buatlah store procedure (nama = StoreProc06476) untuk menampilkan daftar barang
-- yang sudah terjual dengan penjualan kurang dari 3 buah sesuai dengan kondisi
-- tabel diatas.

DELIMITER //
DELIMITER;
CREATE PROCEDURE StoreProc06476()
BEGIN
    SELECT * 
    FROM barang06476
    WHERE EXISTS(SELECT * 
                FROM jual06476 
                WHERE jumlah < 3 AND kode = barang06476.kode);
END //
-- a. capture kode perintah store procedurenya!
-- b. capture output dari store procedure tersebut!

-- 2. buatlah database dengan nama dbUAS06476 (06476 = 5 digit NIM terakhir)
-- tabel nilai

CREATE DATABASE dbUAS06476;
CREATE TABLE nilai (
    NIM CHAR(5),
    Nama VARCHAR(20),
    Matakuliah VARCHAR(20),
    Nilai CHAR(1)
);

-- input data nilai
INSERT INTO nilai VALUES 
    ('17001','Adi','Agama','A'),
    ('17002','Brond','Matematika','B'),
    ('17003','Coco','Agama','D'),
    ('17004','Didi','Agama','C'),
    ('17004','Didi','Bahasa','C');

-- tabel perbaikan
CREATE TABLE perbaikan (
    NIM CHAR(5),
    Matakuliah VARCHAR(15),
    Tanggal DATE,
    Nilai CHAR(1)
);
DELIMITER //
-- membuat TRIGGER dengan nama TRIGGER06476 (06476 = 5 digit NIM terakhir)
CREATE TRIGGER Trigger06476
    BEFORE INSERT
    ON perbaikan
    FOR EACH ROW
    BEGIN
    DECLARE xnilai CHAR(1);
    SET xnilai = (
        SELECT nilai FROM nilai WHERE NIM = NEW.NIM 
        AND Matakuliah = NEW.Matakuliah
    );
        IF (NEW.nilai < xnilai) THEN
        UPDATE nilai
        SET
            nilai = NEW.nilai
        WHERE NEW.NIM = NIM AND NEW.Matakuliah = Matakuliah;
    END IF;
END //
DELIMITER ;
-- input data perbaikan
INSERT INTO perbaikan VALUES 
    ('17004','Agama','2020-10-11','A'),
    ('17004','Bahasa','2020-10-20','B');
-- a. capture kode perintah triggernya!
-- b. capture perintah input datanya, hasil perubahan data dari tabel Nilai dan perbaikan.

-- 3. buatlah view mysql seperti jawaban pada soal no.3 teori
-- a. capture kode perintah mysqlnya!
-- b. capture tabel dasarnya!
-- c. capture output viewnya!