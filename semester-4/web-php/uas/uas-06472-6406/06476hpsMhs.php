<?php
//memanggil file pustaka fungsi
require "06476fungsi.php";

//memindahkan data kiriman dari form ke var biasa
$id = $_GET["kode"];

//membuat query hapus data
$sql = "delete from mhs where id=$id";
mysqli_query($koneksi, $sql);
header("location:06476updateMhs.php");
