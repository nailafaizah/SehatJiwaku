-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Jul 2021 pada 15.39
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sehatjiwaku`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dokter`
--

CREATE TABLE `dokter` (
  `id_dokter` int(11) NOT NULL,
  `nama_dokter` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `dokter`
--

INSERT INTO `dokter` (`id_dokter`, `nama_dokter`) VALUES
(301, 'dr. Afinia Permanasari, Sp.KJ'),
(302, 'dr. Balgis Basalamah, Sp.KJ'),
(303, 'dr. Kennisa Tripatria, Sp.KJ');

-- --------------------------------------------------------

--
-- Struktur dari tabel `gejala`
--

CREATE TABLE `gejala` (
  `id_gejala` int(11) NOT NULL,
  `nama_gejala` varchar(100) NOT NULL,
  `id_penyakit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `gejala`
--

INSERT INTO `gejala` (`id_gejala`, `nama_gejala`, `id_penyakit`) VALUES
(1, 'Merasa mendengar suara/ bunyi', 201),
(2, 'Merasa mendengar sesuatu yang menyuruh melakukan sesuatu yang berbahaya', 201),
(3, 'Merasa mendengar suara yang mengajak bercakap cakap', 201),
(4, 'Merasa mendengar suara orang yang sudah meninggal', 201),
(5, 'Merasa mendengar suara yang mengancam diri penderita atau orang lain', 201),
(6, 'Mengarahkan telinga ke sumber suara', 201),
(7, 'Menutup telinga mulut komat kamit', 201),
(8, 'Merasa melihat orang yang sudah meninggal', 202),
(9, 'Merasa melihat makhluk tertentu', 202),
(10, 'Merasa melihat bayangan', 202),
(11, 'Merasa melihat sesuatu yang menakutkan', 202),
(12, 'Merasa melihat cahaya yang sangat terang', 202),
(13, 'Tatapan mata pada tempat tertentu', 202),
(14, 'Menunjuk ke arah tertentu', 202),
(15, 'Ketakutan pada obyek yang dilihat', 202),
(16, 'Merasa mencium sesuatu seperti bau mayat, darah, bayi, bau masakan dan bau parfum yang menyengat', 203),
(17, 'Sering mengatakan mencium bau sesuatu', 203),
(18, 'Ekspresi wajah seperti sedang mencium', 203),
(19, 'Adanya gerakan seperti cuping hidung', 203),
(20, 'Mengarakan hidung ke tempat tertentu', 203),
(21, 'Merasakan seperti sedang makan sesuatu', 204),
(22, 'Merasakan ada yang dikunyah di mulut penderita', 204),
(23, 'Seperti mengecap sesuatu', 204),
(24, 'Mulut penderita seperti mengunyah', 204),
(25, 'Sering meludah atau muntah', 204),
(26, 'Merasakan seperti ada sesuatu di tubuhnya', 205),
(27, 'Merasakan ada sesuatu di bawah kulit', 205),
(28, 'Merasa sangat panas atau dingin', 205),
(29, 'Merasakan seperti tersengat aliran listrik', 205),
(30, 'Mengusap dan menggaruk kulit', 205),
(31, 'Meraba permukaan kulit', 205),
(32, 'Menggerak gerakan badan', 205),
(33, 'Terus memegangi area tertentu', 205);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penyakit`
--

CREATE TABLE `penyakit` (
  `id_penyakit` int(11) NOT NULL,
  `nama_penyakit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penyakit`
--

INSERT INTO `penyakit` (`id_penyakit`, `nama_penyakit`) VALUES
(201, 'Halusinasi Pendengaran'),
(202, 'Halusinasi Penglihatan'),
(203, 'Halusinasi Penciuman'),
(204, 'Halusinasi Pengecapan'),
(205, 'Halusinasi Perabaan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(10) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `level` enum('admin','user') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `nama`, `username`, `password`, `level`) VALUES
(101, 'admin', 'admin', 'admin', 'admin'),
(102, 'user', 'user', 'user', 'user');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`id_dokter`);

--
-- Indeks untuk tabel `gejala`
--
ALTER TABLE `gejala`
  ADD PRIMARY KEY (`id_gejala`),
  ADD KEY `id_penyakit` (`id_penyakit`);

--
-- Indeks untuk tabel `penyakit`
--
ALTER TABLE `penyakit`
  ADD PRIMARY KEY (`id_penyakit`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `gejala`
--
ALTER TABLE `gejala`
  MODIFY `id_gejala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT untuk tabel `penyakit`
--
ALTER TABLE `penyakit`
  MODIFY `id_penyakit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=206;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `gejala`
--
ALTER TABLE `gejala`
  ADD CONSTRAINT `gejala_ibfk_1` FOREIGN KEY (`id_penyakit`) REFERENCES `penyakit` (`id_penyakit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
