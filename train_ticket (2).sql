-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 12, 2022 at 06:53 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `train_ticket`
--

-- --------------------------------------------------------

--
-- Table structure for table `account_section`
--

CREATE TABLE `account_section` (
  `Name` varchar(20) NOT NULL,
  `Address` varchar(20) NOT NULL,
  `Nid` varchar(12) NOT NULL,
  `Birthdate` varchar(20) NOT NULL,
  `Phone` varchar(11) NOT NULL,
  `Password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account_section`
--

INSERT INTO `account_section` (`Name`, `Address`, `Nid`, `Birthdate`, `Phone`, `Password`) VALUES
('abcd', 'abbb', '123456', '7/1/2004', '01478522012', '12345'),
('Swapnil Das', 'Dhaka, Shawrapara', '100100100', '7/4/2022', '0172345678', '12345'),
('Saikat', 'Madhabpur', '19203103085', '7/14/1994', '01753154061', '123456'),
('mou', 'Sylhet', '2002', '11/28/2002', '01818068822', '1234'),
('ajoy', 'hfhgf', '12345', '8/17/2006', '1234555', '123'),
('shanto', 'dhaka', '12345678', '7/15/2022', '12356', '321'),
('Sarkit', 'dhaka', '1999', '7/13/2022', '4562', '123'),
('Sarkit', 'dfdsffd', '1234', '7/14/2022', '46412', '123'),
('fsdfsf', 'fgsdggdgs', '45456456', '7/26/2022', '53456456456', 'fgststret'),
('fdsfs', 'fgdsgsdg', '5464564645', '7/19/2022', '54564564', 'gfdsgsdg'),
('saikat', 'dsffs', '564564', '7/19/2022', '56456456', 'sfasfds'),
('saikat', 'dshffhes', '123456', '7/20/2022', '6286', '1234'),
('puja', 'dfdsfsdf', '123456', '10/15/2010', '8575475', '321'),
('Saikat', 'Madhabpur', '12345', '7/20/2022', '8940', '321'),
('fdgdfgdfg', 'dfggdfgdg', '2000', '7/19/2022', 'dddf', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `ID` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`ID`, `PASSWORD`) VALUES
('admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `admin_booking`
--

CREATE TABLE `admin_booking` (
  `Id` varchar(20) NOT NULL,
  `sit` varchar(20) NOT NULL,
  `coach` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_booking`
--

INSERT INTO `admin_booking` (`Id`, `sit`, `coach`, `date`) VALUES
('1', '', '', '8/12/2022'),
('2', '', '', '8/13/2022'),
('3', '', '', '8/14/2022'),
('4', '', '', '8/15/2022'),
('5', '', '', '8/16/2022'),
('7', 'B3', 'B', '8/12/2022'),
('8', 'B4', 'B', '8/12/2022'),
('9', 'A2', 'B', '8/12/2022'),
('10', 'A3', 'B', '8/12/2022');

-- --------------------------------------------------------

--
-- Table structure for table `bookingticket`
--

CREATE TABLE `bookingticket` (
  `Id` varchar(20) NOT NULL,
  `profilename` varchar(30) NOT NULL,
  `trainname` varchar(30) NOT NULL,
  `cabin` varchar(20) NOT NULL,
  `sit` varchar(20) NOT NULL,
  `date` varchar(30) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `price` varchar(20) NOT NULL,
  `transaction` varchar(20) NOT NULL,
  `from_d` varchar(20) NOT NULL,
  `to_a` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

CREATE TABLE `place` (
  `Destination` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `place`
--

INSERT INTO `place` (`Destination`) VALUES
('Airport Dhaka'),
('Akhawra'),
('Amirganj'),
('Ashuganj'),
('Azampur'),
('Banani'),
('Bhairab Bazar'),
('Bhanugach'),
('Bhatiari'),
('Brahmanbaria'),
('Chittagong'),
('Cinki Astana'),
('Comilla'),
('Dhaka'),
('Dhaka Cantonment'),
('Feni'),
('Foujdarhat Junction'),
('Gaforgaon'),
('Gongasagor'),
('Gunabot'),
('Hasanpur'),
('Kasava'),
('Kulaura'),
('Laksam'),
('Maizgaon'),
('Mondhobagh'),
('Mymensingh'),
('Nangolcoart'),
('Narsingdi'),
('Nayapara'),
('Shaistagonj'),
('Shoshidhol'),
('Srimangal'),
('Sylhet'),
('Tejgaon'),
('Tongi');

-- --------------------------------------------------------

--
-- Table structure for table `ticketnumber`
--

CREATE TABLE `ticketnumber` (
  `coach` varchar(10) NOT NULL,
  `sti` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ticketnumber`
--

INSERT INTO `ticketnumber` (`coach`, `sti`) VALUES
('A', 'A1'),
('A', 'A2'),
('A', 'A3'),
('A', 'A4'),
('A', 'B1'),
('A', 'B2'),
('A', 'B3'),
('A', 'B4'),
('A', 'C1'),
('A', 'C2'),
('A', 'C3'),
('A', 'C4'),
('A', 'D1'),
('A', 'D2'),
('A', 'D3'),
('A', 'D4'),
('A', 'E1'),
('A', 'E2'),
('A', 'E3'),
('A', 'E4'),
('A', 'F1'),
('A', 'F2'),
('A', 'F3'),
('A', 'F4'),
('A', 'G1'),
('A', 'G2'),
('A', 'G3'),
('A', 'G4'),
('A', 'H1'),
('A', 'H2'),
('A', 'H3'),
('A', 'H4'),
('A', 'I1'),
('A', 'I2'),
('A', 'I3'),
('A', 'I4'),
('A', 'J1'),
('A', 'J2'),
('A', 'J3'),
('A', 'J4'),
('B', 'A1'),
('B', 'A2'),
('B', 'A3'),
('B', 'A4'),
('B', 'B1'),
('B', 'B2'),
('B', 'B3'),
('B', 'B4'),
('B', 'C1'),
('B', 'C2'),
('B', 'C3'),
('B', 'C4'),
('B', 'D1'),
('B', 'D2'),
('B', 'D3'),
('B', 'D4'),
('B', 'E1'),
('B', 'E2'),
('B', 'E3'),
('B', 'E4'),
('B', 'F1'),
('B', 'F2'),
('B', 'F3'),
('B', 'F4'),
('B', 'G1'),
('B', 'G2'),
('B', 'G3'),
('B', 'G4'),
('B', 'H1'),
('B', 'H2'),
('B', 'H3'),
('B', 'H4'),
('B', 'I1'),
('B', 'I2'),
('B', 'I3'),
('B', 'I4'),
('B', 'J1'),
('B', 'J2'),
('B', 'J3'),
('B', 'J4'),
('C', 'A1'),
('C', 'A2'),
('C', 'A3'),
('C', 'A4'),
('C', 'B1'),
('C', 'B2'),
('C', 'B3'),
('C', 'B4'),
('C', 'C1'),
('C', 'C2'),
('C', 'C3'),
('C', 'C4'),
('C', 'D1'),
('C', 'D2'),
('C', 'D3'),
('C', 'D4'),
('C', 'E1'),
('C', 'E2'),
('C', 'E3'),
('C', 'E4'),
('C', 'F1'),
('C', 'F2'),
('C', 'F3'),
('C', 'F4'),
('C', 'G1'),
('C', 'G2'),
('C', 'G3'),
('C', 'G4'),
('C', 'H1'),
('C', 'H2'),
('C', 'H3'),
('C', 'H4'),
('C', 'I1'),
('C', 'I2'),
('C', 'I3'),
('C', 'I4'),
('C', 'J1'),
('C', 'J2'),
('C', 'J3'),
('C', 'J4'),
('D', 'A1'),
('D', 'A2'),
('D', 'A3'),
('D', 'A4'),
('D', 'B1'),
('D', 'B2'),
('D', 'B3'),
('D', 'B4'),
('D', 'C1'),
('D', 'C2'),
('D', 'C3'),
('D', 'C4'),
('D', 'D1'),
('D', 'D2'),
('D', 'D3'),
('D', 'D4'),
('D', 'E1'),
('D', 'E2'),
('D', 'E3'),
('D', 'E4'),
('D', 'F1'),
('D', 'F2'),
('D', 'F3'),
('D', 'F4'),
('D', 'G1'),
('D', 'G2'),
('D', 'G3'),
('D', 'G4'),
('D', 'H1'),
('D', 'H2'),
('D', 'H3'),
('D', 'H4'),
('D', 'I1'),
('D', 'I2'),
('D', 'I3'),
('D', 'I4'),
('D', 'J1'),
('D', 'J2'),
('D', 'J3'),
('D', 'J4'),
('E', 'A1'),
('E', 'A2'),
('E', 'A3'),
('E', 'A4'),
('E', 'B1'),
('E', 'B2'),
('E', 'B3'),
('E', 'B4'),
('E', 'C1'),
('E', 'C2'),
('E', 'C3'),
('E', 'C4'),
('E', 'D1'),
('E', 'D2'),
('E', 'D3'),
('E', 'D4'),
('E', 'E1'),
('E', 'E2'),
('E', 'E3'),
('E', 'E4'),
('E', 'F1'),
('E', 'F2'),
('E', 'F3'),
('E', 'F4'),
('E', 'G1'),
('E', 'G2'),
('E', 'G3'),
('E', 'G4'),
('E', 'H1'),
('E', 'H2'),
('E', 'H3'),
('E', 'H4'),
('E', 'I1'),
('E', 'I2'),
('E', 'I3'),
('E', 'I4'),
('E', 'J1'),
('E', 'J2'),
('E', 'J3'),
('E', 'J4');

-- --------------------------------------------------------

--
-- Table structure for table `train`
--

CREATE TABLE `train` (
  `trainname` varchar(20) NOT NULL,
  `derived` varchar(30) NOT NULL,
  `arrived` varchar(30) NOT NULL,
  `from_time` varchar(20) NOT NULL,
  `to_time` varchar(20) NOT NULL,
  `price` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `train`
--

INSERT INTO `train` (`trainname`, `derived`, `arrived`, `from_time`, `to_time`, `price`) VALUES
('Sonar Bangla', 'Dhaka', 'Tejgaon', '7:00am', '7:12am', '20'),
('Sonar Bangla', 'Dhaka', 'Banani', '7:00am', '7:25am', '30'),
('Sonar Bangla', 'Dhaka', 'Dhaka Cantonment', '7:00am', '7:38am', '40'),
('Sonar Bangla', 'Dhaka', 'Airport Dhaka', '7:00am', '7:50am', '50'),
('Sonar Bangla', 'Dhaka', 'Tongi', '7:00am', '8:00am', '60'),
('Sonar Bangla', 'Dhaka', 'Narsingdi', '7:00am', '8:15am', '80'),
('Sonar Bangla', 'Dhaka', 'Amirganj', '7:00am', '8:20am', '90'),
('Sonar Bangla', 'Dhaka', 'Bhairab Bazar', '7:00am', '8:25am', '100'),
('Sonar Bangla', 'Dhaka', 'Ashuganj', '7:00am', '8:35am', '110'),
('Sonar Bangla', 'Dhaka', 'Brahmanbaria', '7:00am', '8:45am', '130'),
('Sonar Bangla', 'Dhaka', 'Akhawra', '7:00am', '9:00am', '150'),
('Sonar Bangla', 'Dhaka', 'Gongasagor', '7:00am', '9:20am', '165'),
('Sonar Bangla', 'Dhaka', 'Kasava', '7:00am', '9:35am', '190'),
('Sonar Bangla', 'Dhaka', 'Mondhobagh', '7:00am', '9:50am', '200'),
('Sonar Bangla', 'Dhaka', 'Shoshidhol', '7:00am', '10:00am', '220'),
('Sonar Bangla', 'Dhaka', 'Comilla', '7:00am', '10:15am', '240'),
('Sonar Bangla', 'Dhaka', 'Laksam', '7:00am', '10:30am', '260'),
('Sonar Bangla', 'Dhaka', 'Nangolcoart', '7:00am', '10:50am', '280'),
('Sonar Bangla', 'Dhaka', 'Hasanpur', '7:00am', '11:10am', '290'),
('Sonar Bangla', 'Dhaka', 'Feni', '7:00am', '11:25am', '300'),
('Sonar Bangla', 'Dhaka', 'Cinki Astana', '7:00am', '11:40am', '310'),
('Sonar Bangla', 'Dhaka', 'Bhatiari', '7:00am', '11:50am', '320'),
('Sonar Bangla', 'Dhaka', 'Foujdarhat Junction', '7:00am', '12:00am', '340'),
('Sonar Bangla', 'Dhaka', 'Chittagong', '7:00am', '12:20pm', '350'),
('Sonar Bangla', 'Tejgaon', 'Banani', '7:12am', '7:25am', '20'),
('Sonar Bangla', 'Tejgaon', 'Dhaka Cantonment', '7:12am', '7:38am', '30'),
('Sonar Bangla', 'Tejgaon', 'Airport Tejgaon', '7:12am', '7:50am', '40'),
('Sonar Bangla', 'Tejgaon', 'Tongi', '7:12am', '8:00am', '50'),
('Sonar Bangla', 'Tejgaon', 'Narsingdi', '7:12am', '8:15am', '70'),
('Sonar Bangla', 'Tejgaon', 'Amirganj', '7:12am', '8:20am', '80'),
('Sonar Bangla', 'Tejgaon', 'Bhairab Bazar', '7:12am', '8:25am', '90'),
('Sonar Bangla', 'Tejgaon', 'Ashuganj', '7:12am', '8:35am', '100'),
('Sonar Bangla', 'Tejgaon', 'Brahmanbaria', '7:12am', '8:45am', '120'),
('Sonar Bangla', 'Tejgaon', 'Akhawra', '7:12am', '9:00am', '140'),
('Sonar Bangla', 'Tejgaon', 'Gongasagor', '7:12am', '9:20am', '155'),
('Sonar Bangla', 'Tejgaon', 'Kasava', '7:12am', '9:35am', '180'),
('Sonar Bangla', 'Tejgaon', 'Mondhobagh', '7:12am', '9:50am', '190'),
('Sonar Bangla', 'Tejgaon', 'Shoshidhol', '7:12am', '10:00am', '210'),
('Sonar Bangla', 'Tejgaon', 'Comilla', '7:12am', '10:15am', '230'),
('Sonar Bangla', 'Tejgaon', 'Laksam', '7:12am', '10:30am', '250'),
('Sonar Bangla', 'Tejgaon', 'Nangolcoart', '7:12am', '10:50am', '270'),
('Sonar Bangla', 'Tejgaon', 'Hasanpur', '7:12am', '11:10am', '280'),
('Sonar Bangla', 'Tejgaon', 'Feni', '7:12am', '11:25am', '290'),
('Sonar Bangla', 'Tejgaon', 'Cinki Astana', '7:12am', '11:40am', '300'),
('Sonar Bangla', 'Tejgaon', 'Bhatiari', '7:12am', '11:50am', '310'),
('Sonar Bangla', 'Tejgaon', 'Foujdarhat Junction', '7:12am', '12:00am', '330'),
('Sonar Bangla', 'Tejgaon', 'Chittagong', '7:12am', '12:20pm', '340'),
('Sonar Bangla', 'Banani', 'Dhaka Cantonment', '7:25am', '7:38am', '20'),
('Sonar Bangla', 'Banani', 'Airport Banani', '7:25am', '7:50am', '30'),
('Sonar Bangla', 'Banani', 'Tongi', '7:25am', '8:00am', '40'),
('Sonar Bangla', 'Banani', 'Narsingdi', '7:25am', '8:15am', '60'),
('Sonar Bangla', 'Banani', 'Amirganj', '7:25am', '8:20am', '70'),
('Sonar Bangla', 'Banani', 'Bhairab Bazar', '7:25am', '8:25am', '80'),
('Sonar Bangla', 'Banani', 'Ashuganj', '7:25am', '8:35am', '90'),
('Sonar Bangla', 'Banani', 'Brahmanbaria', '7:25am', '8:45am', '110'),
('Sonar Bangla', 'Banani', 'Akhawra', '7:25am', '9:00am', '130'),
('Sonar Bangla', 'Banani', 'Gongasagor', '7:25am', '9:20am', '145'),
('Sonar Bangla', 'Banani', 'Kasava', '7:25am', '9:35am', '170'),
('Sonar Bangla', 'Banani', 'Mondhobagh', '7:25am', '9:50am', '180'),
('Sonar Bangla', 'Banani', 'Shoshidhol', '7:25am', '10:00am', '200'),
('Sonar Bangla', 'Banani', 'Comilla', '7:25am', '10:15am', '220'),
('Sonar Bangla', 'Banani', 'Laksam', '7:25am', '10:30am', '240'),
('Sonar Bangla', 'Banani', 'Nangolcoart', '7:25am', '10:50am', '260'),
('Sonar Bangla', 'Banani', 'Hasanpur', '7:25am', '11:10am', '270'),
('Sonar Bangla', 'Banani', 'Feni', '7:25am', '11:25am', '280'),
('Sonar Bangla', 'Banani', 'Cinki Astana', '7:25am', '11:40am', '290'),
('Sonar Bangla', 'Banani', 'Bhatiari', '7:25am', '11:50am', '300'),
('Sonar Bangla', 'Banani', 'Foujdarhat Junction', '7:25am', '12:00am', '320'),
('Sonar Bangla', 'Banani', 'Chittagong', '7:25am', '12:20pm', '330'),
('Sonar Bangla', 'Dhaka Cantonment', 'Airport Dhaka', '7:38am', '7:50am', '20'),
('Sonar Bangla', 'Dhaka Cantonment', 'Tongi', '7:38am', '8:00am', '30'),
('Sonar Bangla', 'Dhaka Cantonment', 'Narsingdi', '7:38am', '8:15am', '50'),
('Sonar Bangla', 'Dhaka Cantonment', 'Amirganj', '7:38am', '8:20am', '60'),
('Sonar Bangla', 'Dhaka Cantonment', 'Bhairab Bazar', '7:38am', '8:25am', '70'),
('Sonar Bangla', 'Dhaka Cantonment', 'Ashuganj', '7:38am', '8:35am', '80'),
('Sonar Bangla', 'Dhaka Cantonment', 'Brahmanbaria', '7:38am', '8:45am', '100'),
('Sonar Bangla', 'Dhaka Cantonment', 'Akhawra', '7:38am', '9:00am', '120'),
('Sonar Bangla', 'Dhaka Cantonment', 'Gongasagor', '7:38am', '9:20am', '135'),
('Sonar Bangla', 'Dhaka Cantonment', 'Kasava', '7:38am', '9:35am', '160'),
('Sonar Bangla', 'Dhaka Cantonment', 'Mondhobagh', '7:38am', '9:50am', '170'),
('Sonar Bangla', 'Dhaka Cantonment', 'Shoshidhol', '7:38am', '10:00am', '190'),
('Sonar Bangla', 'Dhaka Cantonment', 'Comilla', '7:38am', '10:15am', '210'),
('Sonar Bangla', 'Dhaka Cantonment', 'Laksam', '7:38am', '10:30am', '230'),
('Sonar Bangla', 'Dhaka Cantonment', 'Nangolcoart', '7:38am', '10:50am', '250'),
('Sonar Bangla', 'Dhaka Cantonment', 'Hasanpur', '7:38am', '11:10am', '260'),
('Sonar Bangla', 'Dhaka Cantonment', 'Feni', '7:38am', '11:25am', '270'),
('Sonar Bangla', 'Dhaka Cantonment', 'Cinki Astana', '7:38am', '11:40am', '280'),
('Sonar Bangla', 'Dhaka Cantonment', 'Bhatiari', '7:38am', '11:50am', '290'),
('Sonar Bangla', 'Dhaka Cantonment', 'Foujdarhat Junction', '7:38am', '12:00am', '310'),
('Sonar Bangla', 'Dhaka Cantonment', 'Chittagong', '7:38am', '12:20pm', '320'),
('Sonar Bangla', 'Airport Dhaka', 'Tongi', '7:50am', '8:00am', '20'),
('Sonar Bangla', 'Airport Dhaka', 'Narsingdi', '7:50am', '8:15am', '40'),
('Sonar Bangla', 'Airport Dhaka', 'Amirganj', '7:50am', '8:20am', '50'),
('Sonar Bangla', 'Airport Dhaka', 'Bhairab Bazar', '7:50am', '8:25am', '60'),
('Sonar Bangla', 'Airport Dhaka', 'Ashuganj', '7:50am', '8:35am', '70'),
('Sonar Bangla', 'Airport Dhaka', 'Brahmanbaria', '7:50am', '8:45am', '90'),
('Sonar Bangla', 'Airport Dhaka', 'Akhawra', '7:50am', '9:00am', '110'),
('Sonar Bangla', 'Airport Dhaka', 'Gongasagor', '7:50am', '9:20am', '125'),
('Sonar Bangla', 'Airport Dhaka', 'Kasava', '7:50am', '9:35am', '150'),
('Sonar Bangla', 'Airport Dhaka', 'Mondhobagh', '7:50am', '9:50am', '160'),
('Sonar Bangla', 'Airport Dhaka', 'Shoshidhol', '7:50am', '10:00am', '180'),
('Sonar Bangla', 'Airport Dhaka', 'Comilla', '7:50am', '10:15am', '200'),
('Sonar Bangla', 'Airport Dhaka', 'Laksam', '7:50am', '10:30am', '220'),
('Sonar Bangla', 'Airport Dhaka', 'Nangolcoart', '7:50am', '10:50am', '240'),
('Sonar Bangla', 'Airport Dhaka', 'Hasanpur', '7:50am', '11:10am', '250'),
('Sonar Bangla', 'Airport Dhaka', 'Feni', '7:50am', '11:25am', '260'),
('Sonar Bangla', 'Airport Dhaka', 'Cinki Astana', '7:50am', '11:40am', '270'),
('Sonar Bangla', 'Airport Dhaka', 'Bhatiari', '7:50am', '11:50am', '280'),
('Sonar Bangla', 'Airport Dhaka', 'Foujdarhat Junction', '7:50am', '12:00am', '300'),
('Sonar Bangla', 'Airport Dhaka', 'Chittagong', '7:50am', '12:20pm', '310'),
('Sonar Bangla', 'Tongi', 'Narsingdi', '8:00am', '8:15am', '20'),
('Sonar Bangla', 'Tongi', 'Amirganj', '8:00am', '8:20am', '30'),
('Sonar Bangla', 'Tongi', 'Bhairab Bazar', '8:00am', '8:25am', '40'),
('Sonar Bangla', 'Tongi', 'Ashuganj', '8:00am', '8:35am', '50'),
('Sonar Bangla', 'Tongi', 'Brahmanbaria', '8:00am', '8:45am', '70'),
('Sonar Bangla', 'Tongi', 'Akhawra', '8:00am', '9:00am', '90'),
('Sonar Bangla', 'Tongi', 'Gongasagor', '8:00am', '9:20am', '105'),
('Sonar Bangla', 'Tongi', 'Kasava', '8:00am', '9:35am', '130'),
('Sonar Bangla', 'Tongi', 'Mondhobagh', '8:00am', '9:50am', '140'),
('Sonar Bangla', 'Tongi', 'Shoshidhol', '8:00am', '10:00am', '160'),
('Sonar Bangla', 'Tongi', 'Comilla', '8:00am', '10:15am', '180'),
('Sonar Bangla', 'Tongi', 'Laksam', '8:00am', '10:30am', '200'),
('Sonar Bangla', 'Tongi', 'Nangolcoart', '8:00am', '10:50am', '220'),
('Sonar Bangla', 'Tongi', 'Hasanpur', '8:00am', '11:10am', '230'),
('Sonar Bangla', 'Tongi', 'Feni', '8:00am', '11:25am', '240'),
('Sonar Bangla', 'Tongi', 'Cinki Astana', '8:00am', '11:40am', '250'),
('Sonar Bangla', 'Tongi', 'Bhatiari', '8:00am', '11:50am', '260'),
('Sonar Bangla', 'Tongi', 'Foujdarhat Junction', '8:00am', '12:00am', '280'),
('Sonar Bangla', 'Tongi', 'Chittagong', '8:00am', '12:20pm', '290'),
('Sonar Bangla', 'Narsingdi', 'Amirganj', '8:15am', '8:20am', '20'),
('Sonar Bangla', 'Narsingdi', 'Bhairab Bazar', '8:15am', '8:25am', '30'),
('Sonar Bangla', 'Narsingdi', 'Ashuganj', '8:15am', '8:35am', '40'),
('Sonar Bangla', 'Narsingdi', 'Brahmanbaria', '8:15am', '8:45am', '60'),
('Sonar Bangla', 'Narsingdi', 'Akhawra', '8:15am', '9:00am', '80'),
('Sonar Bangla', 'Narsingdi', 'Gongasagor', '8:15am', '9:20am', '95'),
('Sonar Bangla', 'Narsingdi', 'Kasava', '8:15am', '9:35am', '120'),
('Sonar Bangla', 'Narsingdi', 'Mondhobagh', '8:15am', '9:50am', '130'),
('Sonar Bangla', 'Narsingdi', 'Shoshidhol', '8:15am', '10:00am', '150'),
('Sonar Bangla', 'Narsingdi', 'Comilla', '8:15am', '10:15am', '170'),
('Sonar Bangla', 'Narsingdi', 'Laksam', '8:15am', '10:30am', '180'),
('Sonar Bangla', 'Narsingdi', 'Nangolcoart', '8:15am', '10:50am', '210'),
('Sonar Bangla', 'Narsingdi', 'Hasanpur', '8:15am', '11:10am', '220'),
('Sonar Bangla', 'Narsingdi', 'Feni', '8:15am', '11:25am', '230'),
('Sonar Bangla', 'Narsingdi', 'Cinki Astana', '8:15am', '11:40am', '240'),
('Sonar Bangla', 'Narsingdi', 'Bhatiari', '8:15am', '11:50am', '250'),
('Sonar Bangla', 'Narsingdi', 'Foujdarhat Junction', '8:15am', '12:00am', '270'),
('Sonar Bangla', 'Narsingdi', 'Chittagong', '8:15am', '12:20pm', '280'),
('Sonar Bangla', 'Amirganj', 'Bhairab Bazar', '8:20am', '8:25am', '30'),
('Sonar Bangla', 'Amirganj', 'Ashuganj', '8:20am', '8:35am', '40'),
('Sonar Bangla', 'Amirganj', 'Brahmanbaria', '8:20am', '8:45am', '60'),
('Sonar Bangla', 'Amirganj', 'Akhawra', '8:20am', '9:00am', '80'),
('Sonar Bangla', 'Amirganj', 'Gongasagor', '8:20am', '9:20am', '95'),
('Sonar Bangla', 'Amirganj', 'Kasava', '8:20am', '9:35am', '120'),
('Sonar Bangla', 'Amirganj', 'Mondhobagh', '8:20am', '9:50am', '130'),
('Sonar Bangla', 'Amirganj', 'Shoshidhol', '8:20am', '10:00am', '150'),
('Sonar Bangla', 'Amirganj', 'Comilla', '8:20am', '10:15am', '170'),
('Sonar Bangla', 'Amirganj', 'Bhairab Bazar', '8:20am', '8:25am', '30'),
('Sonar Bangla', 'Amirganj', 'Ashuganj', '8:20am', '8:35am', '40'),
('Sonar Bangla', 'Amirganj', 'Brahmanbaria', '8:20am', '8:45am', '60'),
('Sonar Bangla', 'Amirganj', 'Akhawra', '8:20am', '9:00am', '80'),
('Sonar Bangla', 'Amirganj', 'Gongasagor', '8:20am', '9:20am', '95'),
('Sonar Bangla', 'Amirganj', 'Kasava', '8:20am', '9:35am', '120'),
('Sonar Bangla', 'Amirganj', 'Mondhobagh', '8:20am', '9:50am', '130'),
('Sonar Bangla', 'Amirganj', 'Shoshidhol', '8:20am', '10:00am', '150'),
('Sonar Bangla', 'Amirganj', 'Comilla', '8:20am', '10:15am', '170'),
('Sonar Bangla', 'Amirganj', 'Laksam', '8:20am', '10:30am', '180'),
('Sonar Bangla', 'Amirganj', 'Nangolcoart', '8:20am', '10:50am', '210'),
('Sonar Bangla', 'Amirganj', 'Hasanpur', '8:20am', '11:10am', '220'),
('Sonar Bangla', 'Amirganj', 'Feni', '8:20am', '11:25am', '230'),
('Sonar Bangla', 'Amirganj', 'Cinki Astana', '8:20am', '11:40am', '240'),
('Sonar Bangla', 'Amirganj', 'Bhatiari', '8:20am', '11:50am', '250'),
('Sonar Bangla', 'Amirganj', 'Foujdarhat Junction', '8:20am', '12:00am', '270'),
('Sonar Bangla', 'Amirganj', 'Chittagong', '8:20am', '12:20pm', '280'),
('Sonar Bangla', 'Bhairab Bazar', 'Ashuganj', '8:25am', '8:35am', '20'),
('Sonar Bangla', 'Bhairab Bazar', 'Brahmanbaria', '8:25am', '8:45am', '40'),
('Sonar Bangla', 'Bhairab Bazar', 'Akhawra', '8:25am', '9:00am', '60'),
('Sonar Bangla', 'Bhairab Bazar', 'Gongasagor', '8:25am', '9:20am', '75'),
('Sonar Bangla', 'Bhairab Bazar', 'Kasava', '8:25am', '9:35am', '100'),
('Sonar Bangla', 'Bhairab Bazar', 'Mondhobagh', '8:25am', '9:50am', '110'),
('Sonar Bangla', 'Bhairab Bazar', 'Shoshidhol', '8:25am', '10:00am', '130'),
('Sonar Bangla', 'Bhairab Bazar', 'Comilla', '8:25am', '10:15am', '150'),
('Sonar Bangla', 'Bhairab Bazar', 'Laksam', '8:25am', '10:30am', '160'),
('Sonar Bangla', 'Bhairab Bazar', 'Nangolcoart', '8:25am', '10:50am', '190'),
('Sonar Bangla', 'Bhairab Bazar', 'Hasanpur', '8:25am', '11:10am', '200'),
('Sonar Bangla', 'Bhairab Bazar', 'Feni', '8:25am', '11:25am', '210'),
('Sonar Bangla', 'Bhairab Bazar', 'Cinki Astana', '8:25am', '11:40am', '220'),
('Sonar Bangla', 'Bhairab Bazar', 'Bhatiari', '8:25am', '11:50am', '230'),
('Sonar Bangla', 'Bhairab Bazar', 'Foujdarhat Junction', '8:25am', '12:00am', '240'),
('Sonar Bangla', 'Bhairab Bazar', 'Chittagong', '8:25am', '12:20pm', '260'),
('Sonar Bangla', 'Ashuganj', 'Brahmanbaria', '8:35am', '8:45am', '20'),
('Sonar Bangla', 'Ashuganj', 'Akhawra', '8:35am', '9:00am', '40'),
('Sonar Bangla', 'Ashuganj', 'Gongasagor', '8:35am', '9:20am', '55'),
('Sonar Bangla', 'Ashuganj', 'Kasava', '8:35am', '9:35am', '80'),
('Sonar Bangla', 'Ashuganj', 'Mondhobagh', '8:35am', '9:50am', '90'),
('Sonar Bangla', 'Ashuganj', 'Shoshidhol', '8:35am', '10:00am', '110'),
('Sonar Bangla', 'Ashuganj', 'Comilla', '8:35am', '10:15am', '130'),
('Sonar Bangla', 'Ashuganj', 'Laksam', '8:35am', '10:30am', '140'),
('Sonar Bangla', 'Ashuganj', 'Nangolcoart', '8:35am', '10:50am', '170'),
('Sonar Bangla', 'Ashuganj', 'Hasanpur', '8:35am', '11:10am', '180'),
('Sonar Bangla', 'Ashuganj', 'Feni', '8:35am', '11:25am', '190'),
('Sonar Bangla', 'Ashuganj', 'Cinki Astana', '8:35am', '11:40am', '200'),
('Sonar Bangla', 'Ashuganj', 'Bhatiari', '8:35am', '11:50am', '210'),
('Sonar Bangla', 'Ashuganj', 'Foujdarhat Junction', '8:35am', '12:00am', '230'),
('Sonar Bangla', 'Ashuganj', 'Chittagong', '8:35am', '12:20pm', '250'),
('Sonar Bangla', 'Brahmanbaria', 'Akhawra', '8:45am', '9:00am', '20'),
('Sonar Bangla', 'Brahmanbaria', 'Gongasagor', '8:45am', '9:20am', '35'),
('Sonar Bangla', 'Brahmanbaria', 'Kasava', '8:45am', '9:35am', '60'),
('Sonar Bangla', 'Brahmanbaria', 'Mondhobagh', '8:45am', '9:50am', '70'),
('Sonar Bangla', 'Brahmanbaria', 'Shoshidhol', '8:45am', '10:00am', '90'),
('Sonar Bangla', 'Brahmanbaria', 'Comilla', '8:45am', '10:15am', '110'),
('Sonar Bangla', 'Brahmanbaria', 'Laksam', '8:45am', '10:30am', '120'),
('Sonar Bangla', 'Brahmanbaria', 'Nangolcoart', '8:45am', '10:50am', '150'),
('Sonar Bangla', 'Brahmanbaria', 'Hasanpur', '8:45am', '11:10am', '160'),
('Sonar Bangla', 'Brahmanbaria', 'Feni', '8:45am', '11:25am', '170'),
('Sonar Bangla', 'Brahmanbaria', 'Cinki Astana', '8:45am', '11:40am', '180'),
('Sonar Bangla', 'Brahmanbaria', 'Bhatiari', '8:45am', '11:50am', '190'),
('Sonar Bangla', 'Brahmanbaria', 'Foujdarhat Junction', '8:45am', '12:00am', '210'),
('Sonar Bangla', 'Brahmanbaria', 'Chittagong', '8:45am', '12:20pm', '230'),
('Sonar Bangla', 'Akhawra', 'Gongasagor', '9:00am', '9:20am', '20'),
('Sonar Bangla', 'Akhawra', 'Kasava', '9:00am', '9:35am', '40'),
('Sonar Bangla', 'Akhawra', 'Mondhobagh', '9:00am', '9:50am', '50'),
('Sonar Bangla', 'Akhawra', 'Shoshidhol', '9:00am', '10:00am', '70'),
('Sonar Bangla', 'Akhawra', 'Comilla', '9:00am', '10:15am', '90'),
('Sonar Bangla', 'Akhawra', 'Laksam', '9:00am', '10:30am', '100'),
('Sonar Bangla', 'Akhawra', 'Nangolcoart', '9:00am', '10:50am', '130'),
('Sonar Bangla', 'Akhawra', 'Hasanpur', '9:00am', '11:10am', '140'),
('Sonar Bangla', 'Akhawra', 'Feni', '9:00am', '11:25am', '150'),
('Sonar Bangla', 'Akhawra', 'Cinki Astana', '9:00am', '11:40am', '160'),
('Sonar Bangla', 'Akhawra', 'Bhatiari', '9:00am', '11:50am', '170'),
('Sonar Bangla', 'Akhawra', 'Foujdarhat Junction', '9:00am', '12:00am', '190'),
('Sonar Bangla', 'Akhawra', 'Chittagong', '9:00am', '12:20pm', '210'),
('Sonar Bangla', 'Gongasagor', 'Kasava', '9:20am', '9:35am', '20'),
('Sonar Bangla', 'Gongasagor', 'Mondhobagh', '9:20am', '9:50am', '30'),
('Sonar Bangla', 'Gongasagor', 'Shoshidhol', '9:20am', '10:00am', '50'),
('Sonar Bangla', 'Gongasagor', 'Comilla', '9:20am', '10:15am', '70'),
('Sonar Bangla', 'Gongasagor', 'Laksam', '9:20am', '10:30am', '90'),
('Sonar Bangla', 'Gongasagor', 'Nangolcoart', '9:20am', '10:50am', '110'),
('Sonar Bangla', 'Gongasagor', 'Hasanpur', '9:20am', '11:10am', '120'),
('Sonar Bangla', 'Gongasagor', 'Feni', '9:20am', '11:25am', '130'),
('Sonar Bangla', 'Gongasagor', 'Cinki Astana', '9:20am', '11:40am', '140'),
('Sonar Bangla', 'Gongasagor', 'Bhatiari', '9:20am', '11:50am', '150'),
('Sonar Bangla', 'Gongasagor', 'Foujdarhat Junction', '9:20am', '12:00am', '170'),
('Sonar Bangla', 'Gongasagor', 'Chittagong', '9:20am', '12:20pm', '190'),
('Sonar Bangla', 'Kasava', 'Mondhobagh', '9:35am', '9:50am', '20'),
('Sonar Bangla', 'Kasava', 'Shoshidhol', '9:35am', '10:00am', '30'),
('Sonar Bangla', 'Kasava', 'Comilla', '9:35am', '10:15am', '50'),
('Sonar Bangla', 'Kasava', 'Laksam', '9:35am', '10:30am', '70'),
('Sonar Bangla', 'Kasava', 'Nangolcoart', '9:35am', '10:50am', '90'),
('Sonar Bangla', 'Kasava', 'Hasanpur', '9:35am', '11:10am', '100'),
('Sonar Bangla', 'Kasava', 'Feni', '9:35am', '11:25am', '110'),
('Sonar Bangla', 'Kasava', 'Cinki Astana', '9:35am', '11:40am', '120'),
('Sonar Bangla', 'Kasava', 'Bhatiari', '9:35am', '11:50am', '130'),
('Sonar Bangla', 'Kasava', 'Foujdarhat Junction', '9:35am', '12:00am', '150'),
('Sonar Bangla', 'Kasava', 'Chittagong', '9:35am', '12:20pm', '170'),
('Sonar Bangla', 'Mondhobagh', 'Shoshidhol', '9:50am', '10:00am', '20'),
('Sonar Bangla', 'Mondhobagh', 'Comilla', '9:50am', '10:15am', '30'),
('Sonar Bangla', 'Mondhobagh', 'Laksam', '9:50am', '10:30am', '50'),
('Sonar Bangla', 'Mondhobagh', 'Nangolcoart', '9:50am', '10:50am', '70'),
('Sonar Bangla', 'Mondhobagh', 'Hasanpur', '9:50am', '11:10am', '90'),
('Sonar Bangla', 'Mondhobagh', 'Feni', '9:50am', '11:25am', '100'),
('Sonar Bangla', 'Mondhobagh', 'Cinki Astana', '9:50am', '11:40am', '110'),
('Sonar Bangla', 'Mondhobagh', 'Bhatiari', '9:50am', '11:50am', '120'),
('Sonar Bangla', 'Mondhobagh', 'Foujdarhat Junction', '9:50am', '12:00am', '130'),
('Sonar Bangla', 'Mondhobagh', 'Chittagong', '9:50am', '12:20pm', '160'),
('Sonar Bangla', 'Shoshidhol', 'Comilla', '10:00am', '10:15am', '20'),
('Sonar Bangla', 'Shoshidhol', 'Laksam', '10:00am', '10:30am', '30'),
('Sonar Bangla', 'Shoshidhol', 'Nangolcoart', '10:00am', '10:50am', '50'),
('Sonar Bangla', 'Shoshidhol', 'Hasanpur', '10:00am', '11:10am', '70'),
('Sonar Bangla', 'Shoshidhol', 'Feni', '10:00am', '11:25am', '80'),
('Sonar Bangla', 'Shoshidhol', 'Cinki Astana', '10:00am', '11:40am', '100'),
('Sonar Bangla', 'Shoshidhol', 'Bhatiari', '10:00am', '11:50am', '110'),
('Sonar Bangla', 'Shoshidhol', 'Foujdarhat Junction', '10:00am', '12:00am', '120'),
('Sonar Bangla', 'Shoshidhol', 'Chittagong', '10:00am', '12:20pm', '140'),
('Sonar Bangla', 'Comilla', 'Laksam', '10:15am', '10:30am', '20'),
('Sonar Bangla', 'Comilla', 'Nangolcoart', '10:15am', '10:50am', '30'),
('Sonar Bangla', 'Comilla', 'Hasanpur', '10:15am', '11:10am', '50'),
('Sonar Bangla', 'Comilla', 'Feni', '10:15am', '11:25am', '60'),
('Sonar Bangla', 'Comilla', 'Cinki Astana', '10:15am', '11:40am', '80'),
('Sonar Bangla', 'Comilla', 'Bhatiari', '10:15am', '11:50am', '90'),
('Sonar Bangla', 'Comilla', 'Foujdarhat Junction', '10:15am', '12:00am', '100'),
('Sonar Bangla', 'Comilla', 'Chittagong', '10:15am', '12:20pm', '120'),
('Sonar Bangla', 'Laksam', 'Nangolcoart', '10:30am', '10:50am', '20'),
('Sonar Bangla', 'Laksam', 'Hasanpur', '10:30am', '11:10am', '30'),
('Sonar Bangla', 'Laksam', 'Feni', '10:30am', '11:25am', '50'),
('Sonar Bangla', 'Laksam', 'Cinki Astana', '10:30am', '11:40am', '60'),
('Sonar Bangla', 'Laksam', 'Bhatiari', '10:30am', '11:50am', '70'),
('Sonar Bangla', 'Laksam', 'Foujdarhat Junction', '10:30am', '12:00am', '80'),
('Sonar Bangla', 'Laksam', 'Chittagong', '10:30am', '12:20pm', '110'),
('Sonar Bangla', 'Nangolcoart', 'Hasanpur', '10:50am', '11:10am', '20'),
('Sonar Bangla', 'Nangolcoart', 'Feni', '10:50am', '11:25am', '30'),
('Sonar Bangla', 'Nangolcoart', 'Cinki Astana', '10:50am', '11:40am', '40'),
('Sonar Bangla', 'Nangolcoart', 'Bhatiari', '10:50am', '11:50am', '50'),
('Sonar Bangla', 'Nangolcoart', 'Foujdarhat Junction', '10:50am', '12:00am', '60'),
('Sonar Bangla', 'Nangolcoart', 'Chittagong', '10:50am', '12:20pm', '90'),
('Sonar Bangla', 'Hasanpur', 'Feni', '11:10am', '11:25am', '20'),
('Sonar Bangla', 'Hasanpur', 'Cinki Astana', '11:10am', '11:40am', '30'),
('Sonar Bangla', 'Hasanpur', 'Bhatiari', '11:10am', '11:50am', '40'),
('Sonar Bangla', 'Hasanpur', 'Foujdarhat Junction', '11:10am', '12:00am', '50'),
('Sonar Bangla', 'Hasanpur', 'Chittagong', '11:10am', '12:20pm', '70'),
('Sonar Bangla', 'Feni', 'Cinki Astana', '11:25am', '11:40am', '20'),
('Sonar Bangla', 'Feni', 'Bhatiari', '11:25am', '11:50am', '30'),
('Sonar Bangla', 'Feni', 'Foujdarhat Junction', '11:25am', '12:00am', '40'),
('Sonar Bangla', 'Feni', 'Chittagong', '11:25am', '12:20pm', '60'),
('Sonar Bangla', 'Cinki Astana', 'Bhatiari', '11:40am', '11:50am', '20'),
('Sonar Bangla', 'Cinki Astana', 'Foujdarhat Junction', '11:40am', '12:00am', '30'),
('Sonar Bangla', 'Cinki Astana', 'Chittagong', '11:40am', '12:20pm', '50'),
('Sonar Bangla', 'Bhatiari', 'Foujdarhat Junction', '11:50am', '12:00am', '20'),
('Sonar Bangla', 'Bhatiari', 'Chittagong', '11:50am', '12:20pm', '40'),
('Sonar Bangla', 'Foujdarhat Junction', 'Chittagong', '11:50am', '12:20pm', '20'),
('Mohanagar Pravati', 'Dhaka', 'Tejgaon', '7:00am', '7:12am', '20'),
('Mohanagar Pravati', 'Dhaka', 'Tejgaon', '7:00am', '7:12am', '22'),
('Mohanagar Pravati', 'Dhaka', 'Banani', '7:00am', '7:25am', '30'),
('Mohanagar Pravati', 'Dhaka', 'Dhaka Cantonment', '7:00am', '7:38am', '40'),
('Mohanagar Pravati', 'Dhaka', 'Airport Dhaka', '7:00am', '7:50am', '50'),
('Mohanagar Pravati', 'Dhaka', 'Tongi', '7:00am', '8:00am', '60'),
('Mohanagar Pravati', 'Dhaka', 'Narsingdi', '7:00am', '8:15am', '80'),
('Mohanagar Pravati', 'Dhaka', 'Amirganj', '7:00am', '8:20am', '90'),
('Mohanagar Pravati', 'Dhaka', 'Bhairab Bazar', '7:00am', '8:25am', '90'),
('Mohanagar Pravati', 'Dhaka', 'Ashuganj', '7:00am', '7:35am', '100'),
('Mohanagar Pravati', 'Dhaka', 'Brahmanbaria', '7:00am', '8:45am', '110'),
('Mohanagar Pravati', 'Dhaka', 'Gongasagor', '7:00am', '9:20am', '165'),
('Mohanagar Pravati', 'Dhaka', 'Kasava', '7:00am', '9:35am', '190'),
('Mohanagar Pravati', 'Dhaka', 'Mondhobagh', '7:00am', '9:50am', '200'),
('Mohanagar Pravati', 'Dhaka', 'Shoshidhol', '7:00am', '10:00am', '220'),
('Mohanagar Pravati', 'Dhaka', 'Laksam', '7:00am', '10:30am', '260'),
('Mohanagar Pravati', 'Dhaka', 'Nangolcoart', '7:00am', '10:50am', '280'),
('Mohanagar Pravati', 'Dhaka', 'Hasanpur', '7:00am', '11:10am', '300'),
('Mohanagar Pravati', 'Dhaka', 'Feni', '7:00am', '11:25am', '310'),
('Mohanagar Pravati', 'Dhaka', 'Cinki Astana', '7:00am', '11:40am', '320'),
('Mohanagar Pravati', 'Dhaka', 'Bhatiari', '7:00am', '11:50am', '330'),
('Mohanagar Pravati', 'Tejgaon', 'Banani', '7:00am', '7:25am', '50'),
('Mohanagar Pravati', 'Tejgaon', 'Dhaka Cantonment', '7:00am', '7:28am', '60'),
('Mohanagar Pravati', 'Tejgaon', 'Airport Tejgaon', '7:00am', '7:55am', '60'),
('Mohanagar Pravati', 'Tejgaon', 'Tongi', '7:00am', '7:58am', '62'),
('Mohanagar Pravati', 'Tejgaon', 'Narsingdi', '7:00am', '8:05am', '65'),
('Mohanagar Pravati', 'Tejgaon', 'Bhairab Bazar', '7:00am', '8:10am', '70'),
('Parabat Express', 'Airport Dhaka', 'Tongi', '7:50am', '8:00am', '30'),
('Parabat Express', 'Airport Dhaka', 'Narsingdi', '7:50am', '8:15am', '35'),
('Parabat Express', 'Airport Dhaka', 'mirganj', '7:50am', '8:20am', '40'),
('Parabat Express', 'Airport Dhaka', 'Bhairab Bazar', '7:50am', '8:25am', '50'),
('Parabat Express', 'Airport Dhaka', 'Ashuganj', '7:50am', '8:35am', '50'),
('Parabat Express', 'Airport Dhaka', 'Brahmanbaria', '7:50am', '8:35am', '90'),
('Parabat Express', 'Airport Dhaka', 'Akhawra', '7:50am', '7:40am', '110'),
('Parabat Express', 'Airport Dhaka', 'Gongasagor', '7:50am', '9:20am', '125'),
('Parabat Express', 'Airport Dhaka', 'Kasava', '7:50am', '9:35am', '150'),
('Parabat Express', 'Airport Dhaka', 'Mondhobagh', '7:50am', '9:50am', '160'),
('Parabat Express', 'Airport Dhaka', 'BShoshidhol', '7:50am', '10:00am', '180'),
('Parabat Express', 'Tongi', 'Ashuganj', '7:50am', '8:25am', '30'),
('Parabat Express', 'Tongi', 'Brahmanbaria', '7:50am', '8:35am', '70'),
('Parabat Express', 'Tongi', 'Akhawra', '7:50am', '8:40am', '100'),
('Parabat Express', 'Tongi', 'Gongasagor', '7:50am', '8:50am', '110'),
('Parabat Express', 'Tongi', 'BKasava', '7:50am', '8:45am', '130'),
('Parabat Express', 'Tongi', 'Mondhobagh', '7:50am', '8:55am', '140'),
('Parabat Express', 'Tongi', 'Shoshidhol', '7:50am', '9:00am', '160'),
('Parabat Express', 'Tongi', 'Comilla', '7:50am', '9:10am', '170'),
('Agnibina Express', 'Dhaka', 'Banani', '7:50am', '7:25am', '30'),
('Agnibina Express', 'Dhaka', 'Tejgaon', '7:50am', '7:20am', '20'),
('Agnibina Express', 'Dhaka', 'Dhaka Cantonment', '7:50am', '7:30am', '40'),
('Agnibina Express', 'Dhaka', 'Airport Dhaka', '7:50am', '7:35am', '50'),
('Agnibina Express', 'Dhaka', 'Tongi', '7:50am', '7:40am', '55'),
('Agnibina Express', 'Dhaka', 'Narsingdi', '7:50am', '7:45am', '60'),
('Agnibina Express', 'Dhaka', 'mirganj', '7:50am', '7:50am', '70'),
('Agnibina Express', 'Dhaka', 'Amirganj', '7:50am', '7:50am', '70'),
('Agnibina Express', 'Dhaka', 'hairab Bazar', '7:50am', '8:10am', '80'),
('Agnibina Express', 'Dhaka', 'Ashuganj', '7:50am', '8:15am', '90'),
('Agnibina Express', 'Dhaka', 'rahmanbaria', '7:50am', '8:25am', '110'),
('Agnibina Express', 'Dhaka Cantonment', 'Airport Dhaka', '7:50am', '8:25am', '60'),
('Agnibina Express', 'Dhaka Cantonment', 'Tongi', '7:50am', '8:35am', '70'),
('Agnibina Express', 'Dhaka Cantonment', 'Narsingdi', '7:50am', '8:45am', '80'),
('Agnibina Express', 'Dhaka Cantonment', 'Amirganj', '7:50am', '8:50am', '90'),
('Agnibina Express', 'Dhaka Cantonment', 'Bhairab Bazar', '7:50am', '8:55am', '95'),
('Agnibina Express', 'Dhaka Cantonment', 'Ashuganj', '7:50am', '9:10am', '130'),
('Agnibina Express', 'Dhaka Cantonment', 'Brahmanbaria', '7:50am', '9:20am', '140'),
('Agnibina Express', 'Dhaka Cantonment', 'Akhawra', '7:50am', '9:30am', '150'),
('Agnibina Express', 'Dhaka Cantonment', 'Gongasagor', '7:50am', '9:35am', '160'),
('Agnibina Express', 'Dhaka Cantonment', 'Kasava', '7:50am', '9:45am', '180'),
('Mohonganj Express', 'Dhaka Cantonment', 'Banani', '7:50am', '7:25am', '30'),
('Mohonganj Express', 'Dhaka Cantonment', 'Airport Dhaka', '7:50am', '8:35am', '40'),
('Mohonganj Express', 'Dhaka Cantonment', 'Tongi', '7:50am', '8:45am', '50'),
('Mohonganj Express', 'Dhaka Cantonment', 'Amirganj', '7:50am', '8:40am', '60'),
('Mohonganj Express', 'Dhaka Cantonment', 'Bhairab Bazar', '7:50am', '9:10am', '110'),
('Mohonganj Express', 'Dhaka Cantonment', 'Brahmanbaria', '7:50am', ':35am', '160'),
('Mohonganj Express', 'Dhaka Cantonment', 'Akhawra', '7:50am', '9:45am', '140'),
('Mohonganj Express', 'Dhaka Cantonment', 'Gongasagor', '7:50am', '10:25am', '170'),
('Mohonganj Express', 'Dhaka Cantonment', 'Kasava', '7:50am', '10:10am', '180'),
('Mohonganj Express', 'Dhaka Cantonment', 'Mondhobagh', '7:50am', '10:35am', '190'),
('Mohonganj Express', 'Dhaka Cantonment', 'Shoshidhol', '7:50am', '10:55am', '190'),
('Mohonganj Express', 'Dhaka Cantonment', 'Comilla', '7:50am', '10:50am', '190'),
('Mohonganj Express', 'Narsingdi', 'Amirganj', '7:40am', '8:20am', '30'),
('Mohonganj Express', 'Narsingdi', 'Bhairab Bazar', '7:40am', '8:35am', '40'),
('Mohonganj Express', 'Narsingdi', 'Ashuganj', '7:40am', '8:40am', '50'),
('Mohonganj Express', 'Narsingdi', 'Brahmanbaria', '7:40am', '8:45am', '60'),
('Mohonganj Express', 'Narsingdi', 'Akhawra', '7:40am', '8:55am', '70'),
('Mohonganj Express', 'Narsingdi', 'Gongasagor', '7:40am', '9:10am', '70'),
('Mohonganj Express', 'Narsingdi', 'Kasava', '7:40am', '9:20am', '80'),
('Mohonganj Express', 'Narsingdi', 'Mondhobagh', '7:40am', '8:35am', '90'),
('Mohonganj Express', 'Narsingdi', 'Shoshidhol', '7:40am', '9:40am', '100'),
('Mohonganj Express', 'Narsingdi', 'Comilla', '7:50am', '10:35am', '110'),
('Mohonganj Express', 'Narsingdi', 'Laksam', '7:50am', '10:40am', '160'),
('Mohonganj Express', 'Narsingdi', 'Nangolcoart', '7:40am', '10:50am', '170');

-- --------------------------------------------------------

--
-- Table structure for table `trainoff`
--

CREATE TABLE `trainoff` (
  `name` varchar(20) NOT NULL,
  `Date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trainoff`
--

INSERT INTO `trainoff` (`name`, `Date`) VALUES
('Sonar Bangla', '7/16/2022'),
('Sonar Bangla', '7/17/202');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account_section`
--
ALTER TABLE `account_section`
  ADD UNIQUE KEY `Phone` (`Phone`);

--
-- Indexes for table `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`Destination`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
