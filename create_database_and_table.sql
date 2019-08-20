DROP DATABASE  `students_database`;
CREATE DATABASE  IF NOT EXISTS `students_database`;


USE `students_database`;


CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


INSERT INTO `students` VALUES 
	(1,'David','Adams','david@gmail.com'),
	(2,'John','Doe','john@gmail.com'),
	(3,'Ajay','Rao','ajay@gmail.com'),
	(4,'Mary','Public','mary@gmail.com'),
	(5,'Maxwell','Dixon','max@gmail.com');