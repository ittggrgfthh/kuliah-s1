CREATE DATABASE UAS_WEB;

USE UAS_WEB;

CREATE TABLE barang (
    id_barang CHAR(10),
    kategori VARCHAR(15),
    nama_barang VARCHAR(30),
    merk VARCHAR(15),
    stok INT,
    harga_beli INT,
    harga_jual INT,
    satuan VARCHAR(10),
    PRIMARY KEY (id_barang)
);

INSERT INTO barang VALUES
    ('BR003', 'Kuku Macan', 'Kuku macan ulir 2206', 'Uliran', 0 , 2000, 3000, 'PCS'),
    ('BR002', 'Keramik', "Arw 3307 40'40", 'Arwana', 50 , 27500, 40000, 'PCS'),
    ('BR001', 'Keramik', 'ARW 30 x 30 Biege', 'Arwana', 100 , 35000, 40000, 'PCS');
