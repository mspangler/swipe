CREATE TABLE `swipe`.`user` (
  `Id` INT  NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(250)  NOT NULL,
  `Email` VARCHAR(100)  NOT NULL,
  PRIMARY KEY (`Id`)
)
ENGINE = InnoDB;
    
CREATE TABLE `swipe`.`location` (
  `Id` INT  NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(250)  NOT NULL,
  `Address` VARCHAR(250) ,
  `Latitude` VARCHAR(50) ,
  `Longitude` VARCHAR(50) ,
  `SIC` VARCHAR(4)  NOT NULL,
  `Preferred` BOOLEAN  NOT NULL,
  PRIMARY KEY (`Id`)
)
ENGINE = InnoDB;

CREATE TABLE `swipe`.`reward` (
  `Id` INT  NOT NULL,
  `Name` VARCHAR(50)  NOT NULL
)
ENGINE = InnoDB;

CREATE TABLE `swipe`.`transaction` (
  `Id` INT(11)  NOT NULL AUTO_INCREMENT,
  `UserId` INT  NOT NULL,
  `AccountNumber` VARCHAR(11)  NOT NULL,
  `LocationId` INT  NOT NULL,
  `Amount` DECIMAL  NOT NULL,
  `EnteredDate` TIMESTAMP  NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `user_fk_constraint` FOREIGN KEY `user_fk_constraint` (`UserId`)
    REFERENCES `user` (`Id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `location_fk_constraint` FOREIGN KEY `location_fk_constraint` (`LocationId`)
    REFERENCES `location` (`Id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
ENGINE = InnoDB;

CREATE TABLE `swipe`.`user_reward` (
  `Id` INT  NOT NULL AUTO_INCREMENT,
  `UserId` INT  NOT NULL,
  `RewardId` INT  NOT NULL,
  `LocationId` INT  NOT NULL,
  `Amount` INT  NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `user_fk_constraint` FOREIGN KEY `user_fk_constraint` (`UserId`)
    REFERENCES `user` (`Id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `reward_fk_constraint` FOREIGN KEY `reward_fk_constraint` (`RewardId`)
    REFERENCES `reward` (`Id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `location_fk_constraint` FOREIGN KEY `location_fk_constraint` (`LocationId`)
    REFERENCES `location` (`Id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)
ENGINE = InnoDB;

CREATE TABLE `swipe`.`user_reward` (
  `Id` INT  NOT NULL AUTO_INCREMENT,
  `UserId` INT  NOT NULL,
  `RewardId` INT  NOT NULL,
  `LocationId` INT  NOT NULL,
  `Amount` INT  NOT NULL,
  `DateEntered` TIMESTAMP  NOT NULL,
  PRIMARY KEY (`Id`)
)
ENGINE = InnoDB;

CREATE TABLE `swipe`.`notification` (
  `Id` INT  NOT NULL AUTO_INCREMENT,
  `UserId` INT  NOT NULL,
  `TypeId` INT  NOT NULL,
  `DateEntered` TIMESTAMP  NOT NULL,
  PRIMARY KEY (`Id`)
)
ENGINE = InnoDB;

