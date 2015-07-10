CREATE TABLE IF NOT EXISTS `tbl_hazelmap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mapkey` varchar(150) DEFAULT NULL,
  `mapValue` blob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `map_key_UNIQUE` (`mapkey`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
