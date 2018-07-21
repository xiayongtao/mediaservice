/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.56-MariaDB : Database - mediaservice
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mediaservice` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `mediaservice`;

/*Table structure for table `clients` */

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `push_number` int(11) DEFAULT NULL,
  `live_number` int(11) DEFAULT NULL,
  `status` enum('online','offline') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `registers` */

DROP TABLE IF EXISTS `registers`;

CREATE TABLE `registers` (
  `uuid` varchar(36) NOT NULL,
  `server_ip` varchar(16) DEFAULT NULL,
  `type` enum('pull','push','live','notranscode','transcode','rtsp') NOT NULL,
  `http_port` int(11) DEFAULT NULL,
  `rtmp_port` int(11) DEFAULT NULL,
  `rtsp_port` int(11) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `streams` */

DROP TABLE IF EXISTS `streams`;

CREATE TABLE `streams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `clients` int(11) DEFAULT NULL,
  `send_bytes` double DEFAULT NULL,
  `recv_bytes` double DEFAULT NULL,
  `publish_active` tinyint(1) DEFAULT NULL,
  `recv_30s` varchar(20) DEFAULT NULL,
  `send_30s` varchar(20) DEFAULT NULL,
  `vcodec` varchar(100) DEFAULT NULL,
  `acodec` varchar(100) DEFAULT NULL,
  `status` enum('online','offline') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
