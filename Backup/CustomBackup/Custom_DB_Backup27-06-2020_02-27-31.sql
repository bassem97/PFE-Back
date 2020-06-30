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
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK1fa36y2oqhao3wgg2rw1pi459` (`user_id`),
  CONSTRAINT `FK1fa36y2oqhao3wgg2rw1pi459` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'borj louzir','ariena','kalaa kebira','30',2036,1),(2,'hedi nouira','ariena','nahj  za3ter','b254',2037,2),(3,'test','test','test','203',1111,3);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
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
INSERT INTO `departments` VALUES (1,0,'informatique',1,NULL),(2,0,'security',2,1),(3,0,'Resources humaines',3,2),(4,2,'marketing',4,NULL);
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
INSERT INTO `hibernate_sequence` VALUES (7),(7);
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
  `is_hovered` bit(1) DEFAULT NULL,
  `is_viewed` bit(1) DEFAULT NULL,
  `notif_date` datetime DEFAULT NULL,
  `notif_desc` varchar(255) DEFAULT NULL,
  `notif_title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`notif_id`),
  KEY `FK9y21adhxn0ayjhfocscqox7bh` (`user_id`),
  CONSTRAINT `FK9y21adhxn0ayjhfocscqox7bh` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',1),(2,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',1),(3,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',1),(4,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',1),(5,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',1),(6,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',1),(7,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',1),(8,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',1),(9,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',2),(10,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',2),(11,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',2),(12,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',2),(13,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',2),(14,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',2),(15,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',2),(16,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',2),(17,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',3),(18,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',3),(19,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',3),(20,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',3),(21,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',3),(22,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',3),(23,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',3),(24,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',3),(25,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',4),(26,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',4),(27,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',4),(28,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',4),(29,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',4),(30,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',4),(31,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',4),(32,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',4),(33,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',5),(34,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',5),(35,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',5),(36,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',5),(37,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',5),(38,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',5),(39,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',5),(40,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',5),(41,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',6),(42,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',6),(43,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',6),(44,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',6),(45,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',6),(46,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',6),(47,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',6),(48,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',6),(49,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',7),(50,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',7),(51,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',7),(52,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',7),(53,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',7),(54,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',7),(55,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',7),(56,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',7),(57,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',8),(58,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',8),(59,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',8),(60,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',8),(61,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',8),(62,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',8),(63,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',8),(64,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',8),(65,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',9),(66,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',9),(67,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',9),(68,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',9),(69,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',9),(70,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',9),(71,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',9),(72,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',9),(73,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',10),(74,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',10),(75,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',10),(76,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',10),(77,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',10),(78,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',10),(79,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',10),(80,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',10),(81,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',11),(82,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',11),(83,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',11),(84,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',11),(85,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',11),(86,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',11),(87,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',11),(88,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',11),(89,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',12),(90,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',12),(91,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',12),(92,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',12),(93,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',12),(94,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',12),(95,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',12),(96,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',12),(97,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',13),(98,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',13),(99,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',13),(100,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',13),(101,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',13),(102,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',13),(103,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',13),(104,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',13),(105,'\0','\0','2020-06-27 01:27:01','notification description 1','notification name 1',14),(106,'\0','\0','2020-06-27 01:27:01','notification description 2','notification name 2',14),(107,'\0','\0','2020-06-27 01:27:01','notification description 3','notification name 3',14),(108,'\0','\0','2020-06-27 01:27:01','notification description 4','notification name 4',14),(109,'\0','\0','2020-06-27 01:27:01','notification description 5','notification name 5',14),(110,'\0','\0','2020-06-27 01:27:01','notification description 6','notification name 6',14),(111,'\0','\0','2020-06-27 01:27:01','notification description 7','notification name 7',14),(112,'\0','\0','2020-06-27 01:27:01','notification description 8','notification name 8',14);
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
INSERT INTO `planning` VALUES (1,'btn btn-success','btn btn-outline-success','2020-06-25T23:00:00.000Z','Normal time monday to friday','NORMAL TIME',5,'��\0ur\0[Ljava.lang.String;��V��{G\0\0xp\0\0\0t\0Mondayt\0Tuesdayt\0	Wednesdayt\0Thursdayt\0Friday','','2020-06-20T23:00:00.000Z',1),(2,'btn btn-info','btn btn-outline-info','2020-06-30T23:00:00.000Z','only on saturday','SATURDAY TIME',5,'��\0ur\0[Ljava.lang.String;��V��{G\0\0xp\0\0\0t\0Saturday','\0','2020-06-20T23:00:00.000Z',1),(3,'btn btn-dark','btn btn-outline-dark','2020-07-10T23:00:00.000Z','only on saturday','SATURDAY TIME',2,'��\0ur\0[Ljava.lang.String;��V��{G\0\0xp\0\0\0t\0Saturday','','2020-06-20T23:00:00.000Z',2),(4,'btn btn-danger','btn btn-outline-danger','2020-07-30T23:00:00.000Z','Normal time monday to friday','NORMAL TIME',2,'��\0ur\0[Ljava.lang.String;��V��{G\0\0xp\0\0\0t\0Saturday','\0','2020-06-20T23:00:00.000Z',2);
/*!40000 ALTER TABLE `planning` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'EMPLOYEE'),(2,'EMPLOYER'),(3,'CHEF_DEPARTMENT');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (5,'ADMIN'),(6,'USER');
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
INSERT INTO `schedules` VALUES (1,1020,840,720,'',480),(2,780,0,0,'\0',480);
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_configs`
--

LOCK TABLES `user_configs` WRITE;
/*!40000 ALTER TABLE `user_configs` DISABLE KEYS */;
INSERT INTO `user_configs` VALUES (1,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','',1),(2,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',2),(3,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','',3),(4,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',4),(5,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',5),(6,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',6),(7,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',7),(8,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',8),(9,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',9),(10,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',10),(11,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',11),(12,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',12),(13,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',13),(14,'��\0ur\0[IM�`&v겥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',14);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1997-05-05','07496483','bassemjadoui1996@gmail.com','jadoui','male','2020-06-26','1.jpg','bassem','$2a$10$li4TwYmmMaL50OFk5cD1Y.wfnLRNn0KiZuXWN2VJXO/grUnnN7EBC','+21655135774',1,2),(2,'1997-02-04','07492487','khaili.amine@hotmail.fr','Khaili','male','2020-06-26','2.jpg',' Med Amine ','$2a$10$Kc9ILrl.G8tYpMpOn87fO.ftnxCA/ATYS1IUzO83wW3VQ8jZBQrBK','+21624222365',4,3),(3,'2020-03-09','12345678','test@kjk.com','test','female','2020-06-26','3.jpg','test','$2a$10$A/qF8eu5LpX24Z/ud1hDA.QyfAamFDAERTCcZeriZMsUJ7Zo.ZQce','+21620000000',2,1),(4,'2020-03-09','152345678','erreru@jkhj.com','test','erreur','2020-06-26','4.jpg','erreur','$2a$10$13dXEhbK91sOoJgYYpattO2JVHoImGTqHpba2vOTFzbphuX40pE.G','+21620500000',1,1),(5,'2020-03-09','5545485','qsd5@qsdqs.fqs','test','erreur','2020-06-26','5.jpg','erreur','$2a$10$1B6K/nth2RGET1Po4DaDAu3ZyzPzcrgTzrClaTKXXH.T3JuDba0im','555455',1,1),(6,'2020-03-09','6545485','qsd6@qsdqs.fqs','test','erreur','2020-06-26','6.jpg','erreur','$2a$10$F9DTyXln2rUDrBP4icxICeg4JbyEOSVAa3DP38S9UPYJVQDU4LMkO','555456',1,1),(7,'2020-03-09','7545485','qsd7@qsdqs.fqs','test','erreur','2020-06-26','7.jpg','erreur','$2a$10$r9qdbxV5lHFKUb1MRvCPxOLLDYznII5yWJ6RUT44Xro/2CAyCbi9q','555457',1,1),(8,'2020-03-09','8545485','qsd8@qsdqs.fqs','test','erreur','2020-06-26','8.jpg','erreur','$2a$10$9yCUYjmd7Aih2PzUBYcLgeCkgEJHDHoPlCrdNOlUMOAspY4g4Zn8S','555458',1,1),(9,'2020-03-09','9545485','qsd9@qsdqs.fqs','test','erreur','2020-06-26','9.jpg','erreur','$2a$10$kjttoOcMkEG4hqF/KZWRxuJjh5KqNv/gT1gDBHrUlhKc4RQKJi.cW','555459',1,1),(10,'2020-03-09','10545485','qsd10@qsdqs.fqs','test','erreur','2020-06-26','10.jpg','erreur','$2a$10$G4PkUqKIXfLmJHhKoHTDPO0skxaApLrFychp.RiKXkc2shEvBhA4K','5554510',1,1),(11,'2020-03-09','11545485','qsd11@qsdqs.fqs','test','erreur','2020-06-26','11.jpg','erreur','$2a$10$g4WQRKhyN1v8X2jywlw0f.oQWf9EfWINMnMXKbmGljiv7J2ryFxRi','5554511',1,1),(12,'2020-03-09','12545485','qsd12@qsdqs.fqs','test','erreur','2020-06-26','12.jpg','erreur','$2a$10$vpLM92KwxkhEUHB6W/O6IeajeCOn2Y0tMYztUCNde011kQc7BQep.','5554512',1,1),(13,'2020-03-09','13545485','qsd13@qsdqs.fqs','test','erreur','2020-06-26','13.jpg','erreur','$2a$10$ctVf70hlWEkXZxhE5xtOy..kTWzN78.Egq/elorRlCWINX9z4gupe','5554513',1,1),(14,'2020-03-09','14545485','qsd14@qsdqs.fqs','test','erreur','2020-06-26','14.jpg','erreur','$2a$10$uMbsrGG3NXO/jAiBKpRl4OU5iAfihtESwWVUn4mBwnBI03VZQ.zdy','5554514',1,1);
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

-- Dump completed on 2020-06-27  2:27:31
