<?php
require dirname(__DIR__) . "/util/function.php";

$modal = false;
$message = "Gagal ditambahkan!";
$namaBarang = "";
$hargaBarang = "";
$gambarBarang = "";

if (isset($_GET["kdbrg"])) {
    $kodeBarang = $_GET["kdbrg"];
} else {
    header("Location: index.php");
    exit();
}

$brg = query("SELECT * FROM barang WHERE kdbrg = '$kodeBarang'")[0];

var_dump($brg);
die();

$message = "";



if (isset($_POST["update-item"])) {
    if (update($_POST) > 0) {
        $kodeBarang = $_POST["kode-barang"];
        header("Location: index.php?update=true&kode-barang='{$kodeBarang}'");
    } else {
        $alertType = "alert-danger";
        $message = "Gagal diperbarui";
    }
};
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Update Barang</title>
</head>

<body>
    <div class="container">
        <div class="my-4">
            <h1>Ubah Barang</h1>
            <?php if ($message) { ?>
                <div class="alert <?= $alertType ?> alert-dismissible fade show" role="alert">
                    <?= $message ?>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            <?php } ?>
        </div>
        <div>
            <form action="" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="kode-barang" class="form-label">Kode</label>
                    <input type="text" name="kode-barang" class="form-control" id="kode-barang" autocomplete="off" value="<?= $brg["kdbrg"] ?>" readonly>
                </div>
                <div class="mb-3">
                    <label for="nama-barang" class="form-label">Nama</label>
                    <input type="text" name="nama-barang" class="form-control" id="nama-barang" autocomplete="off" value="<?= $brg["nmbrg"] ?>">
                </div>
                <div class=" mb-3">
                    <label for="harga-barang" class="form-label">Harga</label>
                    <input type="text" name="harga-barang" class="form-control" id="harga-barang" autocomplete="off" value="<?= $brg["hrgbrg"] ?>">
                </div>
                <div class=" mb-3">
                    <label for="gambar-barang" class="form-label">Gambar</label>
                    <input type="file" name="gambar-barang" class="form-control" id="gambar-barang" autocomplete="off" value="<?= $brg["filegbr"] ?>">
                </div>
                <button type=" submit" name="update-item" class="btn btn-success">Update Barang</button>
            </form>
        </div>
    </div>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>

</html>