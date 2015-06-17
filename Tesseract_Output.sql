-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 17, 2015 at 02:39 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Tesseract_Output`
--

-- --------------------------------------------------------

--
-- Table structure for table `output_text`
--

CREATE TABLE IF NOT EXISTS `output_text` (
  `project_id` int(11) NOT NULL,
  `file_location` text NOT NULL,
  `output_string` longtext NOT NULL,
  UNIQUE KEY `project_id` (`project_id`),
  UNIQUE KEY `project_id_2` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `output_text`
--

INSERT INTO `output_text` (`project_id`, `file_location`, `output_string`) VALUES
(1, 'eurotext.tif', 'The (quick) [brown] {fox} jumps!\nOver the $43,456.78 <lazy> #90 dog\n& duck/goose, as 12.5% of E-mail\nfrom aspammer@website.com is spam.\nDer ,,schnelle” braune Fuchs springt\niiber den faulen Hund. Le renard brun\narapide» saute par-dessus le chien\nparesseux. La volpe marrone rapida\nsalta sopra i] cane pigro. El zorro\nmarrén répido salta sobre el perro\nperezoso. A raposa marrom rzipida\nsalta sobre o e50 preguieoso.\n\n');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
