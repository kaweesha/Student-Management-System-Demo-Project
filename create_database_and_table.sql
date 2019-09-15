DROP DATABASE  `students_database`;
CREATE DATABASE  IF NOT EXISTS `students_database`;


USE `students_database`;


CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  `class_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `class_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

INSERT INTO `teachers` VALUES
	(1, 'A. C. Perera', '8A', 'aperera@gmail.com'),
	(2, 'N. P. De Silva', '8B', 'ndesilva@gmail.com');

INSERT INTO `students` VALUES 
	(1,'David','Adams','david@gmail.com','8A'),
	(2,'John','Doe','john@gmail.com','8A'),
	(3,'Ajay','Rao','ajay@gmail.com','8A'),
	(4,'Mary','Public','mary@gmail.com','8B'),
	(5,'Maxwell','Dixon','max@gmail.com','8B');
	(6,'Tony','Bill','t.bill@gmail.com','8B');