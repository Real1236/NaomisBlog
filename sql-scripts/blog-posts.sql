-- DROP SCHEMA IF EXISTS `blog`;

-- CREATE SCHEMA `blog`;

use `blog`;

DROP TABLE IF EXISTS `blog-posts`;

CREATE TABLE `blog-posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `blog` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;