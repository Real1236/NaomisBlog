use `blog`;

DROP TABLE IF EXISTS `likes`;

CREATE TABLE `likes` (
  `user_id` int(11) NOT NULL,
  `blogpost_id` int(11) NOT NULL,
  UNIQUE KEY (`user_id`,`blogpost_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`blogpost_id`) REFERENCES `blog-posts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `likes` (`user_id`, `blogpost_id`) 
VALUES (2, 15);