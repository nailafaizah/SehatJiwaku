<?php
$servername = "localhost";
$database = "sehatjiwaku";
$username = "root";
$password = "";

// untuk tulisan bercetak tebal silakan sesuaikan dengan detail database Anda
// membuat koneksi
$conn = mysqli_connect($servername, $username, $password, $database);
// mengecek koneksi
if ($conn) {
	$user = $_POST['user'];
	$pass = $_POST['pass'];
	$q = "SELECT * from user where username like '$user' AND password like '$pass'";
	$result = mysqli_query($conn, $q);
	if(mysqli_num_rows($result) > 0) {

		echo "Login berhasil";
	}
	else{
		echo "Login Failed"
	}
}
mysqli_close($conn);
?>