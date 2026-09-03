/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 10.4.32-MariaDB : Database - seminarski_ps
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski_ps` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `seminarski_ps`;

/*Table structure for table `drzava` */

DROP TABLE IF EXISTS `drzava`;

CREATE TABLE `drzava` (
  `idDrzava` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `skraceniNaziv` varchar(50) NOT NULL,
  `kontinent` varchar(50) NOT NULL,
  `pozivniBroj` varchar(50) NOT NULL,
  PRIMARY KEY (`idDrzava`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `drzava` */

insert  into `drzava`(`idDrzava`,`naziv`,`skraceniNaziv`,`kontinent`,`pozivniBroj`) values 
(1,'Srbija','SRB','Evropa','+381'),
(2,'Sjedinjene Drzave','SAD','Severna Amerika','+1'),
(3,'Nemacka','GER','Evropa','+5'),
(4,'Japan','JPN','Azija','+55');

/*Table structure for table `gost` */

DROP TABLE IF EXISTS `gost`;

CREATE TABLE `gost` (
  `idGost` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `broj` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `idDrzava` bigint(20) NOT NULL,
  PRIMARY KEY (`idGost`),
  KEY `gost_ibfk_1` (`idDrzava`),
  CONSTRAINT `gost_ibfk_1` FOREIGN KEY (`idDrzava`) REFERENCES `drzava` (`idDrzava`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `gost` */

insert  into `gost`(`idGost`,`ime`,`prezime`,`broj`,`email`,`idDrzava`) values 
(2,'Pavle','Pavlovic','+38111859444','pavle@gmail.com',1),
(6,'Djordje','Djordjevic','+3811168493','rndmail@gmail.com',1),
(10,'Nicholas','Berg','+49283871','nick@gmail.com',3),
(13,'John','Davies','+1345958434','john@gmail.com',2),
(15,'Gunther','Löw','+492783821','gunther@email.com',3),
(18,'Shigo','Ishinawa','+98372321','shigo@yahoo.com',4),
(19,'James','Stewart','+19382737','james@gmail.com',2),
(28,'Nikola','Nikolic','0631439584','nikola@gmail.com',1);

/*Table structure for table `recepcioner` */

DROP TABLE IF EXISTS `recepcioner`;

CREATE TABLE `recepcioner` (
  `idRecepcioner` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `broj` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `korisnickoIme` varchar(50) NOT NULL,
  `sifra` varchar(50) NOT NULL,
  PRIMARY KEY (`idRecepcioner`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `recepcioner` */

insert  into `recepcioner`(`idRecepcioner`,`ime`,`prezime`,`broj`,`email`,`korisnickoIme`,`sifra`) values 
(1,'Pera','Peric','061293281','pera@gmail.com','Pera','pera123'),
(2,'Marko','Markovic','066239543','marko@gmail.com','Marko','marko123'),
(8,'Darko','Darkovic','067777777','darko@gmail.com','Darko','darko123');

/*Table structure for table `ress` */

DROP TABLE IF EXISTS `ress`;

CREATE TABLE `ress` (
  `idRecepcioner` bigint(20) NOT NULL,
  `idStrucnaSprema` bigint(20) NOT NULL,
  `datumSticanja` date NOT NULL,
  PRIMARY KEY (`idRecepcioner`,`idStrucnaSprema`),
  KEY `idStrucnaSprema` (`idStrucnaSprema`),
  CONSTRAINT `ress_ibfk_1` FOREIGN KEY (`idRecepcioner`) REFERENCES `recepcioner` (`idRecepcioner`) ON UPDATE CASCADE,
  CONSTRAINT `ress_ibfk_2` FOREIGN KEY (`idStrucnaSprema`) REFERENCES `strucnasprema` (`idStrucnaSprema`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `ress` */

insert  into `ress`(`idRecepcioner`,`idStrucnaSprema`,`datumSticanja`) values 
(1,10,'2011-11-16'),
(2,11,'2021-12-22'),
(8,12,'2008-07-17');

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `idRezervacija` bigint(20) NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL,
  `ukupanIznos` decimal(10,2) NOT NULL,
  `nacinPlacanja` varchar(50) NOT NULL,
  `nacinRezervisanja` varchar(50) NOT NULL,
  `idGost` bigint(20) NOT NULL,
  `idRecepcioner` bigint(20) NOT NULL,
  PRIMARY KEY (`idRezervacija`),
  KEY `idRecepcioner` (`idGost`),
  KEY `idGost` (`idRecepcioner`),
  CONSTRAINT `rezervacija_ibfk_3` FOREIGN KEY (`idGost`) REFERENCES `gost` (`idGost`) ON UPDATE CASCADE,
  CONSTRAINT `rezervacija_ibfk_4` FOREIGN KEY (`idRecepcioner`) REFERENCES `recepcioner` (`idRecepcioner`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`idRezervacija`,`datum`,`ukupanIznos`,`nacinPlacanja`,`nacinRezervisanja`,`idGost`,`idRecepcioner`) values 
(67,'2026-08-13',2620.00,'Kes','Uzivo',15,2),
(68,'2026-08-13',1410.00,'Kartica','Uzivo',2,2),
(70,'2026-08-15',2040.00,'Cekovi','Uzivo',2,2),
(71,'2026-08-15',1210.00,'Kartica','Uzivo',10,2),
(72,'2026-08-15',5050.00,'Kredit','Telefon',18,2),
(78,'2026-08-17',800.00,'Kredit','Telefon',6,2),
(84,'2026-08-25',50000.00,'Gotovina','Uzivo',2,2),
(86,'2026-08-25',42000.00,'Gotovina','Online',2,2),
(87,'2026-08-25',74000.00,'Kartica','Online',6,2),
(88,'2026-08-25',35000.00,'Kartica','Online',13,2),
(90,'2026-08-25',56000.00,'Gotovina','Online',18,1),
(91,'2026-08-29',49000.00,'Gotovina','Telefon',28,2);

/*Table structure for table `soba` */

DROP TABLE IF EXISTS `soba`;

CREATE TABLE `soba` (
  `idSoba` bigint(20) NOT NULL AUTO_INCREMENT,
  `broj` varchar(50) NOT NULL,
  `brojKreveta` int(11) NOT NULL,
  `sprat` int(11) NOT NULL,
  `balkon` tinyint(1) NOT NULL,
  `cenaPoDanu` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idSoba`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `soba` */

