-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: parqueaderobd
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estudiante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL,
  `codigo` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (8,'Dana García','20151136506');
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parqueadero`
--

DROP TABLE IF EXISTS `parqueadero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parqueadero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_puestos` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parqueadero`
--

LOCK TABLES `parqueadero` WRITE;
/*!40000 ALTER TABLE `parqueadero` DISABLE KEYS */;
INSERT INTO `parqueadero` VALUES (1,30),(2,50),(3,10);
/*!40000 ALTER TABLE `parqueadero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `puesto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` tinyint(4) NOT NULL,
  `id_parqueadero` int(11) NOT NULL,
  `id_estudiante` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Puesto_Parqueadero1_idx` (`id_parqueadero`),
  KEY `fk_Puesto_Estudiante1_idx` (`id_estudiante`),
  CONSTRAINT `fk_Puesto_Estudiante1` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id`),
  CONSTRAINT `fk_Puesto_Parqueadero1` FOREIGN KEY (`id_parqueadero`) REFERENCES `parqueadero` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES (1,1,3,8),(2,0,3,NULL),(3,0,3,NULL),(4,0,3,NULL),(5,0,3,NULL),(6,0,3,NULL),(7,0,3,NULL),(8,0,3,NULL),(9,0,3,NULL),(10,0,3,NULL),(11,0,1,NULL),(12,0,1,NULL),(13,0,1,NULL),(14,0,1,NULL),(15,0,1,NULL),(16,0,1,NULL),(17,0,1,NULL),(18,0,1,NULL),(19,0,1,NULL),(20,0,1,NULL),(21,0,1,NULL),(22,0,1,NULL),(23,0,1,NULL),(24,0,1,NULL),(25,0,1,NULL),(26,0,1,NULL),(27,0,1,NULL),(28,0,1,NULL),(29,0,1,NULL),(30,0,1,NULL),(31,0,1,NULL),(32,0,1,NULL),(33,0,1,NULL),(34,0,1,NULL),(35,0,1,NULL),(36,0,1,NULL),(37,0,1,NULL),(38,0,1,NULL),(39,0,1,NULL),(40,0,1,NULL);
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-25  1:27:13
