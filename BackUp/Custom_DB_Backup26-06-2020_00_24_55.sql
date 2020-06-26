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
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'borj louzir','ariena','kalaa kebira','30',2036,1),(2,'hedi nouira','ariena','nahj  za3ter','b254',2037,2),(3,'test','test','test','203',1111,3);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,0,'informatique',1,NULL),(2,0,'security',2,1),(3,0,'Resources humaines',3,2),(4,2,'marketing',4,NULL);
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (7),(7);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,'\0','\0','2020-06-25 22:40:39','notification description 1','notification name 1',1),(2,'\0','\0','2020-06-25 22:40:39','notification description 2','notification name 2',1),(3,'\0','\0','2020-06-25 22:40:39','notification description 3','notification name 3',1),(4,'\0','\0','2020-06-25 22:40:39','notification description 4','notification name 4',1),(5,'\0','\0','2020-06-25 22:40:39','notification description 5','notification name 5',1),(6,'\0','\0','2020-06-25 22:40:39','notification description 6','notification name 6',1),(7,'\0','\0','2020-06-25 22:40:39','notification description 7','notification name 7',1),(8,'\0','\0','2020-06-25 22:40:39','notification description 8','notification name 8',1),(17,'\0','\0','2020-06-25 22:40:39','notification description 1','notification name 1',3),(18,'\0','\0','2020-06-25 22:40:39','notification description 2','notification name 2',3),(19,'\0','\0','2020-06-25 22:40:39','notification description 3','notification name 3',3),(20,'\0','\0','2020-06-25 22:40:39','notification description 4','notification name 4',3),(21,'\0','\0','2020-06-25 22:40:39','notification description 5','notification name 5',3),(22,'\0','\0','2020-06-25 22:40:39','notification description 6','notification name 6',3),(23,'\0','\0','2020-06-25 22:40:39','notification description 7','notification name 7',3),(24,'\0','\0','2020-06-25 22:40:39','notification description 8','notification name 8',3),(25,'\0','\0','2020-06-25 22:40:39','notification description 1','notification name 1',4),(26,'\0','\0','2020-06-25 22:40:39','notification description 2','notification name 2',4),(27,'\0','\0','2020-06-25 22:40:39','notification description 3','notification name 3',4),(28,'\0','\0','2020-06-25 22:40:39','notification description 4','notification name 4',4),(29,'\0','\0','2020-06-25 22:40:39','notification description 5','notification name 5',4),(30,'\0','\0','2020-06-25 22:40:39','notification description 6','notification name 6',4),(31,'\0','\0','2020-06-25 22:40:39','notification description 7','notification name 7',4),(32,'\0','\0','2020-06-25 22:40:39','notification description 8','notification name 8',4);
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `planning`
--

LOCK TABLES `planning` WRITE;
/*!40000 ALTER TABLE `planning` DISABLE KEYS */;
INSERT INTO `planning` VALUES (1,'btn btn-success','btn btn-outline-success','2020-06-25T23:00:00.000Z','Normal time monday to friday','NORMAL TIME',5,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0Mondayt\0Tuesdayt\0	Wednesdayt\0Thursdayt\0Friday','','2020-06-20T23:00:00.000Z',1),(2,'btn btn-info','btn btn-outline-info','2020-06-30T23:00:00.000Z','only on saturday','SATURDAY TIME',5,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0Saturday','\0','2020-06-20T23:00:00.000Z',1),(3,'btn btn-dark','btn btn-outline-dark','2020-07-10T23:00:00.000Z','only on saturday','SATURDAY TIME',2,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0Saturday','','2020-06-20T23:00:00.000Z',2),(4,'btn btn-danger','btn btn-outline-danger','2020-07-30T23:00:00.000Z','Normal time monday to friday','NORMAL TIME',2,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0Saturday','\0','2020-06-20T23:00:00.000Z',2);
/*!40000 ALTER TABLE `planning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'EMPLOYEE'),(2,'EMPLOYER'),(3,'CHEF_DEPARTMENT');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (5,'ADMIN'),(6,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,1020,840,720,'',480),(2,780,0,0,'\0',480);
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_configs`
--

LOCK TABLES `user_configs` WRITE;
/*!40000 ALTER TABLE `user_configs` DISABLE KEYS */;
INSERT INTO `user_configs` VALUES (1,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','',1),(2,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',2),(3,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','',3),(4,'¬í\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','\0',4);
/*!40000 ALTER TABLE `user_configs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1997-05-05','07496483','bassemjadoui1996@gmail.com','jadoui','male','2020-06-24','1.jpg','bassem','$2a$10$MPfRngtNYWC/gcipBXcReewYgNeSGfvRkOKqcg8tiyVZMDwG.aOcG','+21655135774',1,2),(2,'1997-02-04','07492487','khaili.amine@hotmail.fr','Khaili','male','2020-06-24','2.jpg',' Med Amine ','$2a$10$dn.Ykbbsw1mxkaQ2lrfOeOM8wn/pRWo7wlKyr2xxw.bRZGO7nxTtC','+21624222365',4,3),(3,'2020-03-09','12345678','test@kjk.com','test','female','2020-06-24','3.jpg','test','$2a$10$3d1h1J3sgOl9Enog5EmHKOpARKnzPrZ4U9XveF4HnzWx3YjOCon62','+21620000000',2,1),(4,'2020-03-09','152345678','erreru@jkhj.com','test','erreur','2020-06-24','4.jpg','erreur','$2a$10$5o9jtGlXkhqFSC8XDlokv.Lh/1j39ufqiMJM1iEq7hUEMSn3lcgvi','+21620500000',1,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-26  0:24:56
