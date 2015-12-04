-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 04, 2015 at 12:56 AM
-- Server version: 5.6.20-log
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `javawithajax`
--

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
`id` int(11) NOT NULL,
  `messagesend` varchar(100) COLLATE latin1_bin NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=9 ;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`id`, `messagesend`) VALUES
(1, 'Bonjour tout le monde !!'),
(2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed molestie justo vel ex consequat, vitae '),
(3, 'I love you Miranda!!'),
(4, 'Hello World !'),
(5, 'Bravo pour le site'),
(6, 'bienvenue'),
(7, 'Can anybody hep me'),
(8, 'Yes ? What do you need ?');

-- --------------------------------------------------------

--
-- Table structure for table `pays`
--

CREATE TABLE IF NOT EXISTS `pays` (
`id` int(11) NOT NULL,
  `nom` varchar(50) COLLATE latin1_bin NOT NULL,
  `ville` varchar(50) COLLATE latin1_bin NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=7 ;

--
-- Dumping data for table `pays`
--

INSERT INTO `pays` (`id`, `nom`, `ville`) VALUES
(1, 'canada', 'montreal'),
(2, 'usa', 'new-york'),
(3, 'uk', 'london'),
(4, 'canada', 'toronto'),
(5, 'usa', 'california'),
(6, 'canada', 'quebec');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
`id` int(11) NOT NULL,
  `nom` varchar(100) COLLATE latin1_bin NOT NULL,
  `prenom` varchar(100) COLLATE latin1_bin NOT NULL,
  `etat` varchar(20) COLLATE latin1_bin NOT NULL DEFAULT 'absent'
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_bin AUTO_INCREMENT=7 ;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `etat`) VALUES
(1, 'suon', 'samnang', 'active'),
(2, 'kerr', 'miranda', 'active'),
(3, 'swanepoel', 'candice', 'active'),
(4, 'keegan', 'michelle', 'absent'),
(5, 'johansson', 'scarlett', 'absent'),
(6, 'lawrence', 'jennifer', 'absent');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `message`
--
ALTER TABLE `message`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pays`
--
ALTER TABLE `pays`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `pays`
--
ALTER TABLE `pays`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
