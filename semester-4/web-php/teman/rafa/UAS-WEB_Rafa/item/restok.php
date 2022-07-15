<?php
require dirname(__DIR__) . "/util/function.php";

if (isset($_POST["restok"])) {
    $idBarang = $_POST["id-barang"];
    $request = [
        "idBarang" => $idBarang,
        "stok" => $_POST["stok"] == "" ? 0 : (int)$_POST["stok"],
    ];
    if (updateStok($request) > 0) {
        header("Location: index.php?restok=true&id-barang={$idBarang}");
    } else {
        header("Location: index.php?restok=false&id-barang={$idBarang}");
    }
} else {
    header("Location: index.php");
    exit();
};
