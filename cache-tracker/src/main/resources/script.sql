CREATE TABLE IF NOT EXISTS `tbl_hazelmap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_key` varchar(255) DEFAULT NULL,
  `map_value` blob,
  `map_name` varchar(60) DEFAULT 'jobTracker',
  PRIMARY KEY (`id`),
  UNIQUE KEY `map_key_name_UNIQUE` (`map_key`,`map_name`),
  KEY `map_name_idx` (`map_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
