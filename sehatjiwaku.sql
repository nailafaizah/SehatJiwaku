-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Okt 2021 pada 13.30
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
  `nama_gejala` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `gejala`
--

INSERT INTO `gejala` (`id_gejala`, `nama_gejala`) VALUES
(101, 'Sulit tidur'),
(102, 'Sering merasa khawatir'),
(103, 'Sering merasa takut'),
(104, 'Merasa sulit konsentrasi'),
(105, 'Merasa bingung dengan tempat, waktu atau orang'),
(106, 'Merasa lebih nyaman ketika sendirian'),
(107, 'Mendengar suara yang mengajak bercakap-cakap'),
(108, 'Mendengar suara orang yang sudah meninggal'),
(109, 'Mendengar suara yang mengancam'),
(110, 'Mendengar suara yang menyuruh melakukan sesuatu'),
(111, 'Mendengar suara langkah kaki'),
(112, 'Berbicara dengan suara yang didengar'),
(113, 'Merasa takut pada suara yang didengar'),
(114, 'Melihat orang yang sudah meninggal'),
(115, 'Melihat bayangan'),
(116, 'Melihat sinar/ cahaya yang sangat terang'),
(117, 'Melihat makhluk tertentu'),
(118, 'Merasa takut dengan objek yang dilihat'),
(119, 'Mencium bau yang menyenangkan'),
(120, 'Mencium bau tak sedap'),
(121, 'Mencium bau seperti bau mayat, darah, bayi, bau masakan, bau parfum yang menyengat'),
(122, 'Mencium bau bahan kimia'),
(123, 'Mencium bau benda terbakar'),
(124, 'Mengecap rasa yang aneh'),
(125, 'Mengecap rasa logam saat makan atau minum'),
(126, 'Merasakan seperti sedang makan sesuatu'),
(127, 'Merasakan rasa pahit, asam atau asin di lidah'),
(128, 'Sering meludah atau muntah'),
(129, 'Merasakan serangga merayap di tubuh'),
(130, 'Merasakan seseorang meraba/ menyentuh tubuh'),
(131, 'Merasakan sesuatu merangkak di bawah kulit'),
(132, 'Merasakan tersetrum pada bagian tubuh'),
(133, 'Merasakan ada api yang sedang membakar tubuh'),
(134, 'Merasakan organ dalam tubuh yang bergerak gerak'),
(135, 'Merasakan sensasi tidak nyaman di kulit');

-- --------------------------------------------------------

--
-- Struktur dari tabel `gejala_penyakit`
--

CREATE TABLE `gejala_penyakit` (
  `id_gejala` int(11) DEFAULT NULL,
  `id_penyakit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `gejala_penyakit`
--

INSERT INTO `gejala_penyakit` (`id_gejala`, `id_penyakit`) VALUES
(101, 201),
(101, 202),
(101, 203),
(101, 204),
(101, 205),
(102, 201),
(102, 202),
(102, 203),
(102, 204),
(102, 205),
(103, 201),
(103, 202),
(103, 203),
(103, 204),
(103, 205),
(104, 201),
(104, 202),
(104, 203),
(104, 204),
(104, 205),
(105, 201),
(105, 202),
(106, 201),
(106, 202),
(107, 201),
(108, 201),
(109, 201),
(110, 201),
(111, 201),
(112, 201),
(113, 201),
(114, 202),
(115, 202),
(116, 202),
(117, 202),
(118, 202),
(119, 203),
(120, 203),
(121, 203),
(122, 203),
(123, 203),
(124, 204),
(125, 204),
(126, 204),
(127, 204),
(128, 204),
(129, 205),
(130, 205),
(131, 205),
(132, 205),
(133, 205),
(134, 205),
(135, 205);

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
  ADD PRIMARY KEY (`id_gejala`);

--
-- Indeks untuk tabel `gejala_penyakit`
--
ALTER TABLE `gejala_penyakit`
  ADD KEY `id_gejala` (`id_gejala`),
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
  MODIFY `id_gejala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=136;

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
-- Ketidakleluasaan untuk tabel `gejala_penyakit`
--
ALTER TABLE `gejala_penyakit`
  ADD CONSTRAINT `gejala_penyakit_ibfk_1` FOREIGN KEY (`id_gejala`) REFERENCES `gejala` (`id_gejala`),
  ADD CONSTRAINT `gejala_penyakit_ibfk_2` FOREIGN KEY (`id_penyakit`) REFERENCES `penyakit` (`id_penyakit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
