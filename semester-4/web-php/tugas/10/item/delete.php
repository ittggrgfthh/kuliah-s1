<?php
require dirname(__DIR__) . "../util/function.php";

$kodeBarang = $_GET["kdbrg"];

$barang = query("SELECT * FROM barang WHERE kdbrg = '$kodeBarang'")[0];
$file = __DIR__ . "/imgs/" . $barang['filegbr'];

if (delete($kodeBarang) > 0) {
    header("Location: index.php?delete=true&kode-barang=$kodeBarang");
    unlink($file);
} else {
    header("Location: index.php?delete=false&kode-barang=$kodeBarang");
}
exit();