insert  into `soba`(`idSoba`,`broj`,`brojKreveta`,`sprat`,`balkon`,`cenaPoDanu`) values 
(1,'10',2,1,1,5000.00),
(2,'20B',1,2,0,3500.00),
(3,'44C',3,4,1,8000.00);

/*Table structure for table `stavkarezervacije` */

DROP TABLE IF EXISTS `stavkarezervacije`;

CREATE TABLE `stavkarezervacije` (
  `idRezervacija` bigint(20) NOT NULL,
  `rb` int(20) NOT NULL,
  `brojDana` int(11) NOT NULL,
  `iznos` decimal(10,2) NOT NULL,
  `brojGostiju` int(11) NOT NULL,
  `datumPocetka` date NOT NULL,
  `datumIsteka` date NOT NULL,
  `idSoba` bigint(20) NOT NULL,
  `iznosPoGostu` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idRezervacija`,`rb`),
  CONSTRAINT `stavkarezervacije_ibfk_1` FOREIGN KEY (`idRezervacija`) REFERENCES `rezervacija` (`idRezervacija`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkarezervacije` */

insert  into `stavkarezervacije`(`idRezervacija`,`rb`,`brojDana`,`iznos`,`brojGostiju`,`datumPocetka`,`datumIsteka`,`idSoba`,`iznosPoGostu`) values 
(67,2,6,420.00,4,'2026-11-17','2026-11-23',2,105.00),
(67,3,30,1500.00,2,'2028-01-22','2028-02-21',1,750.00),
(67,4,10,700.00,4,'2026-11-17','2026-11-27',2,175.00),
(68,1,3,210.00,4,'2026-12-15','2026-12-18',2,52.50),
(68,2,8,1200.00,4,'2027-03-17','2027-03-25',3,300.00),
(70,1,12,840.00,3,'2026-12-12','2026-12-24',2,280.00),
(70,2,7,1050.00,4,'2027-01-01','2027-01-08',3,262.50),
(70,3,3,150.00,1,'2027-05-05','2027-05-08',1,150.00),
(71,3,20,1000.00,3,'2026-09-25','2026-10-15',1,333.33),
(71,4,3,210.00,2,'2027-12-17','2027-12-20',2,105.00),
(72,1,12,1800.00,1,'2026-12-17','2026-12-29',3,1800.00),
(72,3,10,500.00,2,'2028-01-01','2028-01-11',1,250.00),
(72,5,17,2550.00,4,'2031-05-22','2031-06-08',3,637.50),
(72,6,4,200.00,3,'2027-07-23','2027-07-27',1,66.67),
(78,1,5,350.00,4,'2026-11-12','2026-11-17',2,87.50),
(78,2,3,450.00,4,'2026-12-12','2026-12-15',3,112.50),
(84,1,10,50000.00,2,'2026-08-27','2026-09-06',1,25000.00),
(86,1,12,42000.00,3,'2026-10-28','2026-11-09',2,14000.00),
(87,1,4,32000.00,4,'2026-12-29','2027-01-02',3,8000.00),
(87,2,12,42000.00,2,'2027-01-10','2027-01-22',2,21000.00),
(88,1,10,35000.00,1,'2027-01-03','2027-01-13',2,35000.00),
(90,1,7,56000.00,4,'2026-11-11','2026-11-18',3,14000.00),
(91,1,14,49000.00,3,'2026-09-11','2026-09-25',2,16333.33);

/*Table structure for table `strucnasprema` */

DROP TABLE IF EXISTS `strucnasprema`;

CREATE TABLE `strucnasprema` (
  `idStrucnaSprema` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `stepen` varchar(50) NOT NULL,
  `institucija` varchar(50) NOT NULL,
  PRIMARY KEY (`idStrucnaSprema`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `strucnasprema` */

insert  into `strucnasprema`(`idStrucnaSprema`,`naziv`,`stepen`,`institucija`) values 
(4,'Inzenjer informacionih tehnologija','VII','Fakultet Organizacionih Nauka u Beogradu'),
(8,'Turisticki tehnicar','IV','Srednja turisticka skola'),
(9,'Diplomirani turisticki tehnicar','VII','Univerzitet Singidunum'),
(10,'Diplomirani turizmolog','VII','Geografski fakultet u Beogradu'),
(11,'Diplomirani ekonomista','VII','Ekonomski fakultet u Beogradu'),
(12,'Diplomirani menadzer','VII','Prirodno-matematicki fakultet u Novom Sadu');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
