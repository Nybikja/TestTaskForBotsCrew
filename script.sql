use mydb;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`degree`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`degree` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`department` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`lector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`lector` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `degree_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKgl1ov1mr5r06n5eikvwla30f1` (`degree_id` ASC) VISIBLE,
  CONSTRAINT `FKgl1ov1mr5r06n5eikvwla30f1`
    FOREIGN KEY (`degree_id`)
    REFERENCES `mydb`.`degree` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`department_lector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`department_lector` (
  `department_id` BIGINT NOT NULL,
  `lector_id` BIGINT NOT NULL,
  `salary` INT NULL DEFAULT NULL,
  PRIMARY KEY (`department_id`, `lector_id`),
  INDEX `fk_department_has_lector_lector1_idx` (`lector_id` ASC) VISIBLE,
  INDEX `fk_department_has_lector_department1_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `fk_department_has_lector_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `mydb`.`department` (`id`),
  CONSTRAINT `fk_department_has_lector_lector1`
    FOREIGN KEY (`lector_id`)
    REFERENCES `mydb`.`lector` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




insert into degree values (1, "assistant");
insert into degree values (2, "associate");
insert into degree values (3, "professor");
insert into degree values (4, "head_of_department");

insert into lector values (1, "Vasyl Petrovych", 4);
insert into lector values (2, "Nazar Vashchyshyn", 3);
insert into lector values (3, "Nazarii Vashchyshyn", 1);
insert into lector values (4, "Stepan Pavelchak", 4);
insert into lector values (5, "Veres Pavelchak", 2);
insert into lector values (6, "Zenovii Veres", 1);
insert into lector values (7, "Zenovii Pavelchak", 3);
insert into lector values (8, "Stepan Veres", 4);


insert into department values (1, "LvivPolytechnic");
insert into department values (2, "UCU");
insert into department values (3, "LNU");

insert into department_lector values (1, 1, 300);
insert into department_lector values (1, 2, 400);
insert into department_lector values (1, 3, 300);
insert into department_lector values (1, 5, 100);
insert into department_lector values (1, 6, 1000);
insert into department_lector values (1, 7, 220);
insert into department_lector values (2, 1, 500);
insert into department_lector values (3, 4, 660);
insert into department_lector values (3, 6, 462);
insert into department_lector values (2, 7, 50);
insert into department_lector values (2, 8, 123);



select distinct lector.id, lector.name, degree.name
	from department_lector 
    join lector on department_lector.lector_id = lector.id 
    join department on department_lector.department_id = department.id
    join degree on lector.degree_id = degree.id 
    where degree.id = 4 and department.name= "Lviv Polytechnic";
    
select distinct Count(lector.id)
	from department_lector 
    join lector on department_lector.lector_id = lector.id 
    join department on department_lector.department_id = department.id
    join degree on lector.degree_id = degree.id 
    where degree.id = 4 and department.name= "Lviv Polytechnic";
    
select  avg(department_lector.salary)
	from department_lector
    join lector on department_lector.lector_id = lector.id 
    join department on department_lector.department_id = department.id
    where department.name= "LNU";

