CREATE DATABASE  IF NOT EXISTS `managersoftdata` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `managersoftdata`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: managersoftdata
-- ------------------------------------------------------
-- Server version	5.6.12-log

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
-- Table structure for table `t_activity`
--

DROP TABLE IF EXISTS `t_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_activity` (
  `id_activity` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_kind` int(11) NOT NULL,
  `fk_group` bigint(20) NOT NULL,
  `date_activity` date NOT NULL,
  `start_activity` time NOT NULL,
  `fk_period` int(11) NOT NULL,
  `description_activity` text NOT NULL,
  `image_activity` longblob,
  PRIMARY KEY (`id_activity`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_activity`
--

LOCK TABLES `t_activity` WRITE;
/*!40000 ALTER TABLE `t_activity` DISABLE KEYS */;
INSERT INTO `t_activity` VALUES (1,1,1,'2015-02-26','03:30:00',4,'Teloneros en Vivavo',NULL),(2,1,1,'2015-03-03','03:00:00',2,'villavo party',NULL);
/*!40000 ALTER TABLE `t_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_group`
--

DROP TABLE IF EXISTS `t_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_group` (
  `id_group` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_group` varchar(100) NOT NULL,
  `state_group` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_group`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_group`
--

LOCK TABLES `t_group` WRITE;
/*!40000 ALTER TABLE `t_group` DISABLE KEYS */;
INSERT INTO `t_group` VALUES (1,'Superlitio',1),(2,'Camila',1);
/*!40000 ALTER TABLE `t_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_kind`
--

DROP TABLE IF EXISTS `t_kind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_kind` (
  `id_kind` int(11) NOT NULL AUTO_INCREMENT,
  `name_kind` varchar(35) NOT NULL,
  `state_kind` tinyint(4) NOT NULL,
  `state_image` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_kind`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_kind`
--

LOCK TABLES `t_kind` WRITE;
/*!40000 ALTER TABLE `t_kind` DISABLE KEYS */;
INSERT INTO `t_kind` VALUES (1,'Concierto',1,1),(2,'Prueba de sonido',1,0),(3,'Grabacion',1,0),(4,'Entrevista',1,0),(5,'Ensayo',1,1),(6,'Evento',1,0),(7,'Reunion',1,0),(8,'Evento publicitario',1,0),(9,'Desplazamiento',1,0);
/*!40000 ALTER TABLE `t_kind` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_period`
--

DROP TABLE IF EXISTS `t_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_period` (
  `id_period` int(11) NOT NULL AUTO_INCREMENT,
  `name_period` varchar(55) NOT NULL,
  `val_period` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_period`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_period`
--

LOCK TABLES `t_period` WRITE;
/*!40000 ALTER TABLE `t_period` DISABLE KEYS */;
INSERT INTO `t_period` VALUES (1,'30 Minutos',30),(2,'1 Hora',60),(3,'1 Hora y 30 Minutos',90),(4,'2 Horas',120),(5,'2 Horas y 30 Minutos',150),(6,'3 Horas',180),(7,'4 Horas',240),(8,'5 Horas',300),(9,'6 Horas',360),(10,'1 Dia',720),(11,'2 Dias',1440),(12,'3 Dias',2160),(13,'1 Semana',5040),(14,'2 Semanas',10080),(15,'1 Mes',20160);
/*!40000 ALTER TABLE `t_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_activity`
--

DROP TABLE IF EXISTS `v_activity`;
/*!50001 DROP VIEW IF EXISTS `v_activity`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_activity` (
  `Id` tinyint NOT NULL,
  `fecha_hora` tinyint NOT NULL,
  `actividad` tinyint NOT NULL,
  `grupo` tinyint NOT NULL,
  `duracion` tinyint NOT NULL,
  `descripcion` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_schedule`
--

DROP TABLE IF EXISTS `v_schedule`;
/*!50001 DROP VIEW IF EXISTS `v_schedule`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_schedule` (
  `id` tinyint NOT NULL,
  `actividad` tinyint NOT NULL,
  `grupo` tinyint NOT NULL,
  `fecha_hora` tinyint NOT NULL,
  `duracion` tinyint NOT NULL,
  `fecha_hora_fin` tinyint NOT NULL,
  `estado` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_activity`
--

/*!50001 DROP TABLE IF EXISTS `v_activity`*/;
/*!50001 DROP VIEW IF EXISTS `v_activity`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_activity` AS select `act`.`id_activity` AS `Id`,concat(`act`.`date_activity`,' - ',`act`.`start_activity`) AS `fecha_hora`,`knd`.`name_kind` AS `actividad`,`grp`.`name_group` AS `grupo`,`prd`.`name_period` AS `duracion`,`act`.`description_activity` AS `descripcion` from (((`t_activity` `act` join `t_kind` `knd`) join `t_group` `grp`) join `t_period` `prd`) where ((`knd`.`id_kind` = `act`.`fk_kind`) and (`grp`.`id_group` = `act`.`fk_group`) and (`prd`.`id_period` = `act`.`fk_period`)) group by `act`.`id_activity` order by `act`.`id_activity` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_schedule`
--

/*!50001 DROP TABLE IF EXISTS `v_schedule`*/;
/*!50001 DROP VIEW IF EXISTS `v_schedule`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_schedule` AS select `act`.`id_activity` AS `id`,`knd`.`name_kind` AS `actividad`,`grp`.`name_group` AS `grupo`,concat(`act`.`date_activity`,' ',`act`.`start_activity`) AS `fecha_hora`,`prd`.`name_period` AS `duracion`,(str_to_date(concat(`act`.`date_activity`,' ',`act`.`start_activity`),'%Y-%m-%d %h:%i:%s') + interval `prd`.`val_period` minute) AS `fecha_hora_fin`,(case when (str_to_date(concat(`act`.`date_activity`,' ',`act`.`start_activity`),'%Y-%m-%d %h:%i:%s') > now()) then 1 else 0 end) AS `estado` from (((`t_group` `grp` join `t_activity` `act`) join `t_kind` `knd`) join `t_period` `prd`) where ((`knd`.`id_kind` = `act`.`fk_kind`) and (`grp`.`id_group` = `act`.`fk_group`) and (`prd`.`id_period` = `act`.`fk_period`)) order by `act`.`id_activity` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-28 15:03:39
