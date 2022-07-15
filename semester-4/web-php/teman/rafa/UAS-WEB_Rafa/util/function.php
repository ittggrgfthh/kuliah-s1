<?php
require "connection.php";

function query($query)
{
    global $conn;
    $result = mysqli_query($conn, $query);
    $rows = [];
    while ($row = mysqli_fetch_assoc($result)) {
        $rows[] = $row;
    }
    // mysqli_close($conn);
    return $rows;
}

function insert($val)
{
    global $conn;
    $idBarang = $val["idBarang"];
    $kategori = $val["kategori"];
    $namaBarang = $val["namaBarang"];
    $merk = $val["merk"];
    $stok = (int)$val["stok"];
    $hargaBeli = (int)$val["hargaBeli"];
    $hargaJual =  (int)$val["hargaJual"];
    $satuan = $val["satuan"];


    $query = "INSERT INTO barang VALUES ('$idBarang', '$kategori', '$namaBarang', '$merk', $stok, $hargaBeli, $hargaJual, '$satuan' )";

    mysqli_query($conn, $query);


    $rowAffected = mysqli_affected_rows($conn);
    mysqli_close($conn);

    return $rowAffected;
}

function delete($idBarang)
{
    global $conn;
    mysqli_query($conn, "DELETE FROM barang WHERE id_barang = '$idBarang'");

    $rowAffected = mysqli_affected_rows($conn);
    mysqli_close($conn);

    return $rowAffected;
}

function update($val)
{
    // 
    global $conn;
    $idBarang = $val["idBarang"];
    $kategori = $val["kategori"];
    $namaBarang = $val["namaBarang"];
    $merk = $val["merk"];
    $stok = $val["stok"];
    $hargaBeli = $val["hargaBeli"];
    $hargaJual =  $val["hargaJual"];
    $satuan = $val["satuan"];

    $query = "UPDATE barang SET id_barang = '$idBarang', kategori = '$kategori', nama_barang = '$namaBarang', merk = '$merk', 
    stok = '$stok', harga_beli = '$hargaBeli', harga_jual = '$hargaJual', satuan = '$satuan' WHERE id_barang = '$idBarang'";

    mysqli_query($conn, $query);
    $rowAffected = mysqli_affected_rows($conn);
    mysqli_close($conn);

    return $rowAffected;
}

function search($keyword)
{
    $query = "SELECT * FROM barang WHERE id_barang LIKE '%$keyword%' OR nama_barang LIKE '%$keyword%'";
    return query($query);
}

function sortir()
{
    $query = "SELECT * FROM barang WHERE stok <= 0";
    return query($query);
}

function updateStok($val)
{
    global $conn;
    $idBarang = $val["idBarang"];
    $stok = $val["stok"];

    $query = "UPDATE barang SET stok = $stok WHERE id_barang = '$idBarang'";

    mysqli_query($conn, $query);
    $rowAffected = mysqli_affected_rows($conn);
    mysqli_close($conn);

    return $rowAffected;
}
