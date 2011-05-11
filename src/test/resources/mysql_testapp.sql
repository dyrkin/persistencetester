CREATE TABLE IF NOT EXISTS  `CompactDisk` (
  `title` varchar(255) NOT NULL,
  `artist` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO CompactDisk VALUES('Jackson songs', 'Michael Jackson', 'EMI', 'USA', '9.99', '2010');