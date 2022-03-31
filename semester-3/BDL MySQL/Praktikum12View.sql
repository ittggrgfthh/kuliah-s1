CREATE DATABASE dbPraktikum12_View;

CREATE TABLE barang (
    kode CHAR(5),
    nama VARCHAR(20),
    jenis VARCHAR(15),
    harga INT,
    jumlah INT,
    pemasok CHAR(5)
);

INSERT INTO barang VALUES 
    ('10001','Buku123','ATK','12500','140','101'),
    ('10002','Buku007','ATK','5500','220','505'),
    ('10003','Pensil Panjang','ATK','1000','250','101'),
    ('10004','Indomei Udang','Makanan','2500','0','201'),
    ('10005','Indomei Kentang','Makanan','3000','100','201'),
    ('10006','Mouse','Komputer','20000','10','101'),
    ('10007','Mangga','Buah','10000','10','201'),
    ('10008','Permen','Makanan','10000','20','201'),
    ('10009','Teh Kotak','Minuman','4000','25','101'),
    ('10010','Teh Botol','Minuman','4500','25','101'),
    ('10011','Penggaris','ATK','3500','45','101'),
    ('10012','Spidol','ATK','7000','20','101');

CREATE TABLE jual (
    notrans CHAR(5),
    tgl DATE,
    kode CHAR(5),
    jumlah INT,
);

INSERT INTO jual VALUES 
    ('T0001','2020-12-01','10001','13'),
    ('T0002','2020-12-12','10003','6'),
    ('T0003','2020-12-30','10012','3'),
    ('T0004','2020-12-30','10008','20'),
    ('T0005','2021-01-06','10012','3'),
    ('T0006','2021-01-06','10010','10'),
    ('T0007','2021-01-14','10006','1'),
    ('T0008','2021-01-19','10010','5');
INSERT INTO jual VALUES 
    ('T0009','2021-12-01','10009','5'),
    ('T0010','2021-12-01','10007','4'),
    ('T0011','2021-12-22','10005','40'),
    ('T0012','2021-12-22','10005','30');

INSERT INTO jual VALUES ('T0014','2021-12-23','10005','10');



--1.
CREATE VIEW jumlahbarang_minimal 
    AS
        SELECT kode, nama, jumlah, pemasok 
        FROM barang 
        WHERE jumlah < 10;

--2.
CREATE VIEW nilai_barang
    AS
        SELECT kode, nama, harga, jumlah, (harga * jumlah) AS total
        FROM barang ORDER BY total DESC;

--3.
CREATE VIEW jualbarang_terbanyak 
    AS
        SELECT a.kode, a.nama, a.harga, b.tgl, b.jumlah 
        FROM barang a, jual b
        WHERE a.kode = b.kode 
            AND MONTH(b.tgl) = MONTH(CURRENT_DATE()) 
            AND YEAR(b.tgl) = YEAR(CURRENT_DATE()) 
        ORDER BY b.jumlah DESC;

--4.
CREATE VIEW jualbarang_nol
    AS
        SELECT DISTINCT barang.kode, barang.nama, barang.harga, barang.jumlah 
        FROM barang
        WHERE NOT EXISTS (SELECT * 
                          FROM  jual
                          WHERE jual.kode = barang.kode
            AND MONTH(jual.tgl) < MONTH(CURRENT_DATE()) 
            AND YEAR(jual.tgl) <= YEAR(CURRENT_DATE()));

--5.
CREATE VIEW total_penjualan
    AS
        SELECT SUM(b.jumlah * a.harga) AS total 
        FROM barang a, jual b
        WHERE a.kode = b.kode
        AND b.tgl = CURRENT_DATE();