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

CREATE TABLE IF NOT EXISTS `airports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iata` varchar(10) NOT NULL,
  `airport` varchar(64) NOT NULL,
  `city` varchar(64) NOT NULL,
  `state` varchar(20) NOT NULL,
  `country` varchar(42) NOT NULL,
  `lat` double NOT NULL,
  `longitude` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

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
  `Origin` int(11) DEFAULT NULL,
  `Dest` int(11) DEFAULT NULL,
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
  PRIMARY KEY (`Id`),
  KEY `Origin` (`Origin`),
  KEY `Dest` (`Dest`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `ontime`
--
ALTER TABLE `ontime`
  ADD CONSTRAINT `ontime_ibfk_2` FOREIGN KEY (`Dest`) REFERENCES `airports` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ontime_ibfk_1` FOREIGN KEY (`Origin`) REFERENCES `airports` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;