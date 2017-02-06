-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: aviame
-- ------------------------------------------------------
-- Server version	5.6.34-log

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
-- Table structure for table `enfermedad`
--

DROP TABLE IF EXISTS `enfermedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfermedad` (
  `id_enfermedad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) DEFAULT NULL,
  `sintomas` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_enfermedad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermedad`
--

LOCK TABLES `enfermedad` WRITE;
/*!40000 ALTER TABLE `enfermedad` DISABLE KEYS */;
INSERT INTO `enfermedad` VALUES (1,'Anemia','Perdida de equilibrio, palido y adelgazamiento'),(2,'Cocccidios','Pajaro inchado, diarrea y como mucho'),(3,'Pulmonia','Tos y dificultades respiratorias'),(4,'Hepatitis','Perdidad del canto, heces liquidas'),(5,'Falsa muda','Perdida de plumas');
/*!40000 ALTER TABLE `enfermedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfermedades`
--

DROP TABLE IF EXISTS `enfermedades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfermedades` (
  `id_enfermedad` int(3) NOT NULL DEFAULT '0',
  `id_pajaro` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_enfermedad`,`id_pajaro`),
  KEY `id_pajaro` (`id_pajaro`),
  CONSTRAINT `enfermedades_ibfk_1` FOREIGN KEY (`id_enfermedad`) REFERENCES `enfermedad` (`id_enfermedad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `enfermedades_ibfk_2` FOREIGN KEY (`id_pajaro`) REFERENCES `pajaro` (`id_pajaro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermedades`
--

LOCK TABLES `enfermedades` WRITE;
/*!40000 ALTER TABLE `enfermedades` DISABLE KEYS */;
INSERT INTO `enfermedades` VALUES (3,2),(4,2),(1,3),(5,4),(2,5);
/*!40000 ALTER TABLE `enfermedades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicamento` (
  `id_medicamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `fecha_caducidad` date DEFAULT NULL,
  PRIMARY KEY (`id_medicamento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
INSERT INTO `medicamento` VALUES (1,'Nekton E','2018-02-18'),(2,'Baycox ','2018-04-20'),(3,'Calcicolina P','2018-05-14'),(4,'Asmoserine','2018-02-28'),(5,'Vitaminas','2018-03-01');
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pajaro`
--

DROP TABLE IF EXISTS `pajaro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pajaro` (
  `id_pajaro` int(11) NOT NULL AUTO_INCREMENT,
  `especie` varchar(25) DEFAULT NULL,
  `sexo` varchar(25) DEFAULT NULL,
  `color` varchar(25) DEFAULT NULL,
  `observaciones` varchar(50) DEFAULT NULL,
  `id_usuario` int(3) DEFAULT NULL,
  `id_pareja` int(3) DEFAULT NULL,
  PRIMARY KEY (`id_pajaro`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_pareja` (`id_pareja`),
  CONSTRAINT `pajaro_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pajaro_ibfk_2` FOREIGN KEY (`id_pareja`) REFERENCES `pajaro` (`id_pajaro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pajaro`
--

LOCK TABLES `pajaro` WRITE;
/*!40000 ALTER TABLE `pajaro` DISABLE KEYS */;
INSERT INTO `pajaro` VALUES (1,'Jilguero','Macho','Amarillo/Negro/Rojo','Macho reproductor',2,NULL),(2,'Jilguero','Hembra','Amarillo/Negro/Rojo','Hembra pasera',2,NULL),(3,'Verderol','Macho','Verde','Pajara de gran tamaño',4,NULL),(4,'Canario','Macho','Rojo','Canario con buen cante',1,NULL),(5,'Canario','Hembra','Amarillo','Canaria cedida',3,NULL);
/*!40000 ALTER TABLE `pajaro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratamiento`
--

DROP TABLE IF EXISTS `tratamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratamiento` (
  `id_tratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `id_enfermedad` int(3) DEFAULT NULL,
  `id_medicamento` int(3) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`id_tratamiento`),
  KEY `id_enfermedad` (`id_enfermedad`),
  KEY `id_medicamento` (`id_medicamento`),
  CONSTRAINT `tratamiento_ibfk_1` FOREIGN KEY (`id_enfermedad`) REFERENCES `enfermedad` (`id_enfermedad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tratamiento_ibfk_2` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratamiento`
--

LOCK TABLES `tratamiento` WRITE;
/*!40000 ALTER TABLE `tratamiento` DISABLE KEYS */;
INSERT INTO `tratamiento` VALUES (1,1,5,'2017-01-17','2017-01-20'),(2,2,2,'2017-01-20','2017-01-22'),(3,3,4,'2017-01-25','2017-01-30'),(4,4,5,'2017-02-02','2017-02-07'),(5,5,1,'2017-02-04','2017-02-09');
/*!40000 ALTER TABLE `tratamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) DEFAULT NULL,
  `apellidos` varchar(25) DEFAULT NULL,
  `edad` int(2) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `contrasenya` varchar(29) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Mauricio','Colmenero Pochetino',53,'666222111','pochemauri@gmail.com','Poxecolme','Bigotes'),(2,'Jose','Hilario Cubel',31,'666010111','josehilario@gmail.com','joseh','Hilario'),(3,'Celia','Llorens Perez',24,'666000112','celialp@gmail.com','celialp','Llorens1104'),(4,'Angel','Hilario Cubel',26,'666111111','anhicu@gmail.com','ahlario','Angel123'),(5,'Pablo','Llorens Perez',20,'666000111','pablollorensperez17@gmail.com','pallope','Hola1725');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-06 13:13:29
