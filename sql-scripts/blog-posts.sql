
DROP SCHEMA IF EXISTS `blog`;

CREATE SCHEMA `blog`;

use `blog`;

DROP TABLE IF EXISTS `blog-posts`;

CREATE TABLE `blog-posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `image` mediumblob DEFAULT NULL,
  `blog` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO `blog-posts` (`title`, `date`, `image`, `blog`) VALUES 
('How to Play Chess', '2023-01-01', LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/ChessSet.jpg'), 'Queen go br'),
('How to Play Basketball', '2023-01-01', LOAD_FILE('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/3fede448645bf312358edfd308850570.jpg'), 'Basketball go boing')
-- ('Why does hospital toast taste so good', '2023-01-01', 'Toast goes yum'),
-- ('How to Play Violin', '2023-01-01', 'Violin go eek')