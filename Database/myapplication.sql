-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 22, 2018 at 09:33 AM
-- Server version: 10.1.24-MariaDB
-- PHP Version: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myapplication`
--

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobilenumber` varchar(12) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contactperson` varchar(100) NOT NULL,
  `contactpersonnumber` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `firstname`, `lastname`, `birthday`, `email`, `mobilenumber`, `address`, `contactperson`, `contactpersonnumber`) VALUES
(1, 'Larae', 'Stoner', '1997-10-22', 'laraestoner@gmail.com', '09888888888', 'Quezon City, Philippines', 'Laura Stoner', '09777777777'),
(2, 'Clementina', 'Maus', '1977-07-17', 'clementinamaus@gmail.com', '09654442233', 'Makati City, Philippines', 'Cristina Maus', '09882226665'),
(3, 'Arlette', 'Mccall', '1985-02-14', 'arlettemccall@gmail.com', '09227771166', 'Pasay City, Philippines', 'Ana Mccall', '09886766221'),
(4, 'Maurice', 'Carothers', '1995-12-21', 'mauricecarothers@gmail.com', '09775553322', 'Makati City, Philippines', 'Mauro Carothers', '09112227711'),
(5, 'Lizzette', 'Vaugh', '1996-11-03', 'lizzettevaugh@gmail.com', '09663335511', 'Cabanatuan, Nueva Ecija', 'Liza Vaugh', '09665552244');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
