DROP TABLE IF EXISTS EXAMRESULTS ;

CREATE TABLE IF NOT exists EXAMRESULTS (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject1` int(11) DEFAULT NULL,
  `subject2` int(11) DEFAULT NULL,
  `subject3` int(11) DEFAULT NULL,
  `subject4` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `EXAMRESULTS`
(`subject1`,
`subject2`,
`subject3`,
`subject4`)
VALUES
(330,20,30,40);


INSERT INTO `EXAMRESULTS`
(`subject1`,
`subject2`,
`subject3`,
`subject4`)
VALUES
(5,4,7,99);



INSERT INTO `EXAMRESULTS`
(`subject1`,
`subject2`,
`subject3`,
`subject4`)
VALUES
(12,24,44,88);




DROP TABLE IF EXISTS TARGETTABLE ;

CREATE TABLE IF NOT EXISTS TARGETTABLE (
 `id` int(11) NOT NULL AUTO_INCREMENT,
  `maxmumValue` int(11) DEFAULT NULL,
  `sumofRow` int(11) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
