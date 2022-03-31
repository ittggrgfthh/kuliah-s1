-- membuat database baru
CREATE DATABASE uasteori;

-- 1. membuat tabel untuk menyimpan data barang pada suatu toko online
-- a. jumlah field/kolom pada tabel tersebut sebanyak 10 record
CREATE TABLE barang (
    id_barang CHAR(6),
    nama_barang VARCHAR(20), 
    kategori VARCHAR(15), 
    satuan VARCHAR(15), 
    jumlah INT, 
    tgl_kadaluarsa DATE, 
    tgl_beli DATE, 
    harga INT, 
    berat VARCHAR(10), 
    merk VARCHAR(15), 
    PRIMARY KEY (id_barang) 
);

-- b. isikan data pada tabel sebanyak 10 record
INSERT INTO barang VALUES 
    ('B0001','shampo','alat mandi','botol',100,'2022-09-01','2022-01-01',50000,'1 L','SA'),
    ('B0002','freshcoffe','minuman','kaleng',200,'2023-08-11','2022-01-02',5000,'250 mL','W&M'),
    ('B0003','snack medusa','makanan','bungkus',150,'2025-12-15','2022-01-03',13000,'500 gr','CAP'),
    ('B0004','wajan mars','alat masak','buah',50,'2030-09-12','2022-01-04',300000,'1 kg','myoko'),
    ('B0005','lumpia enak','makanan','buah',70,'2022-12-12','2022-01-05',2000,'100 gr','Banu'),
    ('B0006','spatula','alat masak','buah',30,'2030-08-16','2022-01-06',56000,'200 gr','Jagad'),
    ('B0007','microwave xtra','alat masak','buah',20,'2050-12-31','2022-01-07',1000000,'2 kg','King'),
    ('B0008','panci ABC','alat masak','buah',25,'2026-06-05','2022-01-08',400000,'1 kg','B-Tree'),
    ('B0009','sambal CAB','pelengkap','botol',100,'2027-02-25','2022-01-09',10000,'250 gr','BCA'),
    ('B0010','Kipas angin ','perabotan','buah',50,'2060-03-19','2022-01-10',600000,'1 kg','Tornado'); 

-- c. gambarkan data yang telah dimasukkan dalam bentuk tabel
-- lu gambar aja tabelnya
SELECT * FROM barang;

-- 2. nama database = dbUASXXXXX (XXXXX = 5 digit NIM terakhir), ini ga tahu namanya beneran database atau tabel, 
-- buatlah trigger dengan nama trigger01 : dimana saat data tabel perbaikan diinput maka field nilai(tabel Nilai) akan berubah
-- jika nilai(tabel perbaikan) yang diinputkan lebih besar dari nilai(tabel nilai) sesuai dengan data NIM dan Matakuliah

-- tabel nilai
CREATE TABLE nilai (
    NIM CHAR(5),
    Nama VARCHAR(20),
    Matakuliah VARCHAR(20),
    Nilai CHAR(1)
);
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
INSERT INTO perbaikan VALUES 
    ('17004','Agama','2020-10-11','A'),
    ('17004','Bahasa','2020-10-20','B');

-- membuat trigger01
CREATE TRIGGER trigger01
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


-- 3. sebutkan 3 keuntungan view dan berikan contohnya (lengkap dengan tabel dasar dan hasil select view saat dijalankan)!
-- Keuntungan view adalah :
-- 1. Query yang kompleks dapat di sembunyikan sehingga informasi dapat diakses dengan cepat
-- 2. Untuk mengatur data tertentu menjadi tersembunyi bagi pemakai
-- 3. Untuk melindungi data yang bersifat rahasia
-- contoh :   
CREATE VIEW barang_toko AS
SELECT nama_barang, kategori, satuan, jumlah, tgl_kadaluarsa
FROM barang;

-- 4. dengan menggunakan xampp, masuklah ke root,
--  untuk membuat user memiliki command : CREATE USER 'nama_user'@'host' IDENTIFIED BY 'password'
-- contoh : CREATE USER 'farhan'@'localhost' IDENTIFIED BY 'abcd';
--  untuk memberikan izin akses, memiliki command : GRANT jenis akses (nama_kolom) ON nama_database TO nama_user IDENTIFIED BY 'password'
-- contoh : GRANT ALL PRIVILEGES on *.* to 'farhan'@'localhost'; <- memberikan semua akses kepada semua database dan tabel