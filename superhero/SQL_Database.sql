DROP DATABASE IF EXISTS superhero;

CREATE DATABASE superhero;

USE superhero;

DROP TABLE IF EXISTS sighting;
DROP TABLE IF EXISTS basicInfo;
DROP TABLE IF EXISTS locationInfo;
DROP TABLE IF EXISTS superpowerInfo;
DROP TABLE IF EXISTS organizationInfo;

CREATE TABLE organizationInfo(
    organizationName VARCHAR(200) PRIMARY KEY,
    info MEDIUMTEXT,
    address MEDIUMTEXT
);

INSERT INTO organizationInfo
VALUES ("ABC", "Home of Gods", "Jurong East St 21"),
	   ("BDC", "Home of SuperGods","Jurong West St 31"),
	   ("RGB", "Heaven of Gods","Bukit Batok St 12");
       
CREATE TABLE superpowerInfo(
    superpower VARCHAR(200) PRIMARY KEY,
    info MEDIUMTEXT
);

INSERT INTO superpowerInfo
VALUES ("Intellect", "Good"),
	   ("Strength", "Great"),
	   ("Nightvision", "Supergood"),
	   ("Sizechange", "Supergreat");
       
CREATE TABLE locationInfo(
    locationName VARCHAR(200) PRIMARY KEY,
    info MEDIUMTEXT,
    address MEDIUMTEXT,
    latitude Decimal(8,6),
    longitude Decimal(9,6)
);

INSERT INTO locationInfo
VALUES ("Swimming complex", "", "Singapore, City Hall", 24.524355, 344.546789),
	   ("Shopping mall", "","Singapore, Raffles Place", 35.946578, 657.654327),
	   ("Restraunt", "","Singapore, Bukit Gombak", 76.654123, 987.625347),
       ("Bowling club", "","Singapore, Tampanies", 87.095467, 154.827634);
       
CREATE TABLE basicInfo(
    heroName VARCHAR(200) PRIMARY KEY,
    info MEDIUMTEXT,
    superpower VARCHAR(200),
    organizationName VARCHAR(200),
	CONSTRAINT FOREIGN KEY FK_organizationName (organizationName)
	REFERENCES organizationInfo (organizationName),
    CONSTRAINT FOREIGN KEY FK_superpower (superpower)
	REFERENCES superpowerInfo (superpower)
);

INSERT INTO basicInfo
VALUES ("Batman", "Helps people", "Intellect", "ABC"),
	   ("Superman", "Big heart", "Strength", "BDC"),
	   ("Spiderman", "Caring", "Nightvision", "BDC"),
	   ("Antman", "Gentle","Sizechange", "RGB"),
	   ("Joker", "Evil", "Intellect", "ABC");
			
CREATE TABLE sighting(
	id INT PRIMARY KEY AUTO_INCREMENT,
    heroName VARCHAR(200),
    locationName VARCHAR(200),
    timedate DATE,
	CONSTRAINT FOREIGN KEY FK_heroName (heroName)
	REFERENCES basicInfo (heroName),
	CONSTRAINT FOREIGN KEY FK_locationName (locationName)
	REFERENCES locationInfo (locationName)
);
UPDATE basicInfo 
SET info = "X", superpower = "Intellect",organizationName = "ABC" 
WHERE heroName = "supergirl";
TABLE basicInfo;
TABLE superpowerInfo;
TABLE locationInfo;
TABLE organizationInfo;