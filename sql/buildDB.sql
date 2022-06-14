-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema a2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema a2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `a2` DEFAULT CHARACTER SET utf8 ;
USE `a2` ;

-- -----------------------------------------------------
-- Table `a2`.`Parts291`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `a2`.`Parts291` (
  `partNo291` INT NOT NULL,
  `partName291` VARCHAR(45) NULL,
  `partPrice291` DOUBLE NULL,
  `qoh291` INT NULL,
  PRIMARY KEY (`partNo291`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `a2`.`Clients291`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `a2`.`Clients291` (
  `clientId291` INT NOT NULL,
  `clientName291` VARCHAR(45) NULL,
  `clientCity291` VARCHAR(45) NULL,
  `clientPassword291` VARCHAR(45) NULL,
  `moneyOwed291` VARCHAR(45) NULL,
  PRIMARY KEY (`clientId291`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `a2`.`POs291`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `a2`.`POs291` (
  `poNo291` INT NOT NULL,
  `clientCompID291` INT NOT NULL,
  `dateOfPO291` DATE NULL,
  `status291` VARCHAR(45) NULL,
  PRIMARY KEY (`poNo291`, `clientCompID291`),
  INDEX `fk_POs_client291_idx` (`clientCompID291` ASC) VISIBLE,
  CONSTRAINT `fk_POs_client291`
    FOREIGN KEY (`clientCompID291`)
    REFERENCES `a2`.`Clients291` (`clientId291`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `a2`.`Lines291`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `a2`.`Lines291` (
  `poNo291` INT NOT NULL,
  `lineNo291` INT NULL,
  `partNo291` INT NOT NULL,
  `qty291` INT NOT NULL,
  `priceOrdered291` DOUBLE NULL,
  PRIMARY KEY (`poNo291`, `partNo291`),
  INDEX `fk_line291_parts2911_idx` (`partNo291` ASC) VISIBLE,
  INDEX `fk_line291_POs2911_idx` (`poNo291` ASC) VISIBLE,
  CONSTRAINT `fk_line291_parts2911`
    FOREIGN KEY (`partNo291`)
    REFERENCES `a2`.`Parts291` (`partNo291`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_line291_POs2911`
    FOREIGN KEY (`poNo291`)
    REFERENCES `a2`.`POs291` (`poNo291`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
