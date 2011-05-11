CREATE TABLE CompactDisk (
  title varchar(255) PRIMARY KEY,
  artist varchar(255) DEFAULT NULL,
  company varchar(255) DEFAULT NULL,
  country varchar(255) DEFAULT NULL,
  price float8 DEFAULT NULL,
  year integer DEFAULT NULL
);

INSERT INTO CompactDisk VALUES('Jackson songs', 'Michael Jackson', 'EMI', 'USA', '9.99', '2010');
