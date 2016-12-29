MySQL Flight Table:

CREATE TABLE flights (
    FlightId int(10) NOT NULL AUTO_INCREMENT,
    Origin varchar(255) NOT NULL,
    Destination varchar(255) NOT NULL,
    DepartPrice varchar(10) DEFAULT NULL,
    ReturnPrice varchar(10) DEFAULT NULL,
    Price varchar(10) DEFAULT NULL,
    DepartTime varchar(10) DEFAULT NULL,
    ReturnTime varchar(10) DEFAULT NULL,
    PRIMARY KEY (FlightId)
  ) ENGINE=InnoDB;
