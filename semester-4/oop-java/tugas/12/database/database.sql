-- Masuk ke SQL
-- mysql - u root
-- membuat database
CREATE DATABASE kuliah_pbo_12;

-- menggunakan database
USE kuliah_pbo_12;

-- drop table
-- DROP TABLE pegawai;
-- DROP TABLE barang;
-- DROP TABLE jual;
-- membuat tabel pegawai
CREATE TABLE pegawai (
    nip VARCHAR(30) NOT NULL,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(30) NOT NULL,
    gender VARCHAR(15) NOT NULL,
    `password` VARCHAR(50) NOT NULL
) ENGINE = InnoDB;

INSERT INTO
    pegawai (nip, name, department, gender, `password`)
VALUES
    (
        "001",
        "ittggrgfthh",
        "Administator",
        "Laki-Laki",
        "123"
    ),
    (
        "A12.2020.06476",
        "Farhan Taqi Abdussalam",
        "Direktur",
        "Laki-Laki",
        "123"
    );

-- membuat tabel barang
CREATE TABLE barang (
    id VARCHAR(30) NOT NULL,
    name VARCHAR(50) DEFAULT NULL,
    selling_price INT(12) DEFAULT NULL,
    purchase_price INT(12) DEFAULT NULL,
    amount INT(8) DEFAULT NULL
) ENGINE = InnoDB;

-- melihat isi pada tabel pegawai dengan nip "2222"
SELECT
    *
FROM
    pegawai
WHERE
    nip = '2222';

-- menghapus/delete semua data barang
DELETE FROM
    barang;

-- menambahkan/memasukan/insert/input barang
INSERT INTO
    barang (
        id,
        name,
        selling_price,
        purchase_price,
        amount
    )
VALUES
    ("001", "Buku Tulis Falcon", 6000, 5000, 200),
    ("002", "ATK Lengkap", 40000, 34000, 150),
    ("003", "Sendal Swallow", 7500, 6000, 90),
    ("004", "Kamera Mainan", 15000, 10000, 70),
    ("005", "Biskuit Khong Guan", 25000, 20000, 100);

-- membuat tabel jual
CREATE TABLE jual (
    transaction_id VARCHAR(30) DEFAULT NULL,
    id_item VARCHAR(30) DEFAULT NULL,
    price_item INT(12) DEFAULT NULL,
    amount_item INT(8) DEFAULT NULL
) ENGINE = InnoDB;

-- DELETE FROM jual;