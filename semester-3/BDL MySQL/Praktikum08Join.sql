--ini adalah sql setelah uts bdl 2021 (pertemuan 9 atau praktikum 8 Join)

--A. Buatlah tabel berikut pada database ProduksiFilm

-- membuat database
CREATE DATABASE dbpraktikum08_ProduksiFilm;

--membuat tabel pemeran
CREATE TABLE pemeran (
    kode_pemeran CHAR(5),
    nama VARCHAR(20) NOT NULL,
    tgl_lahir DATE,
    sex CHECK("P", "W") NOT NULL,
    PRIMARY KEY (kode_pemeran)
);

--membuat tabel film
CREATE TABLE film (
    kode_film CHAR(5),
    judul VARCHAR(30) NOT NULL,
    tahun YEAR(4),
    PRIMARY KEY (kode_film)
);

--membuat tabel peran yang akan diperankan oleh pemeran
CREATE TABLE mainsbg (
    kode_pem CHAR(5),
    kode_film CHAR(5),
    peran VARCHAR(20) NOT NULL
);

--mengisi values tabel pemeran
INSERT INTO pemeran VALUES 
    ("P0001", "Mahendra", "1975-02-22", "P"),
    ("P0002", "Maharani", "1982-01-03", "W"),
    ("P0003", "Dhika", "1995-09-28", "P"),
    ("P0004", "Budi Utami", "1974-05-09", "W"),
    ("P0005", "Adi Nugroho", "1989-03-20", "P"),
    ("P0006", "Anindita", "1993-11-10", "W"),
    ("P0007", "Citra", "1992-05-27", "W"),
    ("P0008", "Dini", "1990-12-25", "W"),
    ("P0009", "Firly", "1988-07-15", "P"),
    ("P0010", "Putri", "1994-10-11", "W"),
    ("P0011", "Melinda", "1996-07-25", "W"),
    ("P0012", "Mitza", "1997-12-27", "W"),
    ("P0013", "Aji Prakoso", "1991-05-17", "P"),
    ("P0014", "Valiant", "1996-12-15", "P"),
    ("P0015", "Jovita", "1988-07-17", "W");

--mengisi values tabel film
INSERT INTO film VALUES 
    ("F0001", "Di Atas Angan", "1999"),
    ("F0002", "Di Bawah Kolong", "1985"),
    ("F0003", "Embun Pagi", "1995"),
    ("F0004", "Perang Bintang", "1974"),
    ("F0005", "Pahlawan Kemerdekaan", "1989"),
    ("F0006", "Merdeka atau Mati", "1993"),
    ("F0007", "Serat Centhini", "1992"),
    ("F0008", "Daun-daun Berisik", "1990"),
    ("F0009", "Kabut Sutra Ungu", "1987"),
    ("F0010", "Kaki Gunung", "1974"),
    ("F0011", "Titisan Dewa", "1989"),
    ("F0012", "Pendekar Kelana", "1993"),
    ("F0013", "Wali Songo", "1992"),
    ("F0014", "Di Bawah Kabut", "1990"),
    ("F0015", "Serangan Umum 1 Maret", "1988");

--mengisi values tabel mainsbg
INSERT INTO mainsbg VALUES 
    ("P0005", "F0001", "Nia"),
    ("P0005", "F0002", "Ani"),
    ("P0002", "F0003", "Tika"),
    ("P0002", "F0004", "Ika"),
    ("P0002", "F0011", "Putri"),
    ("P0001", "F0005", "Dita"),
    ("P0003", "F0004", "Dika"),
    ("P0008", "F0007", "Rangga"),
    ("P0007", "F0009", "Bima"),
    ("P0007", "F0008", "Mentari"),
    ("P0004", "F0010", "Santi"),
    ("P0003", "F0012", "Sinta"),
    ("P0003", "F0013", "Melani"),
    ("P0010", "F0014", "Sunan Kali Jogo"),
    ("P0011", "F0014", "Sunan Gunung Jati"),
    ("P0006", "F0015", "Komandan"),
    ("P0012", "F0015", "Pejuang 1");


--B. Cobalah perintah relasi berikut :


--1.
SELECT mainsbg.kode_pem, film.judul, mainsbg.peran 
FROM mainsbg, film 
WHERE mainsbg.kode_film = film.kode_film;
    

--2.
SELECT mainsbg.kode_pem, film.judul, mainsbg.peran 
FROM mainsbg, film 
WHERE mainsbg.kode_film = film.kode_film ORDER BY mainsbg.kode_pem;

