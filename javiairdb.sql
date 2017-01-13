-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: localhost    Database: javiairdb
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditcard` (
  `CardId` int(10) NOT NULL AUTO_INCREMENT,
  `OwnersName` varchar(40) DEFAULT NULL,
  `Address1` varchar(255) NOT NULL,
  `Address2` varchar(255) NOT NULL,
  `Address3` varchar(255) NOT NULL,
  `CardType` varchar(40) NOT NULL,
  `CardNumber` varchar(255) DEFAULT NULL,
  `ExpiryDate` varchar(40) NOT NULL,
  `CCVNumber` varchar(40) NOT NULL,
  PRIMARY KEY (`CardId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
INSERT INTO `creditcard` VALUES (1,'Dermot','dsf','sdf','sdf','sdf','4929766254319102','2017-01-05','123'),(2,'Dermot','sdf','sdf','sdf','sdf','4929766254319102','2017-01-04','234'),(3,'Hoop','sdf','sdf','sdf','sdf','4929766254319102','2017-01-03','123'),(4,'Drrr','sf','sd','sdf','sdf','4929766254319102','2016-12-29','234'),(5,'Sdfs','sdf','sdf','df','sdf','4929766254319102','2017-01-04','123'),(6,'Bert','dfg','dsf','sdf','sdf','4929766254319102','2017-01-12','123'),(7,'Goop','sdf','sdf','sdf','sdf','4929766254319102','2017-01-17','123'),(8,'Gpph','sdf','sdf','sdfsdf','sdf','4929766254319102','2017-01-04','234'),(9,'ASdasd','asdas','adsa','sdasd','asdasd','4929766254319102','2017-01-04','123'),(10,'SDfsd','sdf','sdf','f','fsd','4929766254319102','2016-12-27','213'),(11,'sdf','sdf','sdf','sdf','dsf','4929766254319102','2017-01-04','231'),(12,'SDF','sdf','sdf','sdf','sdf','4929766254319102','2017-01-04','3245'),(13,'Der','sdf','sdf','fdg','dsfg','4929766254319102','2017-01-12','123'),(14,'Fer','sdf','sdf','sdf','sdf','4929766254319102','2016-12-28','123'),(15,'sdf','sdf','sdf','sdf','sdfs','4929766254319102','2017-01-04','234'),(16,'sfd','sdf','sdf','sdf','sdf','4929766254319102','2017-01-04','234'),(17,'sdf','sdf','sdf','sdf','sdf','4929766254319102','2017-01-11','342'),(18,'SDFsdf','fds','dsfs','dfs','sdf','4929766254319102','2017-01-18','234'),(19,'sdf','sdf','sdf','sdf','sdf','4929766254319102','2016-12-29','234'),(20,'SDF','sdf','sdf','sdf','sdf','4929766254319102','2017-01-11','123'),(21,'SDF','sdf','sdf','sdf','sdf','4929766254319102','2017-01-11','123'),(22,'sdf','sdf','sdf','sdf','sdf','4929766254319102','2017-01-13','345'),(23,'Sdf','sdf','sdf','sdf','dsf','4929766254319102','2017-01-19','123'),(24,'Goop','sdf','sdf','sdf','sdf','4929766254319102','2017-01-11','234'),(25,'SDfsdf','sdf','sdf','sdf','sdfsd','4929766254319102','2017-01-04','123'),(26,'SDfs','sdf','sdf','sdf','sdfs','4929766254319102','2016-12-26','234'),(27,'ASd','dsf','sdf','sdf','sdf','4929766254319102','2017-01-03','234'),(28,'SDf','sdf','sdf','sdf','sdf','4929766254319102','2017-01-11','214'),(29,'Dsf','dsf','sdf','fdg','sdf','4929766254319102','2017-01-11','345'),(30,'Sdf','sdf','sdf','sdf','sdf','4929766254319102','2017-01-12','123'),(31,'sdf','sdf','sdf','sdf','sdf','4929766254319102','2017-01-11','231'),(32,'sdf','sdfsd','sdf','sfd','sdf','4929766254319102','2017-01-11','234'),(33,'sdf','sdf','sdf','sdf','sdf','4929766254319102','2016-12-29','324'),(34,'sdf','sdf','sdfsdf','sdf','sdf','4929766254319102','2017-01-04','234'),(35,'sdf','sdf','sdf','sdf','sdf','4929766254319102','2017-01-05','234'),(36,'sdf','sdf','sdf','sdf','sdf','4929766254319102','2017-01-11','123'),(37,'asd','asd','asd','asd','sf','4929766254319102','2017-01-05','234');
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flights` (
  `FlightId` int(10) NOT NULL AUTO_INCREMENT,
  `Origin` varchar(255) NOT NULL,
  `Destination` varchar(255) NOT NULL,
  `DepartPrice` varchar(10) DEFAULT NULL,
  `ReturnPrice` varchar(10) DEFAULT NULL,
  `Price` varchar(10) DEFAULT NULL,
  `DepartTime` varchar(10) DEFAULT NULL,
  `ReturnTime` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FlightId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,'MAD','STN','60.0','72.0','132.0',NULL,'1400-1520'),(2,'SBK','STN','80.0','96.0','176.0','0805-0830',NULL),(3,'MAD','JER','200.0','0.0','200.0','0620-0800',NULL),(4,'MAD','STN','60.0','0.0','60.0','1400-1520',NULL),(5,'SBK','CDG','150.0','0.0','150.0','0620-0715',NULL),(6,'SBK','STN','80.0','96.0','176.0','0805-0830',NULL),(7,'MAD','STN','60.0','72.0','132.0',NULL,'1400-1520'),(8,'MAD','CDG','60.0','0.0','60.0','0800-1000',NULL),(9,'MAD','CDG','0.0','0.0','0.0','0800-1000',NULL),(10,'SBK','CDG','150.0','0.0','150.0','0620-0715',NULL),(11,'SBK','STN','80.0','96.0','176.0','0805-0830',NULL),(12,'ORK','JER','120.0','120.0','240.0','1400-1600',NULL),(13,'SBK','CDG','150.0','150.0','300.0','0620-0715',NULL),(14,'ORK','JER','120.0','120.0','240.0','1400-1600',NULL),(15,'ORK','STN','40.0','40.0','80.0','0820-0950','0820-0950'),(16,'SBK','STN','80.0','80.0','160.0','0805-0830',NULL),(17,'SBK','STN','80.0','0.0','80.0','0805-0830',NULL),(18,'MAD','JER','200.0','0.0','200.0','0620-0800',NULL),(19,'JER','CDG','250.0','0.0','250.0','0800-1015',NULL),(20,'MAD','AGP','60.0','60.0','120.0','0800-0905',NULL),(21,'ORK','CDG','80.0','0.0','80.0','0900-1215',NULL),(22,'AGP','MAD','60.0','60.0','120.0','2000-2105',NULL),(23,'MAD','AGP','60.0','0.0','60.0','0800-0905',NULL),(24,'MAD','AGP','60.0','60.0','120.0','0800-0905',NULL),(25,'AGP','MAD','60.0','60.0','120.0','2000-2105',NULL),(26,'AGP','MAD','60.0','72.0','132.0','2000-2105',NULL),(27,'MAD','STN','60.0','60.0','120.0','1400-1520','1400-1520'),(28,'STN','MAD','60.0','0.0','60.0','1020-1400',NULL),(29,'ORK','AGP','240.0','0.0','240.0','0800-1130',NULL),(30,'ORK','STN','40.0','0.0','40.0','0820-0950',NULL),(31,'SBK','STN','80.0','96.0','176.0','0805-0830',NULL),(32,'JER','CDG','250.0','0.0','250.0','0800-1015',NULL),(33,'MAD','CDG','60.0','0.0','60.0','0800-1000',NULL),(34,'ORK','JER','120.0','144.0','264.0','1400-1600',NULL),(35,'MAD','CDG','60.0','0.0','60.0','0800-1000',NULL),(36,'JER','AGP','280.0','0.0','280.0','0800-1130',NULL),(37,'SBK','STN','80.0','96.0','176.0','0805-0830',NULL);
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `PassengerId` int(10) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(10) DEFAULT NULL,
  `LastName` varchar(10) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `BaggageSelected` tinyint(1) DEFAULT NULL,
  `SpanishSelected` tinyint(1) DEFAULT NULL,
  `Dni` varchar(10) DEFAULT NULL,
  `BagPrice` int(10) DEFAULT NULL,
  `SpanishRebate` int(10) DEFAULT NULL,
  PRIMARY KEY (`PassengerId`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'Der','Cove','1992-01-01',0,1,'00000010-X',0,10),(2,'Bria','Coveney','2014-01-22',1,0,'',30,0),(3,'Foot','sfsdfsdf','1992-01-01',0,0,'',0,0),(4,'Hoop','Doo','1992-01-01',0,0,'',0,0),(5,'Dfffp','sdf','1992-01-01',0,0,'',0,0),(6,'DFGdfg','dsfsdf','1922-01-01',0,0,'',0,0),(7,'Gpppt','dfg','1992-01-01',0,0,'',0,0),(8,'Fpppr','sdf','1992-01-01',0,0,'',0,0),(9,'Foor','sdfsd','1992-01-01',0,0,'',0,0),(10,'Asd','sdf','1992-01-01',0,0,'',0,0),(11,'Asdas','dsfsd','2017-01-10',0,0,'',0,0),(12,'SDfsdf','sdfsfd','1992-01-01',0,0,'',0,0),(13,'Sdfsdf','sdfsfd','1992-01-01',0,0,'',0,0),(14,'Sdfsdf','dfg','1992-01-01',0,0,'',0,0),(15,'SDFsd','sdf','1992-01-01',0,0,'',0,0),(16,'Sdfsdf','sdfgsd','1992-01-01',0,0,'',0,0),(17,'SDfsdf','DSFSD','1992-01-01',0,0,'',0,0),(18,'SDFsdf','sdfsdf','1992-01-01',0,0,'',0,0),(19,'Der','Cerw','1992-01-01',0,0,'',0,0),(20,'Bri','Csdf','1992-01-01',0,0,'',0,0),(21,'Fer','Sd','1992-01-01',0,0,'',0,0),(22,'Fer','SD','1992-01-01',0,0,'',0,0),(23,'SDfs','dfg','1992-01-01',0,0,'',0,0),(24,'SDFsdf','sdfgs','1992-01-01',0,0,'',0,0),(25,'SDfwe','sdfsdf','1992-01-01',0,0,'',0,0),(26,'SDfsdf','fgfd','1992-01-01',0,0,'',0,0),(27,'SDf','sdf','1992-01-01',0,0,'',0,0),(28,'SDfsdf','dsfds','1992-01-01',0,0,'',0,0),(29,'SDfsd','sdfd','1992-01-01',0,0,'',0,0),(30,'SDFSDFsdf','sdfsdf','1992-01-01',0,0,'',0,0),(31,'SDFsdf','sdfsdf','1992-01-01',0,0,'',0,0),(32,'SDfsdf','sdfsdf','1992-01-01',0,0,'',0,0),(33,'ASdas','sdfs','1992-01-01',1,0,'',30,0),(34,'ASD','sdf','1992-01-01',0,1,'00000010-X',0,10),(35,'Sdf','sdf','1992-01-01',1,0,'',15,0),(36,'SDF','sdf','1992-01-01',0,0,'',0,0),(37,'SDfq','defs','1992-01-01',0,1,'00000010-X',0,5),(38,'SDFsd','sdf','1992-01-01',1,0,'',30,0),(39,'SDfsdq','sdfsdf','1992-01-01',0,1,'00000010-X',0,10),(40,'Sdfsdf','sdfsdf','1992-01-01',1,0,'',15,0),(41,'SDFSdfsdf','SDFSdfsdf','1992-01-01',0,1,'00000010-X',0,10),(42,'SDFSdfsdf','SDFSdfsdf','1992-01-01',1,0,'',30,0),(43,'SDFSdfsdf','SDFSdfsdf','1992-01-01',0,0,'',0,0),(44,'SDFSDFsdf','SDFSDFsdf','1992-01-01',0,1,'00000010-X',0,5),(45,'SDFSDFsdf','SDFSDFsdf','1992-01-01',0,0,'',0,0),(46,'SDFSDFsdf','SDFSDFsdf','1992-01-01',1,0,'',30,0),(47,'Sdf','Sdf','1992-01-01',0,1,'00000010-X',0,5),(48,'Sdf','Sdf','1992-01-01',0,0,'',0,0),(49,'Sdf','Sdf','1992-01-01',1,0,'',30,0),(50,'SDfsdf','sdf','1992-01-01',0,0,'',0,0),(51,'SDFs','sdf','1992-01-01',0,0,'',0,0),(52,'Sdfsew','sdf','1992-01-10',0,0,'',0,0),(53,'SDFSDfsdf','SDFSDfsdf','1992-01-01',0,0,'',0,0),(54,'SDFSDfsdf','SDFSDfsdf','1992-01-01',0,0,'',0,0),(55,'SDfsdfsd','sdfsf','1992-01-01',0,0,'',0,0),(56,'SDfsdf','sdfs','1992-01-01',0,0,'',0,0),(57,'Sdfq','fs','1992-01-01',0,0,'',0,0),(58,'SDf','sdf','1992-01-01',0,0,'',0,0),(59,'SDfdf','sdf','1992-01-01',0,0,'',0,0),(60,'SDFsdq','sdf','1992-01-01',0,0,'',0,0),(61,'SDFSDfsd','sdf','1992-01-01',0,0,'',0,0),(62,'SDFsdf','sdf','1992-01-01',0,0,'',0,0),(63,'SDFsdf','sdfsd','1922-01-01',0,0,'',0,0);
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-13  9:42:12
