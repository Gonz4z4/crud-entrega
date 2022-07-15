-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: crud_juegos
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `juegos`
--

DROP TABLE IF EXISTS `juegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juegos` (
  `idjuegos` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `desarrollador` varchar(45) NOT NULL,
  `fechaLanzamiento` date NOT NULL,
  `descripcion` varchar(140) NOT NULL DEFAULT 'Sin descripcion',
  `género` varchar(45) NOT NULL,
  `caratula` longtext,
  `linkCompra` longtext NOT NULL,
  PRIMARY KEY (`idjuegos`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juegos`
--

LOCK TABLES `juegos` WRITE;
/*!40000 ALTER TABLE `juegos` DISABLE KEYS */;
INSERT INTO `juegos` VALUES (1,'Hollow knight','Team cherry','2017-02-24','Juego estilo metroidvania de exploración en un vasto mundo de insectos con combate y plataformeo','Metroidvania','https://www.nintenderos.com/wp-content/uploads/2016/07/Hollow-Knight.jpg','https://store.steampowered.com/app/367520/Hollow_Knight/'),(2,'Crosscode','Radical Fish Games','2018-09-21','Un juego de rol de acción 2D con unos combates de ritmo frenético, puzles y una fascinante historia de ciencia ficción','Action RPG','https://img-eshop.cdn.nintendo.net/i/09c767ac66a33316042ff344ae78e7c966a8fc83ab7ebe0f012292dd0a39c3b8.jpg','https://store.steampowered.com/app/368340/CrossCode/'),(3,'Outer wilds','Mobius Digital','2020-06-18','Outer Wilds es un título de mundo abierto, que se desarrolla en un enigmático sistema solar confinado a un bucle temporal infinito.','Exploración','http://cdn.onlinewebfonts.com/svg/img_222604.png','https://store.steampowered.com/app/753640/Outer_Wilds/');
/*!40000 ALTER TABLE `juegos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-15 19:24:16
