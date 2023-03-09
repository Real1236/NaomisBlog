use `blog`;

DROP TABLE IF EXISTS `user_groups`;
DROP TABLE IF EXISTS `ad_groups`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`username`)
) ENGINE=InnoDB;

INSERT INTO `users` (`username`, `password`)
VALUES ('john', '$2a$12$hMnUTRibdnV8So01.i8JM.kBpXGYF3i1pKCQLxadZmCzke5fvqNne'),
('susan', '$2a$12$hMnUTRibdnV8So01.i8JM.kBpXGYF3i1pKCQLxadZmCzke5fvqNne');	-- password: password123

CREATE TABLE `ad_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_code` varchar(10) DEFAULT NULL,
  `group_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`group_code`)
) ENGINE=InnoDB;

INSERT INTO `ad_groups` (`group_code`, `group_name`) 
VALUES ('blogger', 'blogger group'), ('reader', 'reader group');

CREATE TABLE `user_groups` (
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  UNIQUE KEY (`user_id`,`group_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  FOREIGN KEY (`group_id`) REFERENCES `ad_groups` (`id`)
) ENGINE=InnoDB;

INSERT INTO `user_groups` (`user_id`, `group_id`) 
VALUES (1, 1), (2, 2);

