-- MariaDB dump 10.17  Distrib 10.4.13-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: remotetimemanager
-- ------------------------------------------------------
-- Server version	10.4.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `absence`
--

DROP TABLE IF EXISTS `absence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `absence` (
  `absence_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `absence_date` date DEFAULT NULL,
  `absence_type` varchar(255) DEFAULT NULL,
  `absent_minutes` int(11) NOT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `reason_status` varchar(255) DEFAULT NULL,
  `revised_by` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`absence_id`),
  KEY `FKoprc4p9oqk4oyoa0j2p5o8oji` (`user_id`),
  CONSTRAINT `FKoprc4p9oqk4oyoa0j2p5o8oji` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absence`
--

LOCK TABLES `absence` WRITE;
/*!40000 ALTER TABLE `absence` DISABLE KEYS */;
INSERT INTO `absence` VALUES (191,'2020-07-07','All day',599,NULL,NULL,NULL,1),(192,'2020-07-07','All day',599,NULL,NULL,NULL,2),(193,'2020-07-07','All day',599,NULL,NULL,NULL,3),(194,'2020-07-07','All day',599,NULL,NULL,NULL,4),(195,'2020-07-07','All day',599,NULL,NULL,NULL,5);
/*!40000 ALTER TABLE `absence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresses` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `governorate` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  `street_number` varchar(255) DEFAULT NULL,
  `zip_code` bigint(20) NOT NULL,
  `temp_user_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK78rs2krkm9a6uw7ui0j2b2y2` (`temp_user_id`),
  KEY `FK1fa36y2oqhao3wgg2rw1pi459` (`user_id`),
  CONSTRAINT `FK1fa36y2oqhao3wgg2rw1pi459` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK78rs2krkm9a6uw7ui0j2b2y2` FOREIGN KEY (`temp_user_id`) REFERENCES `temp_user` (`temp_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'borj louzir','ariena','kalaa kebira','30',2036,NULL,1),(2,'hedi nouira','ariena','nahj  za3ter','b254',2037,NULL,2),(3,'test','test','test','203',1111,NULL,3),(4,'borj louzir','ariena','solidaritÃ©','214',1325,NULL,4),(5,'tunis','fouchena','hdid','145',1023,NULL,5);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `attendance_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attendance_date` date DEFAULT NULL,
  `attendance_time` int(11) NOT NULL,
  `attendance_type` varchar(255) DEFAULT NULL,
  `input_type` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `FKjcaqd29v2qy723owsdah2t8vx` (`user_id`),
  CONSTRAINT `FKjcaqd29v2qy723owsdah2t8vx` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (39,'2020-07-07',509,'CHECK IN','finger',2);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `dep_id` bigint(20) NOT NULL,
  `chef_dep` bigint(20) NOT NULL,
  `dep_name` varchar(255) DEFAULT NULL,
  `planning_id` bigint(20) DEFAULT NULL,
  `sup_dep` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`dep_id`),
  KEY `FK5cwvd5f4kb0grb2a52whkavx4` (`planning_id`),
  KEY `FK613h2fl1v950vjwf7n9ix2bnq` (`sup_dep`),
  CONSTRAINT `FK5cwvd5f4kb0grb2a52whkavx4` FOREIGN KEY (`planning_id`) REFERENCES `planning` (`planning_id`),
  CONSTRAINT `FK613h2fl1v950vjwf7n9ix2bnq` FOREIGN KEY (`sup_dep`) REFERENCES `departments` (`dep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,0,'informatique',1,NULL),(2,3,'security',1,1),(3,4,'Resources humaines',1,2),(4,0,'marketing',1,NULL);
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (5),(5);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pic_byte` longblob DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notifications` (
  `notif_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_target` bigint(20) NOT NULL,
  `is_hovered` bit(1) DEFAULT NULL,
  `is_viewed` bit(1) DEFAULT NULL,
  `notif_date` datetime DEFAULT NULL,
  `notif_desc` varchar(255) DEFAULT NULL,
  `notif_title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`notif_id`),
  KEY `FK9y21adhxn0ayjhfocscqox7bh` (`user_id`),
  CONSTRAINT `FK9y21adhxn0ayjhfocscqox7bh` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,0,'\0','\0','2020-07-07 09:14:11','notification description 1','notification name 1',1),(2,0,'\0','\0','2020-07-07 09:14:11','notification description 2','notification name 2',1),(3,0,'\0','\0','2020-07-07 09:14:11','notification description 3','notification name 3',1),(4,0,'\0','\0','2020-07-07 09:14:11','notification description 4','notification name 4',1),(5,0,'\0','\0','2020-07-07 09:14:11','notification description 5','notification name 5',1),(6,0,'\0','\0','2020-07-07 09:14:11','notification description 6','notification name 6',1),(7,0,'\0','\0','2020-07-07 09:14:11','notification description 7','notification name 7',1),(8,0,'\0','\0','2020-07-07 09:14:11','notification description 8','notification name 8',1),(17,0,'\0','\0','2020-07-07 09:14:11','notification description 1','notification name 1',3),(18,0,'\0','\0','2020-07-07 09:14:11','notification description 2','notification name 2',3),(19,0,'\0','\0','2020-07-07 09:14:11','notification description 3','notification name 3',3),(20,0,'\0','\0','2020-07-07 09:14:11','notification description 4','notification name 4',3),(21,0,'\0','\0','2020-07-07 09:14:11','notification description 5','notification name 5',3),(22,0,'\0','\0','2020-07-07 09:14:11','notification description 6','notification name 6',3),(23,0,'\0','\0','2020-07-07 09:14:11','notification description 7','notification name 7',3),(24,0,'\0','\0','2020-07-07 09:14:11','notification description 8','notification name 8',3),(25,0,'\0','\0','2020-07-07 09:14:11','notification description 1','notification name 1',4),(26,0,'\0','\0','2020-07-07 09:14:11','notification description 2','notification name 2',4),(27,0,'\0','\0','2020-07-07 09:14:11','notification description 3','notification name 3',4),(28,0,'\0','\0','2020-07-07 09:14:11','notification description 4','notification name 4',4),(29,0,'\0','\0','2020-07-07 09:14:11','notification description 5','notification name 5',4),(30,0,'\0','\0','2020-07-07 09:14:11','notification description 6','notification name 6',4),(31,0,'\0','\0','2020-07-07 09:14:11','notification description 7','notification name 7',4),(32,0,'\0','\0','2020-07-07 09:14:11','notification description 8','notification name 8',4),(33,0,'\0','\0','2020-07-07 09:14:11','notification description 1','notification name 1',5),(34,0,'\0','\0','2020-07-07 09:14:11','notification description 2','notification name 2',5),(35,0,'\0','\0','2020-07-07 09:14:11','notification description 3','notification name 3',5),(36,0,'\0','\0','2020-07-07 09:14:11','notification description 4','notification name 4',5),(37,0,'\0','\0','2020-07-07 09:14:11','notification description 5','notification name 5',5),(38,0,'\0','\0','2020-07-07 09:14:11','notification description 6','notification name 6',5),(39,0,'\0','\0','2020-07-07 09:14:11','notification description 7','notification name 7',5),(40,0,'\0','\0','2020-07-07 09:14:11','notification description 8','notification name 8',5),(41,0,'\0','\0','2020-07-07 09:25:50','You have been marked absent (null)','Absent',1),(43,0,'\0','\0','2020-07-07 09:25:50','You have been marked absent (null)','Absent',3),(44,0,'\0','\0','2020-07-07 09:25:50','You have been marked absent (null)','Absent',4),(45,0,'\0','\0','2020-07-07 09:25:50','You have been marked absent (null)','Absent',5),(46,0,'\0','\0','2020-07-07 09:26:00','You have been marked absent (null)','Absent',1),(48,0,'\0','\0','2020-07-07 09:26:00','You have been marked absent (null)','Absent',3),(49,0,'\0','\0','2020-07-07 09:26:00','You have been marked absent (null)','Absent',4),(50,0,'\0','\0','2020-07-07 09:26:00','You have been marked absent (null)','Absent',5),(51,0,'\0','\0','2020-07-07 09:26:10','You have been marked absent (null)','Absent',1),(53,0,'\0','\0','2020-07-07 09:26:10','You have been marked absent (null)','Absent',3),(54,0,'\0','\0','2020-07-07 09:26:10','You have been marked absent (null)','Absent',4),(55,0,'\0','\0','2020-07-07 09:26:10','You have been marked absent (null)','Absent',5),(56,0,'\0','\0','2020-07-07 09:26:20','You have been marked absent (null)','Absent',1),(58,0,'\0','\0','2020-07-07 09:26:20','You have been marked absent (null)','Absent',3),(59,0,'\0','\0','2020-07-07 09:26:20','You have been marked absent (null)','Absent',4),(60,0,'\0','\0','2020-07-07 09:26:20','You have been marked absent (null)','Absent',5),(61,0,'\0','\0','2020-07-07 09:26:40','You have been marked absent (2020-07-07)','Absent',1),(63,0,'\0','\0','2020-07-07 09:26:40','You have been marked absent (2020-07-07)','Absent',3),(64,0,'\0','\0','2020-07-07 09:26:40','You have been marked absent (2020-07-07)','Absent',4),(65,0,'\0','\0','2020-07-07 09:26:41','You have been marked absent (2020-07-07)','Absent',5),(66,0,'\0','\0','2020-07-07 09:27:40','You have been marked absent (2020-07-07)','Absent',1),(68,0,'\0','\0','2020-07-07 09:27:40','You have been marked absent (2020-07-07)','Absent',3),(69,0,'\0','\0','2020-07-07 09:27:40','You have been marked absent (2020-07-07)','Absent',4),(70,0,'\0','\0','2020-07-07 09:27:40','You have been marked absent (2020-07-07)','Absent',5),(71,0,'\0','\0','2020-07-07 09:28:10','You have been marked absent (2020-07-07)','Absent',1),(73,0,'\0','\0','2020-07-07 09:28:10','You have been marked absent (2020-07-07)','Absent',3),(74,0,'\0','\0','2020-07-07 09:28:10','You have been marked absent (2020-07-07)','Absent',4),(75,0,'\0','\0','2020-07-07 09:28:10','You have been marked absent (2020-07-07)','Absent',5),(76,0,'\0','\0','2020-07-07 09:31:00','You have been marked absent (2020-07-07)','Absent',1),(78,0,'\0','\0','2020-07-07 09:31:00','You have been marked absent (2020-07-07)','Absent',3),(79,0,'\0','\0','2020-07-07 09:31:00','You have been marked absent (2020-07-07)','Absent',4),(80,0,'\0','\0','2020-07-07 09:31:00','You have been marked absent (2020-07-07)','Absent',5),(81,0,'\0','\0','2020-07-07 09:31:56','You have been marked absent (2020-07-07)','Absent',1),(83,0,'\0','\0','2020-07-07 09:31:56','You have been marked absent (2020-07-07)','Absent',3),(84,0,'\0','\0','2020-07-07 09:31:56','You have been marked absent (2020-07-07)','Absent',4),(85,0,'\0','\0','2020-07-07 09:31:56','You have been marked absent (2020-07-07)','Absent',5),(86,0,'\0','\0','2020-07-07 09:32:45','You have been marked absent (2020-07-07)','Absent',1),(88,0,'\0','\0','2020-07-07 09:32:46','You have been marked absent (2020-07-07)','Absent',3),(89,0,'\0','\0','2020-07-07 09:32:46','You have been marked absent (2020-07-07)','Absent',4),(90,0,'\0','\0','2020-07-07 09:32:46','You have been marked absent (2020-07-07)','Absent',5),(91,0,'\0','\0','2020-07-07 09:33:32','You have been marked absent (2020-07-07)','Absent',1),(93,0,'\0','\0','2020-07-07 09:33:33','You have been marked absent (2020-07-07)','Absent',3),(94,0,'\0','\0','2020-07-07 09:33:33','You have been marked absent (2020-07-07)','Absent',4),(95,0,'\0','\0','2020-07-07 09:33:33','You have been marked absent (2020-07-07)','Absent',5),(96,0,'\0','\0','2020-07-07 09:36:19','You have been marked absent (2020-07-07)','Absent',1),(98,0,'\0','\0','2020-07-07 09:36:19','You have been marked absent (2020-07-07)','Absent',3),(99,0,'\0','\0','2020-07-07 09:36:19','You have been marked absent (2020-07-07)','Absent',4),(100,0,'\0','\0','2020-07-07 09:36:19','You have been marked absent (2020-07-07)','Absent',5),(101,0,'\0','\0','2020-07-07 09:37:01','You have been marked absent (2020-07-07)','Absent',1),(103,0,'\0','\0','2020-07-07 09:37:01','You have been marked absent (2020-07-07)','Absent',3),(104,0,'\0','\0','2020-07-07 09:37:01','You have been marked absent (2020-07-07)','Absent',4),(105,0,'\0','\0','2020-07-07 09:37:01','You have been marked absent (2020-07-07)','Absent',5),(106,0,'\0','\0','2020-07-07 09:40:50','You have been marked absent (2020-07-07)','Absent',1),(108,0,'\0','\0','2020-07-07 09:40:51','You have been marked absent (2020-07-07)','Absent',3),(109,0,'\0','\0','2020-07-07 09:40:51','You have been marked absent (2020-07-07)','Absent',4),(110,0,'\0','\0','2020-07-07 09:40:51','You have been marked absent (2020-07-07)','Absent',5),(111,0,'\0','\0','2020-07-07 09:41:52','You have been marked absent (2020-07-07)','Absent',1),(113,0,'\0','\0','2020-07-07 09:41:52','You have been marked absent (2020-07-07)','Absent',3),(114,0,'\0','\0','2020-07-07 09:41:53','You have been marked absent (2020-07-07)','Absent',4),(115,0,'\0','\0','2020-07-07 09:41:53','You have been marked absent (2020-07-07)','Absent',5),(116,0,'\0','\0','2020-07-07 09:42:55','You have been marked absent (2020-07-07)','Absent',1),(118,0,'\0','\0','2020-07-07 09:42:56','You have been marked absent (2020-07-07)','Absent',3),(119,0,'\0','\0','2020-07-07 09:42:56','You have been marked absent (2020-07-07)','Absent',4),(120,0,'\0','\0','2020-07-07 09:42:56','You have been marked absent (2020-07-07)','Absent',5),(121,0,'\0','\0','2020-07-07 09:43:30',' Med Amine  Khaili has provided a reason for 2020-07-08 absence','Absence reason',1),(123,0,'\0','\0','2020-07-07 21:00:00','You have been marked absent (2020-07-07)','Absent',1),(125,0,'\0','\0','2020-07-07 21:00:00','You have been marked absent (2020-07-07)','Absent',3),(126,0,'\0','\0','2020-07-07 21:00:00','You have been marked absent (2020-07-07)','Absent',4),(127,0,'\0','\0','2020-07-07 21:00:01','You have been marked absent (2020-07-07)','Absent',5),(128,0,'\0','\0','2020-07-07 21:12:58','You have been marked absent (2020-07-07)','Absent',4),(129,0,'\0','\0','2020-07-07 21:12:58','You have been marked absent (2020-07-07)','Absent',5),(130,0,'\0','\0','2020-07-07 21:19:33','Late check-in at 2020-07-07 marked.','Late check-in',1),(131,0,'\0','\0','2020-07-07 21:20:58','You have been marked absent (2020-07-07)','Absent',3),(132,0,'\0','\0','2020-07-07 21:24:10','Early check-out at 2020-07-07 marked.','Early check-out',1),(133,0,'\0','\0','2020-07-07 21:25:36','You have been marked absent (2020-07-07)','Absent',4),(134,0,'\0','\0','2020-07-07 21:25:36','You have been marked absent (2020-07-07)','Absent',5),(135,0,'\0','\0','2020-07-07 21:25:58','You have been marked absent (2020-07-07)','Absent',1),(137,0,'\0','\0','2020-07-07 21:25:58','You have been marked absent (2020-07-07)','Absent',3),(138,0,'\0','\0','2020-07-07 21:25:58','You have been marked absent (2020-07-07)','Absent',4),(139,0,'\0','\0','2020-07-07 21:25:58','You have been marked absent (2020-07-07)','Absent',5),(140,0,'\0','\0','2020-07-07 21:30:20','You have been marked absent (2020-07-07)','Absent',1),(142,0,'\0','\0','2020-07-07 21:30:20','You have been marked absent (2020-07-07)','Absent',3),(143,0,'\0','\0','2020-07-07 21:30:20','You have been marked absent (2020-07-07)','Absent',4),(144,0,'\0','\0','2020-07-07 21:30:21','You have been marked absent (2020-07-07)','Absent',5),(146,0,'\0','\0','2020-07-07 21:34:10','You have been marked absent (2020-07-07)','Absent',3),(147,0,'\0','\0','2020-07-07 21:34:10','You have been marked absent (2020-07-07)','Absent',4),(148,0,'\0','\0','2020-07-07 21:34:11','You have been marked absent (2020-07-07)','Absent',5),(149,0,'\0','\0','2020-07-07 21:34:54','Early check-out at 2020-07-07 marked.','Early check-out',1),(150,0,'\0','\0','2020-07-07 21:52:56','You have been marked absent (2020-07-07)','Absent',1),(152,0,'\0','\0','2020-07-07 21:53:25','You have been marked absent (2020-07-07)','Absent',3),(153,0,'\0','\0','2020-07-07 21:53:25','You have been marked absent (2020-07-07)','Absent',4),(154,0,'\0','\0','2020-07-07 21:53:25','You have been marked absent (2020-07-07)','Absent',5),(156,0,'\0','\0','2020-07-07 21:56:59','You have been marked absent (2020-07-07)','Absent',3),(157,0,'\0','\0','2020-07-07 21:56:59','You have been marked absent (2020-07-07)','Absent',4),(158,0,'\0','\0','2020-07-07 21:56:59','You have been marked absent (2020-07-07)','Absent',5),(159,0,'\0','\0','2020-07-07 21:57:52','You have been marked absent (2020-07-07)','Absent',1),(160,0,'\0','\0','2020-07-07 21:57:52','You have been marked absent (2020-07-07)','Absent',1),(162,0,'\0','\0','2020-07-07 21:57:52','You have been marked absent (2020-07-07)','Absent',3),(163,0,'\0','\0','2020-07-07 21:57:52','You have been marked absent (2020-07-07)','Absent',3),(164,0,'\0','\0','2020-07-07 21:57:52','You have been marked absent (2020-07-07)','Absent',4),(165,0,'\0','\0','2020-07-07 21:57:52','You have been marked absent (2020-07-07)','Absent',4),(166,0,'\0','\0','2020-07-07 21:57:52','You have been marked absent (2020-07-07)','Absent',5),(167,0,'\0','\0','2020-07-07 21:57:52','You have been marked absent (2020-07-07)','Absent',5),(168,0,'\0','\0','2020-07-07 21:58:41','You have been marked absent (2020-07-07)','Absent',1),(170,0,'\0','\0','2020-07-07 21:58:41','You have been marked absent (2020-07-07)','Absent',3),(171,0,'\0','\0','2020-07-07 21:58:41','You have been marked absent (2020-07-07)','Absent',4),(172,0,'\0','\0','2020-07-07 21:58:42','You have been marked absent (2020-07-07)','Absent',5),(173,0,'\0','\0','2020-07-07 21:59:21','You have been marked absent (2020-07-07)','Absent',1),(174,0,'\0','\0','2020-07-07 21:59:21','You have been marked absent (2020-07-07)','Absent',2),(175,0,'\0','\0','2020-07-07 21:59:21','You have been marked absent (2020-07-07)','Absent',3),(176,0,'\0','\0','2020-07-07 21:59:21','You have been marked absent (2020-07-07)','Absent',4),(177,0,'\0','\0','2020-07-07 21:59:21','You have been marked absent (2020-07-07)','Absent',5);
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planning`
--

DROP TABLE IF EXISTS `planning`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planning` (
  `planning_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `color_icon` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `planning_description` varchar(255) DEFAULT NULL,
  `planning_name` varchar(255) DEFAULT NULL,
  `repeat_cycle` int(11) NOT NULL,
  `schedule_days` tinyblob DEFAULT NULL,
  `show_pl` bit(1) NOT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `schedule_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`planning_id`),
  KEY `FKi53mhetd126t8dehcxdl4oegi` (`schedule_id`),
  CONSTRAINT `FKi53mhetd126t8dehcxdl4oegi` FOREIGN KEY (`schedule_id`) REFERENCES `schedules` (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planning`
--

LOCK TABLES `planning` WRITE;
/*!40000 ALTER TABLE `planning` DISABLE KEYS */;
INSERT INTO `planning` VALUES (1,'btn btn-success','btn btn-outline-success','2020-06-25T23:00:00.000Z','Normal time monday to friday','NORMAL TIME',5,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0MONDAYt\0TUESDAYt\0	WEDNESDAYt\0THURSDAYt\0FRIDAY','','2020-07-29T23:00:00.000Z',1),(2,'btn btn-info','btn btn-outline-info','2020-06-30T23:00:00.000Z','only on saturday','SATURDAY TIME',5,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0SATURDAY','\0','2020-06-20T23:00:00.000Z',1),(3,'btn btn-dark','btn btn-outline-dark','2020-07-10T23:00:00.000Z','only on saturday','SATURDAY TIME',2,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0SATURDAY','','2020-06-20T23:00:00.000Z',2),(4,'btn btn-danger','btn btn-outline-danger','2020-07-30T23:00:00.000Z','Normal time monday to friday','NORMAL TIME',2,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0SATURDAY','\0','2020-06-20T23:00:00.000Z',2);
/*!40000 ALTER TABLE `planning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planning_config`
--

DROP TABLE IF EXISTS `planning_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planning_config` (
  `planning_configurations_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `check_in_delay` int(11) NOT NULL,
  `check_out_delay` int(11) NOT NULL,
  `end_checkin` int(11) NOT NULL,
  `planning_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`planning_configurations_id`),
  KEY `FKf8h9qypri3ywm4qwqhyqi1lxq` (`planning_id`),
  CONSTRAINT `FKf8h9qypri3ywm4qwqhyqi1lxq` FOREIGN KEY (`planning_id`) REFERENCES `planning` (`planning_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planning_config`
--

LOCK TABLES `planning_config` WRITE;
/*!40000 ALTER TABLE `planning_config` DISABLE KEYS */;
INSERT INTO `planning_config` VALUES (1,5,5,10,1),(2,10,10,540,2),(3,30,30,540,3),(4,5,5,540,4);
/*!40000 ALTER TABLE `planning_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'Tester'),(2,'Web developer'),(3,'Designer'),(4,'CHEF_DEPARTMENT');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `UK_iubw515ff0ugtm28p8g3myt0h` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'ADMIN'),(3,'CHEF_DEPARTMENT'),(1,'SUPER_ADMIN'),(4,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedules`
--

DROP TABLE IF EXISTS `schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedules` (
  `schedule_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `end_hour` int(11) NOT NULL,
  `pause_end` int(11) NOT NULL,
  `pause_start` int(11) NOT NULL,
  `pause_time` bit(1) DEFAULT NULL,
  `start_hour` int(11) NOT NULL,
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,1079,0,0,'\0',480),(2,780,0,0,'\0',480);
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp_user`
--

DROP TABLE IF EXISTS `temp_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temp_user` (
  `temp_user_id` bigint(20) NOT NULL,
  `birth_date` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `hire_day` date DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `dep_id` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`temp_user_id`),
  UNIQUE KEY `UK_2aerjhw69pxdyn591m2mxbkm4` (`cin`),
  UNIQUE KEY `UK_7e9qkhmp8428ridi9uewpdmgo` (`email`),
  UNIQUE KEY `UK_dys38owmoswxrgb6gpxw9wumx` (`phone`),
  KEY `FK2vi0ogyp6xvg82kv6f7qoyq97` (`dep_id`),
  KEY `FKnxl4bsvhhw2jk260eha0tphq7` (`post_id`),
  CONSTRAINT `FK2vi0ogyp6xvg82kv6f7qoyq97` FOREIGN KEY (`dep_id`) REFERENCES `departments` (`dep_id`),
  CONSTRAINT `FKnxl4bsvhhw2jk260eha0tphq7` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp_user`
--

LOCK TABLES `temp_user` WRITE;
/*!40000 ALTER TABLE `temp_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `temp_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_configs`
--

DROP TABLE IF EXISTS `user_configs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_configs` (
  `config_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shown_plannings` tinyblob DEFAULT NULL,
  `theme` bit(1) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`config_id`),
  KEY `FKm2rdtlvm19hrj7eyy6c5fpwvr` (`user_id`),
  CONSTRAINT `FKm2rdtlvm19hrj7eyy6c5fpwvr` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_configs`
--

LOCK TABLES `user_configs` WRITE;
/*!40000 ALTER TABLE `user_configs` DISABLE KEYS */;
INSERT INTO `user_configs` VALUES (1,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','',1),(2,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',2),(3,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','',3),(4,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',4),(5,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',5);
/*!40000 ALTER TABLE `user_configs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,2),(3,3),(4,3),(5,4);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `hire_day` date DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `dep_id` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ka6m8ghsr7vna1ti6lftwww8o` (`cin`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_du5v5sr43g5bfnji4vb8hg5s3` (`phone`),
  KEY `FKl8wxqqug5wyyd49lsuw4gjplp` (`dep_id`),
  KEY `FK5na1mqr6obdc53ool8egadvar` (`post_id`),
  CONSTRAINT `FK5na1mqr6obdc53ool8egadvar` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE,
  CONSTRAINT `FKl8wxqqug5wyyd49lsuw4gjplp` FOREIGN KEY (`dep_id`) REFERENCES `departments` (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1997-05-05','07496483','bassemjadoui1996@gmail.com','jadoui','male','2020-07-06','1.jpg','bassem','$2a$10$k3DsLQGjl/S9ASqTPzoaQ.R7R3/osfdaq1VgcpdkQStStNPxyNszy','+21655135774',1,4),(2,'1997-02-04','07492487','khaili.amine@hotmail.fr','Khaili','male','2020-07-06','2.jpg',' Med Amine ','$2a$10$jgVkymvT4UsvbGC6JO1dLOqhVSF2xHM7aSmw1yIlOiA7D5ATqUSr.','+21624222365',4,2),(3,'2020-03-09','12345678','manai@gmail.com','karim','female','2020-07-06','3.jpg','manai','$2a$10$vRXQ8Z3Zlp2HwejUKwF76unDQFbluNBmZfb/LeauFl/TdxwJ6LWkK','+21620000000',2,1),(4,'2020-03-09','152345678','tatay@gmail.com','montassar','male','2020-07-06','4.jpg','zaroui','$2a$10$pK1PmGhEgeHTG/RRRUc8ges5jgtwBgwgXGUpy1qr7Tk.wDBFOl2km','+21620500000',3,1),(5,'2020-03-09','01234567','degla@gmail.com','malek','male','2020-07-06','5.jpg','degla','$2a$10$vqKwqFjURO9hNtDva31Od.m4UKMaSs1loYwqmFIqMZ5W1VM.GjzvS','+21620500021',3,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-07 23:00:02
