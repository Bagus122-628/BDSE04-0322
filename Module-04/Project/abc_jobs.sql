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
  `last_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_admin`
--

LOCK TABLES `tb_admin` WRITE;
/*!40000 ALTER TABLE `tb_admin` DISABLE KEYS */;
INSERT INTO `tb_admin` VALUES (1,'admin@gmail.com','admin123','Gustut','Yoghantara');
/*!40000 ALTER TABLE `tb_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_apply_job`
--

DROP TABLE IF EXISTS `tb_apply_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_apply_job` (
  `fk_id_user_profile` int(11) NOT NULL,
  `fk_id_job` int(11) NOT NULL,
  KEY `fk_id_user_profile` (`fk_id_user_profile`),
  KEY `fk_id_job` (`fk_id_job`),
  CONSTRAINT `tb_apply_job_ibfk_1` FOREIGN KEY (`fk_id_user_profile`) REFERENCES `tb_user_profile` (`id_user_profile`),
  CONSTRAINT `tb_apply_job_ibfk_2` FOREIGN KEY (`fk_id_job`) REFERENCES `tb_jobs` (`id_job`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_apply_job`
--

LOCK TABLES `tb_apply_job` WRITE;
/*!40000 ALTER TABLE `tb_apply_job` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_apply_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_bulk_invite`
--

DROP TABLE IF EXISTS `tb_bulk_invite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_bulk_invite` (
  `id_bulk_invite` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_admin` int(11) NOT NULL,
  `email_title` varchar(200) NOT NULL,
  `email_content` text NOT NULL,
  PRIMARY KEY (`id_bulk_invite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_bulk_invite`
--

LOCK TABLES `tb_bulk_invite` WRITE;
/*!40000 ALTER TABLE `tb_bulk_invite` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_bulk_invite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_comments`
--

DROP TABLE IF EXISTS `tb_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_comments` (
  `fk_id_thread` int(11) NOT NULL,
  `fk_id_user_profile` int(11) NOT NULL,
  `comment` text NOT NULL,
  `time_sent` timestamp NULL DEFAULT NULL,
  KEY `fk_id_thread` (`fk_id_thread`),
  KEY `fk_id_user_profile` (`fk_id_user_profile`),
  CONSTRAINT `tb_comments_ibfk_1` FOREIGN KEY (`fk_id_thread`) REFERENCES `tb_thread` (`id_thread`),
  CONSTRAINT `tb_comments_ibfk_2` FOREIGN KEY (`fk_id_user_profile`) REFERENCES `tb_user_profile` (`id_user_profile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comments`
--

LOCK TABLES `tb_comments` WRITE;
/*!40000 ALTER TABLE `tb_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_company`
--

DROP TABLE IF EXISTS `tb_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_company` (
  `id_company` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(200) NOT NULL,
  `country` text NOT NULL,
  `city` text NOT NULL,
  `company_picture` text DEFAULT NULL,
  PRIMARY KEY (`id_company`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_company`
--

LOCK TABLES `tb_company` WRITE;
/*!40000 ALTER TABLE `tb_company` DISABLE KEYS */;
INSERT INTO `tb_company` VALUES (1,'Google','Indonesia','Jakarta',NULL),(2,'Facebook','United States','New York',NULL),(3,'Microsoft','Indonesia','Bali',NULL);
/*!40000 ALTER TABLE `tb_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_conversation`
--

DROP TABLE IF EXISTS `tb_conversation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_conversation` (
  `id_conversation` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_from` int(11) NOT NULL,
  `fk_id_to` int(11) NOT NULL,
  PRIMARY KEY (`id_conversation`),
  UNIQUE KEY `unique_conversation` (`fk_id_from`,`fk_id_to`),
  KEY `fk_id_to` (`fk_id_to`),
  CONSTRAINT `tb_conversation_ibfk_1` FOREIGN KEY (`fk_id_from`) REFERENCES `tb_user_profile` (`id_user_profile`),
  CONSTRAINT `tb_conversation_ibfk_2` FOREIGN KEY (`fk_id_to`) REFERENCES `tb_user_profile` (`id_user_profile`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_conversation`
--

LOCK TABLES `tb_conversation` WRITE;
/*!40000 ALTER TABLE `tb_conversation` DISABLE KEYS */;
INSERT INTO `tb_conversation` VALUES (1,1,2);
/*!40000 ALTER TABLE `tb_conversation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_jobs`
--

DROP TABLE IF EXISTS `tb_jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_jobs` (
  `id_job` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_admin` int(11) NOT NULL,
  `fk_id_company` int(11) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_description` text NOT NULL,
  PRIMARY KEY (`id_job`),
  KEY `fk_id_admin` (`fk_id_admin`),
  KEY `job_index` (`fk_id_company`,`job_name`),
  CONSTRAINT `tb_jobs_ibfk_1` FOREIGN KEY (`fk_id_admin`) REFERENCES `tb_admin` (`id_admin`),
  CONSTRAINT `tb_jobs_ibfk_2` FOREIGN KEY (`fk_id_company`) REFERENCES `tb_company` (`id_company`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_jobs`
--

LOCK TABLES `tb_jobs` WRITE;
/*!40000 ALTER TABLE `tb_jobs` DISABLE KEYS */;
INSERT INTO `tb_jobs` VALUES (1,1,1,'Software Developer','Software developers design, program, build, deploy and maintain software using many different skills and tools.'),(2,1,1,'IT Technician','An IT technician collaborates with support specialists to analyze and diagnose computer issues.'),(3,1,2,'Web Developer','Web developers design the appearance, navigation and content organization of a website.'),(4,1,2,'IT Security Specialist','IT security specialists work in various industries to build and maintain digital protective measures on intellectual property and data that belong to an organization.'),(5,1,3,'Web Developer','Web developers design the appearance, navigation and content organization of a website.'),(6,1,3,'Database Administrator','Database administrators employ specialized software to organize and keep track of data.');
/*!40000 ALTER TABLE `tb_jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_messages`
--

DROP TABLE IF EXISTS `tb_messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_messages` (
  `id_message` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_conversation` int(11) NOT NULL,
  `is_from_sender` tinyint(1) NOT NULL,
  `message` text NOT NULL,
  `time_sent` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_message`),
  KEY `fk_id_conversation` (`fk_id_conversation`),
  CONSTRAINT `tb_messages_ibfk_1` FOREIGN KEY (`fk_id_conversation`) REFERENCES `tb_conversation` (`id_conversation`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_messages`
--

LOCK TABLES `tb_messages` WRITE;
/*!40000 ALTER TABLE `tb_messages` DISABLE KEYS */;
INSERT INTO `tb_messages` VALUES (1,1,1,'test message','2022-12-30 04:10:10'),(2,1,0,'test reply message','2022-12-30 04:10:11');
/*!40000 ALTER TABLE `tb_messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_thread`
--

DROP TABLE IF EXISTS `tb_thread`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_thread` (
  `id_thread` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_user_profile` int(11) NOT NULL,
  `thread_name` varchar(200) NOT NULL,
  `thread_content` text NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_thread`),
  KEY `fk_id_user_profile` (`fk_id_user_profile`),
  CONSTRAINT `tb_thread_ibfk_1` FOREIGN KEY (`fk_id_user_profile`) REFERENCES `tb_user_profile` (`id_user_profile`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_thread`
--

LOCK TABLES `tb_thread` WRITE;
/*!40000 ALTER TABLE `tb_thread` DISABLE KEYS */;
INSERT INTO `tb_thread` VALUES (1,1,'How to insert into database?','I want to insert data into my database table, how to do that?','2022-10-10 02:10:10');
/*!40000 ALTER TABLE `tb_thread` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_profile`
--

DROP TABLE IF EXISTS `tb_user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_profile` (
  `id_user_profile` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_user` int(11) NOT NULL,
  `fk_id_job` int(11) DEFAULT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `country` text NOT NULL,
  `city` text NOT NULL,
  `about` text DEFAULT NULL,
  `profile_picture` text DEFAULT NULL,
  PRIMARY KEY (`id_user_profile`),
  KEY `fk_id_user` (`fk_id_user`),
  KEY `fk_id_job` (`fk_id_job`),
  KEY `profile_name` (`first_name`,`last_name`),
  FULLTEXT KEY `profile_address` (`country`,`city`),
  CONSTRAINT `tb_user_profile_ibfk_1` FOREIGN KEY (`fk_id_user`) REFERENCES `tb_users` (`id_user`),
  CONSTRAINT `tb_user_profile_ibfk_2` FOREIGN KEY (`fk_id_job`) REFERENCES `tb_jobs` (`id_job`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_profile`
--

LOCK TABLES `tb_user_profile` WRITE;
/*!40000 ALTER TABLE `tb_user_profile` DISABLE KEYS */;
INSERT INTO `tb_user_profile` VALUES (1,1,1,'Putri','Puspita','Indonesia','Bali',NULL,NULL),(2,2,1,'Dayu','Ratih','Indonesia','Medan',NULL,NULL),(3,3,2,'Ricky','Tegar','Indonesia','Balik Papan',NULL,NULL),(4,4,NULL,'Yopha','Candra','Indonesia','Jakarta',NULL,NULL),(5,5,3,'Yoga','Sathya','Indonesia','Bali',NULL,NULL),(6,6,NULL,'Loydie','Clemerson','Egypt','Kafr ad Dawwār',NULL,NULL),(7,7,2,'Kim','Maffeo','Nigeria','Lame',NULL,NULL),(8,8,3,'Marie','Sackey','China','Sancha',NULL,NULL),(9,9,4,'Kath','Soitoux','Greece','Kalloní',NULL,NULL),(10,10,1,'Isabelita','Sermin','Sweden','Säter',NULL,NULL),(11,11,NULL,'Justino','Gwyn','Slovenia','Rače',NULL,NULL),(12,12,NULL,'Kaiser','Rex','China','Lengkeng',NULL,NULL),(13,13,2,'Benedicta','Candie','Greece','Xinó Neró',NULL,NULL),(14,14,1,'Carmine','Galtone','France','Nanterre',NULL,NULL),(15,15,3,'Patti','Bickerdicke','Japan','Ōkawa',NULL,NULL),(16,16,NULL,'Muhammad','Westgate','Palestinian Territory','Birqīn',NULL,NULL),(17,17,1,'Meade','Jumel','Greece','Vanáton',NULL,NULL),(18,18,4,'Gage','Kennard','Portugal','Évora',NULL,NULL),(19,19,4,'Kristoffer','Thaine','Nepal','Pātan',NULL,NULL),(20,20,5,'Solly','Ketchell','Indonesia','Batanghari',NULL,NULL),(21,21,6,'Ike','Bartell','China','Tangnanzhen',NULL,NULL),(22,22,4,'Nobie','Berens','China','Huanggang',NULL,NULL),(23,23,6,'Ferdy','Pidgeley','Ethiopia','Nazrēt',NULL,NULL),(24,24,5,'Kurt','Perree','United States','San Antonio',NULL,NULL),(25,25,6,'Letisha','Lightowlers','Saudi Arabia','Al Jarādīyah',NULL,NULL);
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
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_users`
--

LOCK TABLES `tb_users` WRITE;
/*!40000 ALTER TABLE `tb_users` DISABLE KEYS */;
INSERT INTO `tb_users` VALUES (1,'user@gmail.com','user123'),(2,'user2@gmail.com','user123'),(3,'user3@gmail.com','user123'),(4,'user4@gmail.com','user123'),(5,'user5@gmail.com','user123'),(6,'mmeth0@ftc.gov','SNLlLD1C2'),(7,'acurthoys1@europa.eu','cNyuo5f7i'),(8,'wkeddy2@engadget.com','t97gBuwzVY'),(9,'dpapps3@usa.gov','zM1DrmWgB'),(10,'gwillingham4@samsung.com','Gj5N05udhj6'),(11,'mmalletratt5@php.net','6coX4Yv'),(12,'rcheine6@businessinsider.com','Cak7WSHkA'),(13,'bbelone7@skyrock.com','lBUtP5YBa7FR'),(14,'kfelstead8@bbb.org','BuYRvUnATH'),(15,'abc@email.com','opZ9kYrwV'),(16,'agamwella@github.com','j1DeKMT36'),(17,'sfreakb@icio.us','SDwFFvl6GLT'),(18,'zizzatc@1688.com','VcqX0fJwSn46'),(19,'kmozzid@xrea.com','1kC9ynIYK'),(20,'lfoffanoe@blinklist.com','GaoynOk2KOZh'),(21,'oskentelburyf@msu.edu','iN0AzkB04CAE'),(22,'tsydeg@nydailynews.com','H27mgf'),(23,'cdetloffh@spotify.com','0SpHIon'),(24,'tgarletti@house.gov','E9Cmq7EVR'),(25,'lseyj@java.com','ovyfBubXJpJl'),(26,'anhhwgdyhaw@gmail.com','user123');
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

-- Dump completed on 2022-08-05 12:28:23
