
delimiter $$

CREATE TABLE `t_articles` (
  `id` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content_path` varchar(100) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `t_messages` (
  `id` int(11) NOT NULL,
  `send_name` varchar(45) DEFAULT NULL,
  `receive_name` varchar(45) DEFAULT NULL,
  `message` text,
  `create_time` datetime DEFAULT NULL,
  `isread` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


delimiter $$

CREATE TABLE `t_photos` (
  `id` int(11) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `small_path` varchar(100) DEFAULT NULL,
  `photo_name` varchar(45) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `file_name` varchar(45) DEFAULT NULL,
  `big_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `t_users` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password_md5` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `imagedir` varchar(70) DEFAULT NULL,
  `filedir` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


delimiter $$

CREATE TABLE `t_websites` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `site_name` varchar(100) DEFAULT NULL,
  `website` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

