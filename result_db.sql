SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `tests`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tests` (
  `test_id` INT NOT NULL AUTO_INCREMENT ,
  `date` TIMESTAMP NULL ,
  `type` INT NULL ,
  `database_type` INT NULL ,
  PRIMARY KEY (`test_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `responses`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `responses` (
  `response_id` INT NOT NULL AUTO_INCREMENT ,
  `test_id` INT NULL ,
  PRIMARY KEY (`response_id`) ,
  INDEX `test_id_idx` (`test_id` ASC) ,
  CONSTRAINT `test_id`
    FOREIGN KEY (`test_id` )
    REFERENCES `tests` (`test_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `responses_parts`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `responses_parts` (
  `responses_part_id` INT NOT NULL AUTO_INCREMENT ,
  `response_id` INT NULL ,
  `array_index` INT NULL ,
  `timevalue` MEDIUMTEXT NULL ,
  PRIMARY KEY (`responses_part_id`) ,
  INDEX `response_id_idx` (`response_id` ASC) ,
  CONSTRAINT `response_id`
    FOREIGN KEY (`response_id` )
    REFERENCES `responses` (`response_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;