-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mar 17 Décembre 2013 à 19:57
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `drycleaning`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `ACustomerID` int(11) NOT NULL,
  `AccountName` varchar(20) NOT NULL,
  `CurrentBalance` double NOT NULL,
  `Street` varchar(30) NOT NULL,
  `City` varchar(20) NOT NULL,
  `State` char(2) NOT NULL,
  `Zip` char(5) NOT NULL,
  PRIMARY KEY (`ACustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cloth`
--

CREATE TABLE IF NOT EXISTS `cloth` (
  `ItemName` varchar(15) NOT NULL,
  `ItemCount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `CustType` char(3) NOT NULL,
  `Phone` char(10) NOT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SSN` char(9) NOT NULL,
  `EFName` varchar(15) NOT NULL,
  `ELName` varchar(20) NOT NULL,
  `JobTitle` int(11) DEFAULT NULL,
  `Pin` varchar(10) NOT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Sex` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID`,`SSN`),
  UNIQUE KEY `Pin` (`Pin`),
  KEY `JobTitle` (`JobTitle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `employee`
--

INSERT INTO `employee` (`ID`, `SSN`, `EFName`, `ELName`, `JobTitle`, `Pin`, `Address`, `Phone`, `DOB`, `Sex`) VALUES
(1, 'SSN6', 'Ainam', 'Jean-Paul', 2, '4256', 'Babcock University', '07063904692', '2013-11-13', 'Male');

-- --------------------------------------------------------

--
-- Structure de la table `garment`
--

CREATE TABLE IF NOT EXISTS `garment` (
  `GarmentNo` int(11) NOT NULL AUTO_INCREMENT,
  `Price` double NOT NULL,
  `StockName` varchar(15) NOT NULL,
  `PriceBump` double NOT NULL,
  PRIMARY KEY (`GarmentNo`),
  UNIQUE KEY `StockName` (`StockName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `garment`
--

INSERT INTO `garment` (`GarmentNo`, `Price`, `StockName`, `PriceBump`) VALUES
(1, 1000, 'First Stock', 1200),
(2, 1000, 'Second Stock', 1200);

-- --------------------------------------------------------

--
-- Structure de la table `income`
--

CREATE TABLE IF NOT EXISTS `income` (
  `IncomeDate` date NOT NULL,
  `IncomeTotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `job`
--

CREATE TABLE IF NOT EXISTS `job` (
  `IdJob` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(30) NOT NULL,
  PRIMARY KEY (`IdJob`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `job`
--

INSERT INTO `job` (`IdJob`, `TITLE`) VALUES
(1, 'Counter Employee'),
(2, 'Another Job Title'),
(3, 'Job Title 2'),
(4, 'Job Title 3');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `USERNAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `PROFILE` varchar(30) NOT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`USERNAME`, `PASSWORD`, `PROFILE`) VALUES
('paul', 'paul', 'Manager');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`JobTitle`) REFERENCES `job` (`IdJob`) ON DELETE SET NULL ON UPDATE SET NULL;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
