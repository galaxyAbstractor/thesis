-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Värd: localhost
-- Skapad: 19 apr 2014 kl 19:32
-- Serverversion: 5.6.12-log
-- PHP-version: 5.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databas: `testdb`
--
CREATE DATABASE IF NOT EXISTS `testdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `testdb`;

-- --------------------------------------------------------

--
-- Tabellstruktur `airports`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `ontime`
--

CREATE TABLE IF NOT EXISTS `ontime` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Year` int(11) DEFAULT NULL,
  `Month` int(11) DEFAULT NULL,
  `DayofMonth` int(11) DEFAULT NULL,
  `DayOfWeek` int(11) DEFAULT NULL,
  `DepTime` int(11) DEFAULT NULL,
  `CRSDepTime` int(11) DEFAULT NULL,
  `ArrTime` int(11) DEFAULT NULL,
  `CRSArrTime` int(11) DEFAULT NULL,
  `UniqueCarrier` varchar(5) DEFAULT NULL,
  `FlightNum` int(11) DEFAULT NULL,
  `TailNum` varchar(8) DEFAULT NULL,
  `ActualElapsedTime` int(11) DEFAULT NULL,
  `CRSElapsedTime` int(11) DEFAULT NULL,
  `AirTime` int(11) DEFAULT NULL,
  `ArrDelay` int(11) DEFAULT NULL,
  `DepDelay` int(11) DEFAULT NULL,
  `Origin` varchar(32) DEFAULT NULL,
  `Dest` varchar(32) DEFAULT NULL,
  `Distance` int(11) DEFAULT NULL,
  `TaxiIn` int(11) DEFAULT NULL,
  `TaxiOut` int(11) DEFAULT NULL,
  `Cancelled` int(11) DEFAULT NULL,
  `CancellationCode` varchar(1) DEFAULT NULL,
  `Diverted` varchar(1) DEFAULT NULL,
  `CarrierDelay` int(11) DEFAULT NULL,
  `WeatherDelay` int(11) DEFAULT NULL,
  `NASDelay` int(11) DEFAULT NULL,
  `SecurityDelay` int(11) DEFAULT NULL,
  `LateAircraftDelay` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

--
-- Restriktioner för dumpade tabeller
--

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;