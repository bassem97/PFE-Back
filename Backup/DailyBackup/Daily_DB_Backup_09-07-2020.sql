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
  `temp_user_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK78rs2krkm9a6uw7ui0j2b2y2` (`temp_user_id`),
  KEY `FK1fa36y2oqhao3wgg2rw1pi459` (`user_id`),
  CONSTRAINT `FK1fa36y2oqhao3wgg2rw1pi459` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK78rs2krkm9a6uw7ui0j2b2y2` FOREIGN KEY (`temp_user_id`) REFERENCES `temp_user` (`temp_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'qsd','qssd','sdf','qsd',54,NULL,1),(2,'dsdf','sdf','sd','sd',5,NULL,2);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
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
INSERT INTO `departments` VALUES (1,0,'informatique',1,NULL),(2,2,'security',1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,0,'','','2020-07-09 07:40:08','qqdsf qsdaaa wants to add a new employee ','Add request',1),(2,0,'','','2020-07-09 07:40:40','Request to add qsdqs qsd  has been accepted','Add request accepted',2),(3,0,'','','2020-07-09 07:41:47','qqdsf qsdaaa wants to add a new employee ','Add request',1),(4,0,'','','2020-07-09 07:41:58','Your request to add qsd qsd has been declined','Add request declined',2);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planning`
--

LOCK TABLES `planning` WRITE;
/*!40000 ALTER TABLE `planning` DISABLE KEYS */;
INSERT INTO `planning` VALUES (1,'btn btn-info','btn btn-outline-info','2038-07-08T23:00:00.000Z','Normal time from monday to friday','Normal time',1,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0MONDAYt\0TUESDAYt\0	WEDNESDAYt\0THURSDAYt\0FRIDAY','','2020-07-08T23:00:00.000Z',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planning_config`
--

LOCK TABLES `planning_config` WRITE;
/*!40000 ALTER TABLE `planning_config` DISABLE KEYS */;
INSERT INTO `planning_config` VALUES (1,30,30,60,1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,1020,840,720,'',480);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_configs`
--

LOCK TABLES `user_configs` WRITE;
/*!40000 ALTER TABLE `user_configs` DISABLE KEYS */;
INSERT INTO `user_configs` VALUES (1,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0','',1),(2,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0','\0',2);
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
INSERT INTO `user_roles` VALUES (1,1),(2,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2020-07-14T23:00:00.000Z','07492487','khaili.amine@hotmail.Fr','Med Amine','male','2020-07-07','1.jpeg','Khaili','$2a$10$cf.b8o4hCj5yCFEJh2yQAeR5R31XkTyqz/.iEsyn3.ZHLXE9nNm/u','+21655848546',1,NULL),(2,'2020-07-28T23:00:00.000Z','07492484','khaili.amine@hotmail.com','qsdaaa','male','2020-07-06','2.png','qqdsf','$2a$10$XyVQQeBSnpoIReghCctLn.zxJv9CnEy14aTVsycnssBTH8gAjW132','+21645485455',2,NULL);
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

-- Dump completed on 2020-07-09  8:47:48
