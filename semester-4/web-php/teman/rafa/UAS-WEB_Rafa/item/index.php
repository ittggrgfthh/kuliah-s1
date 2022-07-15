<?php
require dirname(__DIR__) . "/util/connection.php";
require dirname(__DIR__) . "/util/function.php";

$barang = query("SELECT * FROM barang");
$alert = false;
$message = "";

if (isset($_GET["delete"])) {
    $alert = true;
    $alertType = $_GET["delete"] == "true" ? "alert-success" : "alert-danger";
    $idBarang = $_GET["id-barang"];
    $message = $_GET["delete"] == "true" ? "Kode barang $idBarang berhasil dihapus!" : "Kode barang $idBarang gagal dihapus!";
};

if (isset($_GET["update"])) {
    // var_dump($_GET);
    // die();
    $alert = true;
    $alertType = $_GET["update"] == "true" ? "alert-success" : "alert-danger";
    $idBarang = $_GET["id-barang"];
    $message = $_GET["update"] == "true" ? "Kode barang $idBarang berhasil diupdate!" : "Kode barang $idBarang gagal diupdate!";
};

if (isset($_GET["detail"])) {
    // var_dump($_GET);
    // die();
    $alert = true;
    $alertType = $_GET["update"] == "true" ? "alert-success" : "alert-danger";
    $idBarang = $_GET["id-barang"];
    $message = $_GET["update"] == "true" ? "Kode barang $idBarang berhasil diupdate!" : "Kode barang $idBarang gagal diupdate!";
};

if (isset($_GET["restok"])) {
    $alert = true;
    $alertType = $_GET["restok"] == "true" ? "alert-success" : "alert-danger";
    $idBarang = $_GET["id-barang"];
    $message = $_GET["restok"] == "true" ? "Kode barang $idBarang stok berhasil diupdate!" : "Kode barang $idBarang stok gagal diupdate!";
};

if (isset($_POST["search"])) {
    $barang = search($_POST["keyword"]);
}

if (isset($_GET["orderby"])) {
    if ($_GET["orderby"] == "stok-kurang") {
        $barang = sortir();
    } else {
        $barang = search("");
    }
}

// insert data
$idBarang = "";
$kategori = "Kategori";
$namaBarang = "";
$merk = "";
$stok = "";
$hargaBeli = "";
$hargaJual = "";
$satuan = "Satuan";

