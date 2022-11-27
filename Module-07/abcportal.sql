-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: abc_jobs
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

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
-- Table structure for table `tb_admin`
--

DROP TABLE IF EXISTS `tb_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) NOT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_admin`
--

LOCK TABLES `tb_admin` WRITE;
/*!40000 ALTER TABLE `tb_admin` DISABLE KEYS */;
INSERT INTO `tb_admin` VALUES (1,'lithanabcportal@gmail.com','admin123','Gustut','Yoghantara');
/*!40000 ALTER TABLE `tb_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_apply_job`
--

DROP TABLE IF EXISTS `tb_apply_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_apply_job` (
  `id_apply_job` int(11) NOT NULL AUTO_INCREMENT,
  `id_profile` int(11) NOT NULL,
  `id_job` int(11) NOT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_apply_job`),
  KEY `id_profile` (`id_profile`),
  KEY `id_job` (`id_job`),
  CONSTRAINT `tb_apply_job_ibfk_1` FOREIGN KEY (`id_profile`) REFERENCES `tb_user_profile` (`id_profile`),
  CONSTRAINT `tb_apply_job_ibfk_2` FOREIGN KEY (`id_job`) REFERENCES `tb_jobs` (`id_job`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_apply_job`
--

LOCK TABLES `tb_apply_job` WRITE;
/*!40000 ALTER TABLE `tb_apply_job` DISABLE KEYS */;
INSERT INTO `tb_apply_job` VALUES (1,5,2,'ACCEPTED'),(2,3,1,'PENDING'),(3,3,9,'DECLINED'),(4,3,2,'PENDING'),(5,3,3,'PENDING'),(6,3,4,'ACCEPTED'),(7,3,5,'PENDING'),(8,3,6,'PENDING'),(11,60,5,'ACCEPTED'),(12,60,6,'DECLINED'),(14,2,1,'DECLINED'),(15,2,3,'PENDING'),(16,2,2,'PENDING'),(17,2,4,'ACCEPTED'),(18,2,5,'PENDING'),(19,2,6,'PENDING'),(20,2,9,'PENDING');
/*!40000 ALTER TABLE `tb_apply_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_comment`
--

DROP TABLE IF EXISTS `tb_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_comment` (
  `id_comment` int(11) NOT NULL AUTO_INCREMENT,
  `id_thread` int(11) NOT NULL,
  `id_profile` int(11) NOT NULL,
  `comment` text NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `id_thread` (`id_thread`),
  KEY `id_profile` (`id_profile`),
  CONSTRAINT `tb_comment_ibfk_1` FOREIGN KEY (`id_thread`) REFERENCES `tb_thread` (`id_thread`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_comment_ibfk_2` FOREIGN KEY (`id_profile`) REFERENCES `tb_user_profile` (`id_profile`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comment`
--

LOCK TABLES `tb_comment` WRITE;
/*!40000 ALTER TABLE `tb_comment` DISABLE KEYS */;
INSERT INTO `tb_comment` VALUES (1,1,6,'Good tutorial!!'),(2,3,6,'tes'),(3,3,6,'tes'),(4,3,7,'bruh'),(5,8,3,'testing comment'),(6,1,3,'testing comment');
/*!40000 ALTER TABLE `tb_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_jobs`
--

DROP TABLE IF EXISTS `tb_jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_jobs` (
  `id_job` int(11) NOT NULL AUTO_INCREMENT,
  `job_level` varchar(200) NOT NULL,
  `job_time` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_description` text NOT NULL,
  `company_name` varchar(200) NOT NULL,
  `company_image` varchar(200) NOT NULL,
  PRIMARY KEY (`id_job`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_jobs`
--

LOCK TABLES `tb_jobs` WRITE;
/*!40000 ALTER TABLE `tb_jobs` DISABLE KEYS */;
INSERT INTO `tb_jobs` VALUES (1,'Senior','Full Time','Software Developer','Software developers design, program, build, deploy and maintain software using many different skills and tools.','Google','images/logo/google.png'),(2,'Junior','Part Time','IT Technician','An IT technician collaborates with support specialists to analyze and diagnose computer issues.','Facebook','images/logo/facebook.png'),(3,'Intern','Part Time','Web Developer','Web developers design the appearance, navigation and content organization of a website.','Microsoft','images/logo/microsoft.png'),(4,'Senior','Full Time','IT Security Specialist','IT security specialists work in various industries to build and maintain digital protective measures on intellectual property and data that belong to an organization.','Google','images/logo/google.png'),(5,'Junior','Part Time','Web Developer','Web developers design the appearance, navigation and content organization of a website.','Facebook','images/logo/facebook.png'),(6,'Intern','Part Time','Database Administrator','Database administrators employ specialized software to organize and keep track of data.','Microsoft','images/logo/microsoft.png'),(9,'Intern','Part Time','Customer Service','Handling customer service jobs','Lithan','images/logo/lithan.png'),(10,'Senior','Full Time','DevOps','DevOps is all about the unification and automation of processes, and DevOps engineers are instrumental in combining code, application maintenance, and application management.','AWS','images/logo/aws.png');
/*!40000 ALTER TABLE `tb_jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tags`
--

DROP TABLE IF EXISTS `tb_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tags` (
  `id_tag` int(11) NOT NULL AUTO_INCREMENT,
  `first_tag` varchar(200) NOT NULL,
  `second_tag` varchar(200) NOT NULL,
  PRIMARY KEY (`id_tag`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tags`
--

LOCK TABLES `tb_tags` WRITE;
/*!40000 ALTER TABLE `tb_tags` DISABLE KEYS */;
INSERT INTO `tb_tags` VALUES (1,'Programming','Java'),(2,'Tips','Phyton'),(3,'Tutorial','Javascript'),(4,'Ask','C++');
/*!40000 ALTER TABLE `tb_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_thread`
--

DROP TABLE IF EXISTS `tb_thread`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_thread` (
  `id_thread` int(11) NOT NULL AUTO_INCREMENT,
  `id_profile` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id_thread`),
  KEY `id_profile` (`id_profile`),
  CONSTRAINT `tb_thread_ibfk_1` FOREIGN KEY (`id_profile`) REFERENCES `tb_user_profile` (`id_profile`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_thread`
--

LOCK TABLES `tb_thread` WRITE;
/*!40000 ALTER TABLE `tb_thread` DISABLE KEYS */;
INSERT INTO `tb_thread` VALUES (1,6,'How to create one to many bidirectional mapping with JPA','In this tutorial, we will learn how to perform one-to-many domain model Bidirectional mapping using Spring Data JPA (Hibernate as JPA provider).\nWe will take Order and OrderItems entities to implement one-to-many Bidirectional mapping. The Order entity has a one-to-many association to the OrderItems entity, and the OrderItems entity has a many-to-one relationship to the Order entity.'),(3,6,'How to become software developer','Just don\'t'),(8,3,'Test Edit','testing testing'),(9,3,'test post thread','test');
/*!40000 ALTER TABLE `tb_thread` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_thread_tags`
--

DROP TABLE IF EXISTS `tb_thread_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_thread_tags` (
  `id_thread_tag` int(11) NOT NULL AUTO_INCREMENT,
  `id_thread` int(11) NOT NULL,
  `first_tag` varchar(200) NOT NULL,
  `second_tag` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_thread_tag`),
  KEY `id_thread` (`id_thread`),
  CONSTRAINT `tb_thread_tags_ibfk_1` FOREIGN KEY (`id_thread`) REFERENCES `tb_thread` (`id_thread`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_thread_tags`
--

LOCK TABLES `tb_thread_tags` WRITE;
/*!40000 ALTER TABLE `tb_thread_tags` DISABLE KEYS */;
INSERT INTO `tb_thread_tags` VALUES (1,1,'Programming','Java'),(3,3,'Tips',''),(9,8,'Tips','Javascript'),(10,9,'Tutorial','');
/*!40000 ALTER TABLE `tb_thread_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_profile`
--

DROP TABLE IF EXISTS `tb_user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_profile` (
  `id_profile` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_job` int(11) DEFAULT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) NOT NULL,
  `country` text NOT NULL,
  `city` text NOT NULL,
  `about` text DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `banner` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_profile`),
  KEY `id_user` (`id_user`),
  KEY `id_job` (`id_job`),
  CONSTRAINT `tb_user_profile_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `tb_users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_profile_ibfk_2` FOREIGN KEY (`id_job`) REFERENCES `tb_jobs` (`id_job`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_profile`
--

LOCK TABLES `tb_user_profile` WRITE;
/*!40000 ALTER TABLE `tb_user_profile` DISABLE KEYS */;
INSERT INTO `tb_user_profile` VALUES (2,2,4,'Dayu','Ratih','Indonesia','Bali','Hello i\'m Dayu Ratih','images/user/user1.jpg','images/banner/banner2.jpg'),(3,3,4,'Ricky','Tegar','Indonesia','Balik Papan','Hello ','images/user/user2.png','images/banner/banner5.jpg'),(4,4,4,'Yopha','Candra','Indonesia','Jakarta',NULL,'images/user/user-default.png','images/banner/banner3.jpg'),(5,5,2,'Yoga','Setiawan','Indonesia','Aceh',NULL,'images/user/user2.png','images/banner/banner8.jpg'),(6,6,5,'Andrian','Sulivan','Indonesia','Jakarta','I\'m junior software engineer :D','images/user/user6.png','images/banner/banner5.jpg'),(7,7,1,'Gustut','Yoghantara','Indonesia','Bali',NULL,'images/user/user3.png','images/banner/banner8.jpg'),(13,15,3,'Mery','Junia','America','New York',NULL,'images/user/user-default.png','images/banner/banner7.jpg'),(35,37,1,'Dusa','Gaqy','Singapore','Yishun',NULL,'images/user/user-default.png','images/banner/banner1.jpg'),(38,41,3,'Loky','Hujo','Indonesia','Bali',NULL,'images/user/user-default.png','images/banner/banner2.jpg'),(41,44,4,'Maria','Fukada','Japan','Tokyo',NULL,'images/user/user5.png','images/banner/banner3.jpg'),(45,49,1,'Ligova','Deitada','America','New York',NULL,'images/user/user-default.png','images/banner/banner3.jpg'),(58,62,2,'Meruqu','Lyric','Indonesia','Jakarta',NULL,'images/user/user4.png','images/banner/banner4.jpg'),(59,63,2,'Salvia','Adira','Indonesia','Bali',NULL,'images/user/user-default.png','images/banner/banner6.jpg'),(60,64,5,'Dabari','Kimoto','Japan','Tokyo',NULL,'images/user/user-default.png','images/banner/banner8.jpg');
/*!40000 ALTER TABLE `tb_user_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_users`
--

DROP TABLE IF EXISTS `tb_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_users`
--

LOCK TABLES `tb_users` WRITE;
/*!40000 ALTER TABLE `tb_users` DISABLE KEYS */;
INSERT INTO `tb_users` VALUES (2,'user2@gmail.com','password123',1),(3,'user3@gmail.com','user123',1),(4,'user4@gmail.com','user123',1),(5,'user5@gmail.com','user123',1),(6,'sulivan@email.com','password',1),(7,'gustut@email.com','password123',1),(15,'testactivation@email.com','password',0),(37,'dusagaqy@ema-sofia.eu','password',1),(41,'lukyhoju@ema-sofia.eu','password',1),(44,'locebop192@ploneix.com','password',1),(45,'unittest@email.com','password',1),(49,'ligova2875@deitada.com','password123',1),(62,'meruqu@lyricspad.net','password123',1),(63,'panavel359@lutota.com','password',1),(64,'dabasis478@inkmoto.com','password',1);
/*!40000 ALTER TABLE `tb_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-14 17:21:41
