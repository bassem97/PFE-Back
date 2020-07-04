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
  `reason_status` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`absence_id`),
  KEY `FKoprc4p9oqk4oyoa0j2p5o8oji` (`user_id`),
  CONSTRAINT `FKoprc4p9oqk4oyoa0j2p5o8oji` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absence`
--

LOCK TABLES `absence` WRITE;
/*!40000 ALTER TABLE `absence` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,'2020-07-02',495,'CHECK IN','finger',1),(2,'2020-07-02',1020,'CHECK OUT','finger',1),(3,'2020-07-02',495,'CHECK IN','finger',2),(4,'2020-07-02',1020,'CHECK OUT','finger',2),(5,'2020-07-02',495,'CHECK IN','finger',3),(6,'2020-07-02',1020,'CHECK OUT','finger',3),(7,'2020-07-02',495,'CHECK IN','finger',4),(8,'2020-07-02',1020,'CHECK OUT','finger',4);
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
INSERT INTO `departments` VALUES (1,0,'informatique',1,NULL),(2,0,'security',2,1),(3,0,'Resources humaines',3,2),(4,0,'marketing',4,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,'\0','\0','2020-07-02 21:58:48','notification description 1','notification name 1',1),(2,'\0','\0','2020-07-02 21:58:48','notification description 2','notification name 2',1),(3,'\0','\0','2020-07-02 21:58:48','notification description 3','notification name 3',1),(4,'\0','\0','2020-07-02 21:58:48','notification description 4','notification name 4',1),(5,'\0','\0','2020-07-02 21:58:48','notification description 5','notification name 5',1),(6,'\0','\0','2020-07-02 21:58:48','notification description 6','notification name 6',1),(7,'\0','\0','2020-07-02 21:58:48','notification description 7','notification name 7',1),(8,'\0','\0','2020-07-02 21:58:48','notification description 8','notification name 8',1),(9,'\0','\0','2020-07-02 21:58:48','notification description 1','notification name 1',2),(10,'\0','\0','2020-07-02 21:58:48','notification description 2','notification name 2',2),(11,'\0','\0','2020-07-02 21:58:48','notification description 3','notification name 3',2),(12,'\0','\0','2020-07-02 21:58:48','notification description 4','notification name 4',2),(13,'\0','\0','2020-07-02 21:58:48','notification description 5','notification name 5',2),(14,'\0','\0','2020-07-02 21:58:48','notification description 6','notification name 6',2),(15,'\0','\0','2020-07-02 21:58:48','notification description 7','notification name 7',2),(16,'\0','\0','2020-07-02 21:58:48','notification description 8','notification name 8',2),(17,'\0','\0','2020-07-02 21:58:48','notification description 1','notification name 1',3),(18,'\0','\0','2020-07-02 21:58:48','notification description 2','notification name 2',3),(19,'\0','\0','2020-07-02 21:58:48','notification description 3','notification name 3',3),(20,'\0','\0','2020-07-02 21:58:48','notification description 4','notification name 4',3),(21,'\0','\0','2020-07-02 21:58:48','notification description 5','notification name 5',3),(22,'\0','\0','2020-07-02 21:58:48','notification description 6','notification name 6',3),(23,'\0','\0','2020-07-02 21:58:48','notification description 7','notification name 7',3),(24,'\0','\0','2020-07-02 21:58:48','notification description 8','notification name 8',3),(25,'\0','\0','2020-07-02 21:58:48','notification description 1','notification name 1',4),(26,'\0','\0','2020-07-02 21:58:48','notification description 2','notification name 2',4),(27,'\0','\0','2020-07-02 21:58:48','notification description 3','notification name 3',4),(28,'\0','\0','2020-07-02 21:58:48','notification description 4','notification name 4',4),(29,'\0','\0','2020-07-02 21:58:48','notification description 5','notification name 5',4),(30,'\0','\0','2020-07-02 21:58:48','notification description 6','notification name 6',4),(31,'\0','\0','2020-07-02 21:58:48','notification description 7','notification name 7',4),(32,'\0','\0','2020-07-02 21:58:48','notification description 8','notification name 8',4);
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
INSERT INTO `planning` VALUES (1,'btn btn-success','btn btn-outline-success','2020-06-25T23:00:00.000Z','Normal time monday to friday','NORMAL TIME',5,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0MONDAYt\0TUESDAYt\0	WEDNESDAYt\0THURSDAYt\0FRIDAY','','2020-06-20T23:00:00.000Z',1),(2,'btn btn-info','btn btn-outline-info','2020-06-30T23:00:00.000Z','only on saturday','SATURDAY TIME',5,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0SATURDAY','\0','2020-06-20T23:00:00.000Z',1),(3,'btn btn-dark','btn btn-outline-dark','2020-07-10T23:00:00.000Z','only on saturday','SATURDAY TIME',2,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0SATURDAY','','2020-06-20T23:00:00.000Z',2),(4,'btn btn-danger','btn btn-outline-danger','2020-07-30T23:00:00.000Z','Normal time monday to friday','NORMAL TIME',2,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0SATURDAY','\0','2020-06-20T23:00:00.000Z',2);
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
INSERT INTO `planning_config` VALUES (1,5,15,1),(2,10,10,2),(3,30,30,3),(4,5,5,4);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_configs`
--

LOCK TABLES `user_configs` WRITE;
/*!40000 ALTER TABLE `user_configs` DISABLE KEYS */;
INSERT INTO `user_configs` VALUES (1,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','',1),(2,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',2),(3,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','',3),(4,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',4);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1997-05-05','07496483','bassemjadoui1996@gmail.com','jadoui','male','2020-07-01','1.jpg','bassem','$2a$10$uVgyczuV6Q8AZaoXK.ZcGu4Q1Ox2W64U8VFnvvlvbpQ6VvlGEIgl.','+21655135774',1,2),(2,'1997-02-04','07492487','khaili.amine@hotmail.fr','Khaili','male','2020-07-01','2.jpg',' Med Amine ','$2a$10$DzUymbcN63trvvQw0lhH9.JxtUVtpcvc3CUDiW.H5XfWmII/z/scS','+21624222365',4,3),(3,'2020-03-09','12345678','test@kjk.com','test','female','2020-07-01','3.jpg','test','$2a$10$eAY0HxoF1sZMsKnowTBH3.NIoGtnM/gai5djRURtCwceadhpDt8Ma','+21620000000',2,1),(4,'2020-03-09','152345678','erreru@jkhj.com','test','erreur','2020-07-01','4.jpg','erreur','$2a$10$VbQeVXNmH19GHFahngcpPexPJVJbNGhxeXkVc/PmIkeOEo1k5jdIC','+21620500000',1,1);
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

-- Dump completed on 2020-07-02 23:00:00