if (isset($_POST["add-item"])) {
    // var_dump($_POST);
    // die();
    $modal = true;
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
    if (insert($request) > 0) {
        $alertType = "alert-success";
        $idBarang = $_POST["id-barang"];
        $message = "Kode barang $idBarang berhasil ditambahkan!";
    } else {
        $idBarang = $_POST["id-barang"];
        $kategori = $_POST["kategori"];
        $namaBarang = $_POST["nama-barang"];
        $merk = $_POST["merk"];
        $stok = $_POST["stok"];
        $hargaBeli = $_POST["harga-beli"];
        $hargaJual = $_POST["harga-jual"];
        $satuan = $_POST["satuan"];
        $message = "Gagal menambahkan!";
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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />
    <title>Daftar Barang</title>
</head>

<body>
    <div class="container-fluid">
        <div class="my-4">
            <h1>Daftar Barang</h1>
            <?php if ($alert) { ?>
                <div class="alert <?= $alertType ?> alert-dismissible fade show" role="alert">
                    <?= $message ?>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            <?php } ?>
        </div>
        <div class="mb-4 container-fluid">
            <div class="row gap-2 justify-content-end">
                <a type="button" class="btn btn-success col-2" href="index.php">
                    <i class="fa-solid fa-rotate"></i>
                    <span>Refresh Data</span>
                </a>
                <a type="button" class="btn btn-warning col-2" href="index.php?orderby=stok-kurang">Sortir Stok Kurang</a>
                <button type="button" class="btn btn-primary col-2" data-bs-toggle="modal" data-bs-target="#add-item">
                    Tambah Data
                </button>
            </div>
        </div>

        <!-- Modal Start -->

        <!-- Modal -->
        <div class="modal fade" id="add-item" tabindex="-1" aria-labelledby="add-item-label" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="add-item-label">Tambah Barang</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="" method="POST" enctype="multipart/form-data" class="my-2">
                        <div class="modal-body">
                            <div>
                                <div class="mb-3 row gap-0">
                                    <div class="col-3">
                                        <label for="id-barang" class="form-label">ID Barang</label>
                                    </div>
                                    <div class="col-9">
                                        <input type="text" name="id-barang" class="form-control" id="id-barang" autocomplete="off" value="<?= $idBarang ?>" required>
                                    </div>
                                </div>
                                <div class="mb-3 row gap-0">
                                    <div class="col-3">
                                        <label for="kategori" class="form-label">Kategori</label>
                                    </div>
                                    <div class="col-9">
                                        <select name="kategori" id="kategori" class="form-select" aria-label="kategori">
                                            <option selected><?= $kategori ?></option>
                                            <option value="Gatged">Gatged</option>
                                            <option value="Mainan">Mainan</option>
                                            <option value="Mainan">Keramik</option>
                                            <option value="Mainan">Kuku Macan</option>
                                            <option value="Lainnya">Lainnya</option>
                                        </select>
                                        <!-- <input type="text" name="kategori" class="form-control" id="kategori" autocomplete="off" value="<?= $kategori ?>"> -->
                                    </div>
                                </div>
                                <div class=" mb-3 row gap-0">
                                    <div class="col-3">
                                        <label for="nama-barang" class="form-label">Nama Barang</label>
                                    </div>
                                    <div class="col-9">
                                        <input type="text" name="nama-barang" class="form-control" id="nama-barang" autocomplete="off" value="<?= $namaBarang ?>" required>
                                    </div>
                                </div>
                                <div class=" mb-3 row gap-0">
                                    <div class="col-3">
                                        <label for="merk" class="form-label">Merk</label>
                                    </div>
                                    <div class="col-9">
                                        <input type="text" name="merk" class="form-control" id="merk" autocomplete="off" value="<?= $merk ?>">
                                    </div>
                                </div>
                                <div class=" mb-3 row gap-0">
                                    <div class="col-3">
                                        <label for="stok" class="form-label">Stok</label>
                                    </div>
                                    <div class="col-9">
                                        <input type="number" name="stok" class="form-control" id="stok" autocomplete="off" value="<?= $stok ?>">
                                    </div>
                                </div>
                                <div class=" mb-3 row gap-0">
                                    <div class="col-3">
                                        <label for="harga-beli" class="form-label">Harga Beli</label>
                                    </div>
                                    <div class="col-9">
                                        <input type="number" name="harga-beli" class="form-control" id="harga-beli" autocomplete="off" value="<?= $hargaBeli ?>">
                                    </div>
                                </div>
                                <div class=" mb-3 row gap-0">
                                    <div class="col-3">
                                        <label for="harga-jual" class="form-label">Harga Jual</label>
                                    </div>
                                    <div class="col-9">
                                        <input type="number" name="harga-jual" class="form-control" id="harga-jual" autocomplete="off" value="<?= $hargaJual ?>">
                                    </div>
                                </div>
                                <div class=" mb-3 row gap-0">
                                    <div class="col-3">
                                        <label for="satuan" class="form-label">Satuan</label>
                                    </div>
                                    <div class="col-9">
                                        <select name="satuan" id="satuan" class="form-select" aria-label="satuan">
                                            <option selected><?= $satuan ?></option>
                                            <option value="PCS">PCS</option>
                                            <option value="UNIT">UNIT</option>
                                            <option value="PACK">PACK</option>
                                        </select>
                                        <!-- <input type="text" name="satuan" class="form-control" id="satuan" autocomplete="off" value="<?= $satuan ?>"> -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class=" modal-footer">
                            <button type="submit" name="add-item" class="btn btn-success">Insert Data</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Modal End -->

        <!-- Search Start -->
        <div class="my-4 container-fluid">
            <form class="d-flex" role="search" method="post">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" autocomplete="off" name="keyword">
                <button class="btn btn-outline-success" type="submit" name="search">Search</button>
            </form>
        </div>
        <!-- Search End -->

        <!-- Tabel Start -->
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead class="table-dark text-center">
                    <tr>
                        <th>No</th>
                        <th>ID Barang</th>
                        <th>Kategori</th>
                        <th>Nama Barang</th>
                        <th>Merk</th>
                        <th>Stok</th>
                        <th>Harga Beli</th>
                        <th>Harga Jual</th>
                        <th>Satuan</th>
                        <th>Aksi</th>
                    </tr>
                </thead>
                <tbody>
                    <?php $i = 1; ?>
                    <?php foreach ($barang as $row) : ?>
                        <tr>
                            <td class="text-center"><?= $i ?></td>
                            <td><?= $row["id_barang"]; ?></td>
                            <td><?= $row["kategori"]; ?></td>
                            <td><?= $row["nama_barang"]; ?></td>
                            <td><?= $row["merk"]; ?></td>
                            <td>
                                <?php
                                if ($row["stok"] <= 0) {
                                    echo '<button type="button" class="btn btn-danger" href="#" disabled>Habis</button>';
                                } else {
                                    echo $row["stok"];
                                };
                                ?>
                            </td>
                            <td><?= $row["harga_beli"]; ?></td>
                            <td><?= $row["harga_jual"]; ?></td>
                            <td><?= $row["satuan"]; ?></td>
                            <td>
                                <?php if ($row["stok"] <= 0) { ?>
                                    <div class="row g-1">
                                        <div class="col-auto">
                                            <form method="POST" action="restok.php" class="row g-1">
                                                <div class="col-auto">
                                                    <input hidden type="text" name="id-barang" class="form-control" id="id-barang" placeholder="id" value="<?= $row["id_barang"] ?>">
                                                    <input type="number" name="stok" class="form-control" id="stok" placeholder="stok">
                                                </div>
                                                <div class="col-auto">
                                                    <button type="submit" name="restok" class="btn btn-success">Restok</button>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="col-auto">
                                            <a type="button" class="btn btn-danger" href="delete.php?id-barang=<?= $row["id_barang"]; ?>" onclick="return confirm('Apakah anda yakin?')">Hapus</a>
                                        </div>
                                    </div>
                                <?php } else { ?>

                                    <a type="button" class="btn btn-primary" href="detail.php?id-barang=<?= $row["id_barang"]; ?>">Detail</a>
                                    <a type="button" class="btn btn-warning" href="update.php?id-barang=<?= $row["id_barang"]; ?>">Update</a>
                                    <a type="button" class="btn btn-danger" href="delete.php?id-barang=<?= $row["id_barang"]; ?>" onclick="return confirm('Apakah anda yakin?')">Hapus</a>

                                <?php }; ?>

                            </td>
                        </tr>
                        <?php $i++; ?>
                    <?php endforeach; ?>
                </tbody>
            </table>
        </div>
        <!-- Table End -->
    </div>

    <script>
        let alert = document.querySelector(".alert");
        window.setTimeout(function() {
            alert.classList.remove("show");
        }, 5000);
        window.setTimeout(function() {
            alert.remove();
        }, 5300);
    </script>

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