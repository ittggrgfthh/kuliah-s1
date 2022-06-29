<?php 
session_start();

if(!isset($_SESSION['id'])){
  header("location: login.php");
  exit();
}
?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- CSS only -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <title>Document</title>
  </head>
  <body>
    <header class="text-center">
      <h1>My Website</h1>
      <p>Ini adalah website biografi saya</p>
    </header>
    <ul class="nav justify-content-center gap-3">
      <li class="nav-item">
        <a class=" btn btn-primary" aria-current="page" href="index.php">Home</a>
      </li>
      <li class="nav-item">
        <a class=" btn btn-primary" href="item/index.php">Barang</a>
      </li>
      <li class="nav-item">
        <a class=" btn btn-primary" href="#">Help</a>
      </li>
    </ul>
    <div class="container my-4">
      <div class="row align-item-center">
        <div class="col-md-4 text-center">
          <img src="Images/farhan.png" alt="" class="img-thumbnail mt-4" style="max-width: 200px;" />
        </div>
        <div class="col-md-8 mt-3">
          <table class="table">
            <tbody>
              <tr>
                <th scope="row">NIM :</th>
                <td>A12.2020.06476</td>
              </tr>
              <tr>
                <th scope="row">Nama :</th>
                <td>Farhan Taqi Abdussalam</td>
              </tr>
              <tr>
                <th scope="row">Jenis Kelamin :</th>
                <td>Laki-laki</td>
              </tr>
              <tr>
                <th scope="row">TTL :</th>
                <td>Semarang, 14 April 2002</td>
              </tr>
              <tr>
                <th scope="row">Asal Sekolah :</th>
                <td>SMAN 9 Semarang</td>
              </tr>
              <tr>
                <th scope="row">Alamat :</th>
                <td>Jl. Puri Utama II D1/14 Padangsari</td>
              </tr>
              <tr>
                <th scope="row">Email :</th>
                <td>112202006476@mhs.dinus.ac.id</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div class="row justify-content-center ">
        <a href="logout.php" class="btn btn-primary col-2">Logout</a>
      </div>
    </div>
    <footer class="text-center bg-dark text-light">
      <p>ini adalah footer</p>
    </footer>
  </body>
</html>