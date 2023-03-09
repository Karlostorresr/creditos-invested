CREATE DATABASE IF NOT EXISTS `mydb`;
USE `mydb`;

--
-- Table structure for table `client`
--
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `clientID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `last_name` varchar(60) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(75) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `number_of_loans` int DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`clientID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `client`
--
LOCK TABLES `client` WRITE;
INSERT INTO `client` VALUES (24,'Luis Eduardo','Montes Siordia','1990-09-10','LuisEduardo@gmail.com','3384561234',0,'Av Eucalipto 300'),(25,'David','Arredondo Zepeda','1994-09-10','DavidZepeda@gmail.com','3384561234',0,'Av AltaVela'),(26,'Alejandra Estefania','Arredondo Zepeda','1997-10-10','EstefaniaAlejandra@gmail.com','3312361234',0,'Av AltaVela 301'),(27,'Lheilani Estrella','Martinez Hernandez','2000-10-10','LheiEst@gmail.com','5592361234',0,'Miñon 408'),(28,'Pedro Moises','Quintero Duarte','1992-10-10','PedroMoises@gmail.com','6892355234',0,'La paz 15'),(29,'Evelia','Robles Guzman','1967-02-05','eve_55@gmail.com','6142355287',0,'Prolongacion coyoacan 69'),(30,'Rosa Guadalupe','Robles Guzman','1969-07-05','RosaGuz_G@gmail.com','6142355288',0,'Prolongacion coyoacan 69'),(31,'Guillermo','Garibay Torres','1996-02-25','Ranasquesaltan@gmail.com','6142355288',0,'Av. la paz 315'),(32,'Fernanda','Martinez Gutierrez','1998-07-30','fernyazul@gmail.com','9842855288',0,'Av. acueducto  8105'),(33,'Aldahir alejandro','Borquez Perez','1988-12-03','aldajandro@gmail.com','9872655288',0,'calle 3  27'),(34,'Gabriela','Quintero Hernandez','2003-01-06','gabyquintero@gmail.com','9872655288',0,'privada osa mayor 65'),(35,'Javier Francisco','Zabadua Quirarte','1977-01-06','JavierZeb@gmail.com','9873269288',0,'av trafalgar 202');
UNLOCK TABLES;

--
-- Table structure for table `Loan`
--
DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan` (
  `loanID` int NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `payment_plan` int NOT NULL,
  `interest_rate` float NOT NULL,
  `creation_date` date NOT NULL,
  `client_id` int NOT NULL,
  PRIMARY KEY (`loanID`),
  KEY `fk_Credito_Cliente_idx` (`client_id`),
  CONSTRAINT `fk_Credito_Cliente` FOREIGN KEY (`client_id`) REFERENCES `client` (`clientID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `Loan`
--
LOCK TABLES `Loan` WRITE;
INSERT INTO `Loan` VALUES (1,1800,6,0.2,'2023-01-06',24),(2,10000,12,0.2,'2023-01-06',24),(3,10000,12,0.2,'2022-09-12',26),(4,1000,3,0.2,'2023-02-24',27),(5,100000,48,0.2,'2019-07-28',27),(6,500,2,0.2,'2023-03-05',28),(7,6700,6,0.2,'2022-12-10',28),(8,13200,10,0.2,'2022-12-10',28),(9,15000,12,0.2,'2022-04-01',31),(10,1500,3,0.2,'2023-02-28',32),(11,10000,10,0.2,'2022-08-28',33),(12,10000,10,0.2,'2022-08-28',35);
UNLOCK TABLES;

CREATE USER 'creditos_user_api'@'localhost' IDENTIFIED BY 'CredInvesApi102-';
GRANT SELECT, INSERT, DELETE, UPDATE ON mydb.* TO 'creditos_user_api'@'localhost';
FLUSH PRIVILEGES;