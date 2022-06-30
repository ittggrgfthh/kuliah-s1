<?php
require dirname(__DIR__) . "../util/function.php";

$kodeBarang = $_GET["kdbrg"];

if (delete($kodeBarang) > 0) {
    header("Location: index.php?delete=true&kode-barang=$kodeBarang");
} else {
    header("Location: index.php?delete=false&kode-barang=$kodeBarang");
}
exit();
