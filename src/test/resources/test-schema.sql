CREATE TABLE `user`
(
  `id`   int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100)     NOT NULL,
  `AGE`  int(10) unsigned NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
