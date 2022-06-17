<?php 

const HOST = "localhost";
const USERNAME = "root";
const PASSWORD = "";
const DATABASE = "kuliah_web";

$conn = mysqli_connect(HOST, USERNAME, PASSWORD, DATABASE);

if(!$conn){
    echo "Connection Failed!";
}
