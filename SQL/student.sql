CREATE DATABASE  IF NOT EXISTS `library`;
USE `library`;



DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


INSERT INTO `student` VALUES 
	(1,'David','CSE','USA'),
	(2,'Maxwell','ECE','India'),
	(3,'John','EEE','UK'),
	(4,'Mary','EIE','India'),
	(5,'Ajay','EEE','India');

commit;