--3.
SELECT a.kode_pem, b.judul, a.peran 
FROM mainsbg a, film b 
WHERE a.kode_film = b.kode_film;

--4.
SELECT pe.nama, fi.judul, ma.peran 
FROM pemeran pe, film fi, mainsbg ma 
WHERE ma.kode_film = fi.kode_film AND ma.kode_pem = pe.kode_pemeran;

--5. 
SELECT x.nama, y.nama 
FROM pemeran x, pemeran y 
WHERE x.sex = "P" AND y.sex = "W";

--6.
SELECT p.nama, m.kode_film, m.peran 
FROM pemeran p INNER JOIN  mainsbg m 
WHERE p.kode_pemeran = m.kode_pem;

--7.
SELECT p.kode_pemeran, p.nama, m.kode_pem, m.kode_film 
FROM pemeran p NATURAL JOIN mainsbg m;

--C. Buatlah tabel berikut

--membuat tabel nasabah
CREATE TABLE nasabah (
    no_nasabah CHAR(4),
    nama VARCHAR(20) NOT NULL,
    jenis_kelamin CHECK("LK", "PR") NOT NULL,
    Tgl_lahir DATE,
    PRIMARY KEY (no_nasabah)
);

--membuat tabel transaksi
CREATE TABLE transaksi (
    no_transaksi CHAR(8),
    jenis CHAR(5) NOT NULL,
    no_nasabah CHAR(4),
    tanggal DATE,
    jumlah INT,
    PRIMARY KEY (no_transaksi)
);

--memasukkan values tabel nasabah
INSERT INTO nasabah VALUES
    ("1001", "Adi", "LK", "2000-04-01"),
    ("1002", "Budi", "LK", "2000-02-14"),
    ("1003", "Cintia", "PR", "2001-05-21"),
    ("1004", "Dita", "PR", "2000-12-12"),
    ("1005", "Endang", "PR", "2000-04-10"),
    ("1006", "Frida", "PR", "2000-01-01"),
    ("1007", "Gunung", "LK", "2000-02-28"),
    ("1008", "Handoyo", "LK", "2001-01-21"),
    ("1009", "Indah", "PR", "2001-01-29"),
    ("1010", "Joko", "LK", "2001-03-18"),
    ("1011", "Karno", "LK", "2001-02-02"),
    ("1012", "Leni", "PR", "2001-03-18"),
    ("1013", "Muris", "PR", "2000-09-19"),
    ("1014", "Nur", "PR", "2000-12-24"),
    ("1015", "Oriano", "LK", "2000-04-14");

--memasukkan values tabel Transaksi
INSERT INTO  transaksi VALUES
    ("21001101", "Tarik", "1001", "2021-11-08", 1000),
    ("21001102", "Setor", "1002", "2021-11-08", 200),
    ("21001103", "Tarik", "1004", "2021-11-08", 1500),
    ("21001104", "Tarik", "1012", "2021-11-08", 5000),
    ("21001105", "Setor", "1007", "2021-11-09", 4000),
    ("21001106", "Tarik", "1002", "2021-11-09", 2500),
    ("21001107", "Tarik", "1010", "2021-11-22", 8000),
    ("21001108", "Tarik", "1005", "2021-11-22", 7500),
    ("21001109", "Setor", "1015", "2021-11-22", 500),
    ("21001110", "Setor", "1010", "2021-11-22", 150),
    ("21001111", "Tarik", "1011", "2021-11-24", 200);

--D.

--1. Siapa saja nasabah yang melakukan transaksi pada tanggal 08/11/2021?
SELECT a.nama, a.no_nasabah,b.tanggal 
FROM nasabah a, transaksi b 
WHERE b.tanggal = "2021-11-08" AND a.no_nasabah = b.no_nasabah;

--2. Siapa saja nasabah yang melakukan transaksi penarikan pada tanggal 08/11/2021?
SELECT a.nama, a.no_nasabah,b.tanggal 
FROM nasabah a, transaksi b 
WHERE b.tanggal = "2021-11-08" AND a.no_nasabah = b.no_nasabah AND b.jenis = "Tarik";

--3. Berapa total jumlah penarikan pada tanggal 22/11/2021?
SELECT COUNT(jenis)
FROM transaksi
WHERE tanggal = "2021-11-22" AND jenis = "Tarik";

--4. Berapa total setoran nasabah dengan nama Oriano pada tanggal 22/11/2021
SELECT a.nama, SUM(b.jumlah)
FROM nasabah a, transaksi b
WHERE b.tanggal = "2021-11-22" AND b.jenis = "Setor" AND a.nama = "Oriano" AND a.no_nasabah = b.no_nasabah;
