-- MySQL dump 10.13  Distrib 5.7.13, for Win64 (x86_64)
--
-- Host: localhost    Database: weather
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `curweather`
--

DROP TABLE IF EXISTS `curweather`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curweather` (
  `dt` varchar(45) NOT NULL,
  `main` json DEFAULT NULL,
  `weather` json DEFAULT NULL,
  `clouds` json DEFAULT NULL,
  `wind` json DEFAULT NULL,
  `sys` json DEFAULT NULL,
  `future` json DEFAULT NULL,
  PRIMARY KEY (`dt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curweather`
--

LOCK TABLES `curweather` WRITE;
/*!40000 ALTER TABLE `curweather` DISABLE KEYS */;
INSERT INTO `curweather` VALUES ('2016-07-13','{\"temp\": 31.4, \"humidity\": 66, \"pressure\": 1000, \"temp_max\": 33.9, \"temp_min\": 28.9}','{\"id\": 200, \"icon\": \"11d\", \"main\": \"Thunderstorm\", \"description\": \"thunderstorm with light rain\"}','{\"clouds\": 20}','{\"deg\": 360, \"speed\": 3}','{\"pod\": \"CN\"}','{\"0\": [{\"dt\": \"2016-07-13 12:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26.5, \"humidity\": 98, \"pressure\": 1014.7000122070312, \"temp_max\": 26.5, \"temp_min\": 26}, \"wind\": {\"deg\": 77.50029754638672, \"speed\": 1.3300000429153442}, \"clouds\": {\"clouds\": 36}, \"weather\": {\"id\": 501, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"moderate rain\"}}, {\"dt\": \"2016-07-13 15:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26.1, \"humidity\": 96, \"pressure\": 1015.1799926757812, \"temp_max\": 26.1, \"temp_min\": 25.8}, \"wind\": {\"deg\": 223.5070037841797, \"speed\": 0.949999988079071}, \"clouds\": {\"clouds\": 64}, \"weather\": {\"id\": 501, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"moderate rain\"}}], \"1\": [{\"dt\": \"2016-07-13 18:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26.1, \"humidity\": 96, \"pressure\": 1014.2000122070312, \"temp_max\": 26.1, \"temp_min\": 25.9}, \"wind\": {\"deg\": 343, \"speed\": 0.959999978542328}, \"clouds\": {\"clouds\": 56}, \"weather\": {\"id\": 500, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-13 21:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 25.7, \"humidity\": 97, \"pressure\": 1014.2899780273438, \"temp_max\": 25.7, \"temp_min\": 25.6}, \"wind\": {\"deg\": 42.505001068115234, \"speed\": 1.309999942779541}, \"clouds\": {\"clouds\": 36}, \"weather\": {\"id\": 802, \"icon\": \"03n\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-14 00:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 29.1, \"humidity\": 93, \"pressure\": 1015.2000122070312, \"temp_max\": 29.1, \"temp_min\": 29.1}, \"wind\": {\"deg\": 85.50379943847656, \"speed\": 1.919999957084656}, \"clouds\": {\"clouds\": 44}, \"weather\": {\"id\": 802, \"icon\": \"03d\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-14 03:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 32.5, \"humidity\": 85, \"pressure\": 1014.5800170898438, \"temp_max\": 32.5, \"temp_min\": 32.5}, \"wind\": {\"deg\": 194.5039978027344, \"speed\": 1.7699999809265137}, \"clouds\": {\"clouds\": 80}, \"weather\": {\"id\": 803, \"icon\": \"04d\", \"main\": \"Clouds\", \"description\": \"broken clouds\"}}, {\"dt\": \"2016-07-14 06:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 28.1, \"humidity\": 100, \"pressure\": 1014.1099853515624, \"temp_max\": 28.1, \"temp_min\": 28.1}, \"wind\": {\"deg\": 14.50100040435791, \"speed\": 1.0099999904632568}, \"clouds\": {\"clouds\": 76}, \"weather\": {\"id\": 501, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"moderate rain\"}}, {\"dt\": \"2016-07-14 09:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 27.7, \"humidity\": 96, \"pressure\": 1013.6500244140624, \"temp_max\": 27.7, \"temp_min\": 27.7}, \"wind\": {\"deg\": 5.00531005859375, \"speed\": 1.6699999570846558}, \"clouds\": {\"clouds\": 80}, \"weather\": {\"id\": 501, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"moderate rain\"}}, {\"dt\": \"2016-07-14 12:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 27.5, \"humidity\": 94, \"pressure\": 1013.8699951171876, \"temp_max\": 27.5, \"temp_min\": 27.5}, \"wind\": {\"deg\": 92.00140380859376, \"speed\": 1.409999966621399}, \"clouds\": {\"clouds\": 76}, \"weather\": {\"id\": 803, \"icon\": \"04n\", \"main\": \"Clouds\", \"description\": \"broken clouds\"}}, {\"dt\": \"2016-07-14 15:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26, \"humidity\": 98, \"pressure\": 1014.780029296875, \"temp_max\": 26, \"temp_min\": 26}, \"wind\": {\"deg\": 152, \"speed\": 1.809999942779541}, \"clouds\": {\"clouds\": 80}, \"weather\": {\"id\": 501, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"moderate rain\"}}], \"2\": [{\"dt\": \"2016-07-14 18:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26, \"humidity\": 95, \"pressure\": 1013.0900268554688, \"temp_max\": 26, \"temp_min\": 26}, \"wind\": {\"deg\": 170.50399780273438, \"speed\": 1.8200000524520872}, \"clouds\": {\"clouds\": 36}, \"weather\": {\"id\": 500, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-14 21:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26.7, \"humidity\": 92, \"pressure\": 1012.8200073242188, \"temp_max\": 26.7, \"temp_min\": 26.7}, \"wind\": {\"deg\": 226.0050048828125, \"speed\": 3.660000085830689}, \"clouds\": {\"clouds\": 36}, \"weather\": {\"id\": 802, \"icon\": \"03n\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-15 00:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 30.4, \"humidity\": 86, \"pressure\": 1013.530029296875, \"temp_max\": 30.4, \"temp_min\": 30.4}, \"wind\": {\"deg\": 243.00100708007812, \"speed\": 3.559999942779541}, \"clouds\": {\"clouds\": 20}, \"weather\": {\"id\": 801, \"icon\": \"02d\", \"main\": \"Clouds\", \"description\": \"few clouds\"}}, {\"dt\": \"2016-07-15 03:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 32.5, \"humidity\": 77, \"pressure\": 1013.1599731445312, \"temp_max\": 32.5, \"temp_min\": 32.5}, \"wind\": {\"deg\": 261.00201416015625, \"speed\": 5.510000228881836}, \"clouds\": {\"clouds\": 48}, \"weather\": {\"id\": 802, \"icon\": \"03d\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-15 06:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 32.9, \"humidity\": 75, \"pressure\": 1012.22998046875, \"temp_max\": 32.9, \"temp_min\": 32.9}, \"wind\": {\"deg\": 256.0010070800781, \"speed\": 6.46999979019165}, \"clouds\": {\"clouds\": 32}, \"weather\": {\"id\": 802, \"icon\": \"03d\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-15 09:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 30.5, \"humidity\": 78, \"pressure\": 1012.3900146484376, \"temp_max\": 30.5, \"temp_min\": 30.5}, \"wind\": {\"deg\": 272.0010070800781, \"speed\": 6.619999885559082}, \"clouds\": {\"clouds\": 64}, \"weather\": {\"id\": 803, \"icon\": \"04d\", \"main\": \"Clouds\", \"description\": \"broken clouds\"}}, {\"dt\": \"2016-07-15 12:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 27.8, \"humidity\": 82, \"pressure\": 1013.0399780273438, \"temp_max\": 27.8, \"temp_min\": 27.8}, \"wind\": {\"deg\": 270.5050048828125, \"speed\": 5.510000228881836}, \"clouds\": {\"clouds\": 44}, \"weather\": {\"id\": 802, \"icon\": \"03n\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-15 15:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26.4, \"humidity\": 88, \"pressure\": 1013.989990234375, \"temp_max\": 26.4, \"temp_min\": 26.4}, \"wind\": {\"deg\": 295, \"speed\": 4.860000133514404}, \"clouds\": {\"clouds\": 24}, \"weather\": {\"id\": 801, \"icon\": \"02n\", \"main\": \"Clouds\", \"description\": \"few clouds\"}}], \"3\": [{\"dt\": \"2016-07-15 18:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 24.5, \"humidity\": 99, \"pressure\": 1014.0800170898438, \"temp_max\": 24.5, \"temp_min\": 24.5}, \"wind\": {\"deg\": 315.5010070800781, \"speed\": 3.4700000286102295}, \"clouds\": {\"clouds\": 92}, \"weather\": {\"id\": 500, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-15 21:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 23.8, \"humidity\": 100, \"pressure\": 1015.0399780273438, \"temp_max\": 23.8, \"temp_min\": 23.8}, \"wind\": {\"deg\": 326.0050048828125, \"speed\": 2.9100000858306885}, \"clouds\": {\"clouds\": 92}, \"weather\": {\"id\": 500, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-16 00:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 23.7, \"humidity\": 100, \"pressure\": 1016.5800170898438, \"temp_max\": 23.7, \"temp_min\": 23.7}, \"wind\": {\"deg\": 322, \"speed\": 2.6700000762939453}, \"clouds\": {\"clouds\": 92}, \"weather\": {\"id\": 501, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"moderate rain\"}}, {\"dt\": \"2016-07-16 03:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 27.6, \"humidity\": 96, \"pressure\": 1016.72998046875, \"temp_max\": 27.6, \"temp_min\": 27.6}, \"wind\": {\"deg\": 294.5, \"speed\": 2.059999942779541}, \"clouds\": {\"clouds\": 12}, \"weather\": {\"id\": 801, \"icon\": \"02d\", \"main\": \"Clouds\", \"description\": \"few clouds\"}}, {\"dt\": \"2016-07-16 06:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 29.9, \"humidity\": 81, \"pressure\": 1016.010009765625, \"temp_max\": 29.9, \"temp_min\": 29.9}, \"wind\": {\"deg\": 285.5, \"speed\": 3.0999999046325684}, \"clouds\": {\"clouds\": 68}, \"weather\": {\"id\": 803, \"icon\": \"04d\", \"main\": \"Clouds\", \"description\": \"broken clouds\"}}, {\"dt\": \"2016-07-16 09:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 29, \"humidity\": 79, \"pressure\": 1015.6799926757812, \"temp_max\": 29, \"temp_min\": 29}, \"wind\": {\"deg\": 288.50201416015625, \"speed\": 1.659999966621399}, \"clouds\": {\"clouds\": 100}, \"weather\": {\"id\": 804, \"icon\": \"04d\", \"main\": \"Clouds\", \"description\": \"overcast clouds\"}}, {\"dt\": \"2016-07-16 12:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26.6, \"humidity\": 83, \"pressure\": 1017.0399780273438, \"temp_max\": 26.6, \"temp_min\": 26.6}, \"wind\": {\"deg\": 249.50100708007812, \"speed\": 1.8600000143051147}, \"clouds\": {\"clouds\": 68}, \"weather\": {\"id\": 803, \"icon\": \"04n\", \"main\": \"Clouds\", \"description\": \"broken clouds\"}}, {\"dt\": \"2016-07-16 15:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 24.4, \"humidity\": 96, \"pressure\": 1018.1400146484376, \"temp_max\": 24.4, \"temp_min\": 24.4}, \"wind\": {\"deg\": 216.5039978027344, \"speed\": 2.109999895095825}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01n\", \"main\": \"Clear\", \"description\": \"clear sky\"}}], \"4\": [{\"dt\": \"2016-07-16 18:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 23.2, \"humidity\": 98, \"pressure\": 1017.4500122070312, \"temp_max\": 23.2, \"temp_min\": 23.2}, \"wind\": {\"deg\": 144.5, \"speed\": 1.309999942779541}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01n\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-16 21:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 22.5, \"humidity\": 97, \"pressure\": 1017.3800048828124, \"temp_max\": 22.5, \"temp_min\": 22.5}, \"wind\": {\"deg\": 132, \"speed\": 1.3700000047683716}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01n\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-17 00:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 27.3, \"humidity\": 91, \"pressure\": 1018.1599731445312, \"temp_max\": 27.3, \"temp_min\": 27.3}, \"wind\": {\"deg\": 186.0019989013672, \"speed\": 2.1600000858306885}, \"clouds\": {\"clouds\": 24}, \"weather\": {\"id\": 801, \"icon\": \"02d\", \"main\": \"Clouds\", \"description\": \"few clouds\"}}, {\"dt\": \"2016-07-17 03:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 30.9, \"humidity\": 80, \"pressure\": 1018.1300048828124, \"temp_max\": 30.9, \"temp_min\": 30.9}, \"wind\": {\"deg\": 199, \"speed\": 2.8499999046325684}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01d\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-17 06:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 32.9, \"humidity\": 70, \"pressure\": 1016.4000244140624, \"temp_max\": 32.9, \"temp_min\": 32.9}, \"wind\": {\"deg\": 220.00100708007812, \"speed\": 3.1500000953674316}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01d\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-17 09:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 32.8, \"humidity\": 60, \"pressure\": 1015.75, \"temp_max\": 32.8, \"temp_min\": 32.8}, \"wind\": {\"deg\": 250.5039978027344, \"speed\": 3.559999942779541}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01d\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-17 12:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 28.4, \"humidity\": 72, \"pressure\": 1016.4600219726562, \"temp_max\": 28.4, \"temp_min\": 28.4}, \"wind\": {\"deg\": 259.5010070800781, \"speed\": 2.4100000858306885}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01n\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-17 15:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26.2, \"humidity\": 86, \"pressure\": 1016.8900146484376, \"temp_max\": 26.2, \"temp_min\": 26.2}, \"wind\": {\"deg\": 219.50100708007812, \"speed\": 1.5099999904632568}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01n\", \"main\": \"Clear\", \"description\": \"clear sky\"}}]}'),('2016-07-14','{\"temp\": 29, \"humidity\": 94, \"pressure\": 1002, \"temp_max\": 30.6, \"temp_min\": 27}','{\"id\": 800, \"icon\": \"01n\", \"main\": \"Clear\", \"description\": \"clear sky\"}','{\"clouds\": 0}','{\"deg\": -1000, \"speed\": 1}','{\"pod\": \"CN\"}','{\"0\": [{\"dt\": \"2016-07-14 12:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 28.5, \"humidity\": 91, \"pressure\": 1016.5, \"temp_max\": 28.5, \"temp_min\": 25.6}, \"wind\": {\"deg\": 110, \"speed\": 3.6}, \"clouds\": {\"clouds\": 68}, \"weather\": {\"id\": 500, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-14 15:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 28, \"humidity\": 96, \"pressure\": 1016.8, \"temp_max\": 28, \"temp_min\": 25.2}, \"wind\": {\"deg\": 100.5, \"speed\": 1.8}, \"clouds\": {\"clouds\": 88}, \"weather\": {\"id\": 500, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"light rain\"}}], \"1\": [{\"dt\": \"2016-07-14 18:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 27.4, \"humidity\": 98, \"pressure\": 1015.2, \"temp_max\": 27.4, \"temp_min\": 24.7}, \"wind\": {\"deg\": 95.5, \"speed\": 2}, \"clouds\": {\"clouds\": 68}, \"weather\": {\"id\": 500, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-14 21:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 27.4, \"humidity\": 99, \"pressure\": 1014.5, \"temp_max\": 27.4, \"temp_min\": 24.9}, \"wind\": {\"deg\": 127, \"speed\": 2.7}, \"clouds\": {\"clouds\": 80}, \"weather\": {\"id\": 803, \"icon\": \"04n\", \"main\": \"Clouds\", \"description\": \"broken clouds\"}}, {\"dt\": \"2016-07-15 00:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 30.3, \"humidity\": 93, \"pressure\": 1014.9, \"temp_max\": 30.3, \"temp_min\": 28}, \"wind\": {\"deg\": 172, \"speed\": 3}, \"clouds\": {\"clouds\": 76}, \"weather\": {\"id\": 500, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-15 03:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 34.9, \"humidity\": 75, \"pressure\": 1014.1, \"temp_max\": 34.9, \"temp_min\": 32.7}, \"wind\": {\"deg\": 227, \"speed\": 4.8}, \"clouds\": {\"clouds\": 44}, \"weather\": {\"id\": 802, \"icon\": \"03d\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-15 06:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 36, \"humidity\": 72, \"pressure\": 1012.2, \"temp_max\": 36, \"temp_min\": 34}, \"wind\": {\"deg\": 229.5, \"speed\": 5.3}, \"clouds\": {\"clouds\": 68}, \"weather\": {\"id\": 803, \"icon\": \"04d\", \"main\": \"Clouds\", \"description\": \"broken clouds\"}}, {\"dt\": \"2016-07-15 09:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 34.6, \"humidity\": 70, \"pressure\": 1011.8, \"temp_max\": 34.6, \"temp_min\": 32.7}, \"wind\": {\"deg\": 226.5, \"speed\": 4.2}, \"clouds\": {\"clouds\": 44}, \"weather\": {\"id\": 500, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-15 12:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 32.5, \"humidity\": 72, \"pressure\": 1012, \"temp_max\": 32.5, \"temp_min\": 30.8}, \"wind\": {\"deg\": 208.5, \"speed\": 4.9}, \"clouds\": {\"clouds\": 32}, \"weather\": {\"id\": 802, \"icon\": \"03n\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-15 15:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 31.2, \"humidity\": 73, \"pressure\": 1012.5, \"temp_max\": 31.2, \"temp_min\": 29.7}, \"wind\": {\"deg\": 220.5, \"speed\": 6.1}, \"clouds\": {\"clouds\": 20}, \"weather\": {\"id\": 801, \"icon\": \"02n\", \"main\": \"Clouds\", \"description\": \"few clouds\"}}], \"2\": [{\"dt\": \"2016-07-15 18:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 29.5, \"humidity\": 81, \"pressure\": 1012.5, \"temp_max\": 29.5, \"temp_min\": 28.1}, \"wind\": {\"deg\": 261.5, \"speed\": 5.8}, \"clouds\": {\"clouds\": 32}, \"weather\": {\"id\": 802, \"icon\": \"03n\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-15 21:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 25.5, \"humidity\": 98, \"pressure\": 1013.6, \"temp_max\": 25.5, \"temp_min\": 24.2}, \"wind\": {\"deg\": 271.5, \"speed\": 7.3}, \"clouds\": {\"clouds\": 80}, \"weather\": {\"id\": 500, \"icon\": \"10n\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-16 00:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 26.2, \"humidity\": 86, \"pressure\": 1015.5, \"temp_max\": 26.2, \"temp_min\": 25.1}, \"wind\": {\"deg\": 278.5, \"speed\": 8.3}, \"clouds\": {\"clouds\": 92}, \"weather\": {\"id\": 500, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-16 03:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 25.3, \"humidity\": 90, \"pressure\": 1016.6, \"temp_max\": 25.3, \"temp_min\": 24.3}, \"wind\": {\"deg\": 286.5, \"speed\": 5.9}, \"clouds\": {\"clouds\": 92}, \"weather\": {\"id\": 500, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-16 06:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 27.7, \"humidity\": 81, \"pressure\": 1016.8, \"temp_max\": 27.7, \"temp_min\": 27}, \"wind\": {\"deg\": 291.5, \"speed\": 4.6}, \"clouds\": {\"clouds\": 92}, \"weather\": {\"id\": 804, \"icon\": \"04d\", \"main\": \"Clouds\", \"description\": \"overcast clouds\"}}, {\"dt\": \"2016-07-16 09:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 28.2, \"humidity\": 82, \"pressure\": 1017, \"temp_max\": 28.2, \"temp_min\": 27.5}, \"wind\": {\"deg\": 327.5, \"speed\": 2.8}, \"clouds\": {\"clouds\": 88}, \"weather\": {\"id\": 502, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"heavy intensity rain\"}}, {\"dt\": \"2016-07-16 12:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 25.9, \"humidity\": 86, \"pressure\": 1018, \"temp_max\": 25.9, \"temp_min\": 25.4}, \"wind\": {\"deg\": 2, \"speed\": 1.3}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01n\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-16 15:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 23.2, \"humidity\": 95, \"pressure\": 1019, \"temp_max\": 23.2, \"temp_min\": 22.9}, \"wind\": {\"deg\": 118, \"speed\": 1.2}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01n\", \"main\": \"Clear\", \"description\": \"clear sky\"}}], \"3\": [{\"dt\": \"2016-07-16 18:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 21.9, \"humidity\": 96, \"pressure\": 1018.8, \"temp_max\": 21.9, \"temp_min\": 21.8}, \"wind\": {\"deg\": 158, \"speed\": 1.4}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01n\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-16 21:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 20.9, \"humidity\": 96, \"pressure\": 1019.1, \"temp_max\": 20.9, \"temp_min\": 20.9}, \"wind\": {\"deg\": 164, \"speed\": 1.2}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01n\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-17 00:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 27.2, \"humidity\": 89, \"pressure\": 1020.1, \"temp_max\": 27.2, \"temp_min\": 27.2}, \"wind\": {\"deg\": 189.5, \"speed\": 2.1}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01d\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-17 03:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 30.9, \"humidity\": 79, \"pressure\": 1019.4, \"temp_max\": 30.9, \"temp_min\": 30.9}, \"wind\": {\"deg\": 173, \"speed\": 3.1}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01d\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-17 06:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 32.1, \"humidity\": 71, \"pressure\": 1018, \"temp_max\": 32.1, \"temp_min\": 32.1}, \"wind\": {\"deg\": 170.5, \"speed\": 4}, \"clouds\": {\"clouds\": 0}, \"weather\": {\"id\": 800, \"icon\": \"01d\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-17 09:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 31.1, \"humidity\": 70, \"pressure\": 1017.3, \"temp_max\": 31.1, \"temp_min\": 31.1}, \"wind\": {\"deg\": 163, \"speed\": 4.7}, \"clouds\": {\"clouds\": 8}, \"weather\": {\"id\": 800, \"icon\": \"02d\", \"main\": \"Clear\", \"description\": \"clear sky\"}}, {\"dt\": \"2016-07-17 12:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 27.4, \"humidity\": 82, \"pressure\": 1018.2, \"temp_max\": 27.4, \"temp_min\": 27.4}, \"wind\": {\"deg\": 146.5, \"speed\": 4.7}, \"clouds\": {\"clouds\": 32}, \"weather\": {\"id\": 802, \"icon\": \"03n\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-17 15:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26.1, \"humidity\": 93, \"pressure\": 1018, \"temp_max\": 26.1, \"temp_min\": 26.1}, \"wind\": {\"deg\": 137.5, \"speed\": 4}, \"clouds\": {\"clouds\": 44}, \"weather\": {\"id\": 802, \"icon\": \"03n\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}], \"4\": [{\"dt\": \"2016-07-17 18:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 25.9, \"humidity\": 96, \"pressure\": 1016.6, \"temp_max\": 25.9, \"temp_min\": 25.9}, \"wind\": {\"deg\": 142.5, \"speed\": 3.3}, \"clouds\": {\"clouds\": 36}, \"weather\": {\"id\": 802, \"icon\": \"03n\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-17 21:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 25.6, \"humidity\": 96, \"pressure\": 1016, \"temp_max\": 25.6, \"temp_min\": 25.6}, \"wind\": {\"deg\": 183, \"speed\": 2.1}, \"clouds\": {\"clouds\": 48}, \"weather\": {\"id\": 802, \"icon\": \"03n\", \"main\": \"Clouds\", \"description\": \"scattered clouds\"}}, {\"dt\": \"2016-07-18 00:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 27.6, \"humidity\": 92, \"pressure\": 1016.5, \"temp_max\": 27.6, \"temp_min\": 27.6}, \"wind\": {\"deg\": 243, \"speed\": 2.2}, \"clouds\": {\"clouds\": 44}, \"weather\": {\"id\": 500, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-18 03:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 29, \"humidity\": 88, \"pressure\": 1016.3, \"temp_max\": 29, \"temp_min\": 29}, \"wind\": {\"deg\": 265.5, \"speed\": 2.9}, \"clouds\": {\"clouds\": 44}, \"weather\": {\"id\": 500, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-18 06:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 31.5, \"humidity\": 84, \"pressure\": 1013.8, \"temp_max\": 31.5, \"temp_min\": 31.5}, \"wind\": {\"deg\": 283.5, \"speed\": 2.8}, \"clouds\": {\"clouds\": 24}, \"weather\": {\"id\": 500, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"light rain\"}}, {\"dt\": \"2016-07-18 09:00:00\", \"sys\": {\"pod\": \"d\"}, \"main\": {\"temp\": 29.6, \"humidity\": 89, \"pressure\": 1014, \"temp_max\": 29.6, \"temp_min\": 29.6}, \"wind\": {\"deg\": 299, \"speed\": 1.9}, \"clouds\": {\"clouds\": 20}, \"weather\": {\"id\": 501, \"icon\": \"10d\", \"main\": \"Rain\", \"description\": \"moderate rain\"}}, {\"dt\": \"2016-07-18 12:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 27.7, \"humidity\": 89, \"pressure\": 1014.8, \"temp_max\": 27.7, \"temp_min\": 27.7}, \"wind\": {\"deg\": 355, \"speed\": 1.7}, \"clouds\": {\"clouds\": 64}, \"weather\": {\"id\": 803, \"icon\": \"04n\", \"main\": \"Clouds\", \"description\": \"broken clouds\"}}, {\"dt\": \"2016-07-18 15:00:00\", \"sys\": {\"pod\": \"n\"}, \"main\": {\"temp\": 26.4, \"humidity\": 92, \"pressure\": 1015.3, \"temp_max\": 26.4, \"temp_min\": 26.4}, \"wind\": {\"deg\": 44.5, \"speed\": 0.3}, \"clouds\": {\"clouds\": 68}, \"weather\": {\"id\": 803, \"icon\": \"04n\", \"main\": \"Clouds\", \"description\": \"broken clouds\"}}]}');
/*!40000 ALTER TABLE `curweather` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-14 21:24:02
