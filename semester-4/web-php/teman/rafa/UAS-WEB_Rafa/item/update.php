<?php
require dirname(__DIR__) . "/util/function.php";

$modal = false;
$message = "";
$kategori = "";
$namaBarang = "";
$merk = "";
$stok = "";
$hargaBeli = "";
$hargaJual = "";
$satuan = "";

// var_dump($_GET);
// die();


if (isset($_GET["id-barang"])) {
    $idBarang = $_GET["id-barang"];
} else {
    header("Location: index.php");
    exit();
}

$barang = query("SELECT * FROM barang WHERE id_barang = '$idBarang'")[0];



if (isset($_POST["update-item"])) {
    $request = [
        "idBarang" => $_POST["id-barang"],
        "kategori" => $_POST["kategori"],
        "namaBarang" => $_POST["nama-barang"],
        "merk" => $_POST["merk"],
        "stok" => $_POST["stok"],
        "hargaBeli" => $_POST["harga-beli"],
        "hargaJual" => $_POST["harga-jual"],
        "satuan" => $_POST["satuan"],
    ];
    if (update($request) > 0) {
        $idBarang = $_POST["id-barang"];
        header("Location: index.php?update=true&id-barang='{$idBarang}'");
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
    <link rel="stylesheet" href="../css/mystyle.css">

    <title>Update Barang</title>
</head>

<body>
    <div class="flex-box">
        <div class="main-content">
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
                <form action="" method="post" enctype="multipart/form-data" class="my-4">
                    <div class="mb-3">
                        <label for="id-barang" class="form-label">ID Barang</label>
                        <input type="text" name="id-barang" class="form-control" id="id-barang" autocomplete="off" value="<?= $barang["id_barang"] ?>" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="kategori" class="form-label">Kategori</label>
                        <input type="text" name="kategori" class="form-control" id="kategori" autocomplete="off" value="<?= $barang["kategori"] ?>">
                    </div>
                    <div class="mb-3">
                        <label for="nama-barang" class="form-label">Nama Barang</label>
                        <input type="text" name="nama-barang" class="form-control" id="nama-barang" autocomplete="off" value="<?= $barang["nama_barang"] ?>">
                    </div>
                    <div class="mb-3">
                        <label for="merk" class="form-label">Merk</label>
                        <input type="text" name="merk" class="form-control" id="merk" autocomplete="off" value="<?= $barang["merk"] ?>">
                    </div>
                    <div class="mb-3">
                        <label for="stok" class="form-label">Stok</label>
                        <input type="number" name="stok" class="form-control" id="stok" autocomplete="off" value="<?= $barang["stok"] ?>">
                    </div>
                    <div class="mb-3">
                        <label for="harga-beli" class="form-label">Harga Beli</label>
                        <input type="number" name="harga-beli" class="form-control" id="harga-beli" autocomplete="off" value="<?= $barang["harga_beli"] ?>">
                    </div>
                    <div class=" mb-3">
                        <label for="harga-jual" class="form-label">Harga Jual</label>
                        <input type="number" name="harga-jual" class="form-control" id="harga-jual" autocomplete="off" value="<?= $barang["harga_jual"] ?>">
                    </div>
                    <div class=" mb-3">
                        <label for="satuan" class="form-label">Satuan</label>
                        <input type="text" name="satuan" class="form-control" id="satuan" autocomplete="off" value="<?= $barang["satuan"] ?>">
                    </div>
                    <button type="submit" name="update-item" class="btn btn-success">Update Barang</button>
                    <a href="index.php" class="btn btn-primary">Kembali</a>
                </form>
            </div>
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