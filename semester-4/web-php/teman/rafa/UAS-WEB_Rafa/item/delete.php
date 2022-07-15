<?php
require dirname(__DIR__) . "../util/function.php";

$idBarang = $_GET["id-barang"];

$barang = query("SELECT * FROM barang WHERE id_barang = '$idBarang'")[0];
// $file = __DIR__ . "/imgs/" . $barang['filegbr'];

if (delete($idBarang) > 0) {
    header("Location: index.php?delete=true&id-barang=$idBarang");
    // unlink($file);
} else {
    header("Location: index.php?delete=false&id-barang=$idBarang");
}
exit();
