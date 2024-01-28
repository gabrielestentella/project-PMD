-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 28, 2024 at 05:42 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbTirocini`
--

-- --------------------------------------------------------

--
-- Table structure for table `Azienda`
--

CREATE TABLE `Azienda` (
  `nome` varchar(20) NOT NULL,
  `sede_legale` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Docente`
--

CREATE TABLE `Docente` (
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `matricola` varchar(10) NOT NULL,
  `ruolo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Studente`
--

CREATE TABLE `Studente` (
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `matricola` varchar(10) NOT NULL,
  `CFUacquisiti` int(4) NOT NULL,
  `corsoDiLaurea` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Utente`
--

CREATE TABLE `Utente` (
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `tipo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Utente`
--

INSERT INTO `Utente` (`email`, `password`, `tipo`) VALUES
('commissione@unimi.it', '$2a$16$Hj/uUkskdNUihU80tEFvauvHwdsIgEfL.Z0.vEgUCzH4kVieDPCTS', 'commissione'),
('docente@unimi.it', '$2a$16$Hj/uUkskdNUihU80tEFvauvHwdsIgEfL.Z0.vEgUCzH4kVieDPCTS', 'docente'),
('studente@unimi.it', '$2a$16$Hj/uUkskdNUihU80tEFvauvHwdsIgEfL.Z0.vEgUCzH4kVieDPCTS', 'studente');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Azienda`
--
ALTER TABLE `Azienda`
  ADD PRIMARY KEY (`nome`);

--
-- Indexes for table `Docente`
--
ALTER TABLE `Docente`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `Studente`
--
ALTER TABLE `Studente`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `Utente`
--
ALTER TABLE `Utente`
  ADD PRIMARY KEY (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
