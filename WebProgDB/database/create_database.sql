CREATE SCHEMA IF NOT EXISTS `jwts` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `jwts` ;

CREATE  TABLE `kategorija` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE  TABLE `proizvod` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `naziv` VARCHAR(45) NULL ,
  `cena` DECIMAL NULL ,
  `kategorija_id` BIGINT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_kategorija_proizvoda_idx` (`kategorija_id` ASC) ,
  CONSTRAINT `fk_kategorija_proizvoda`
    FOREIGN KEY (`kategorija_id` )
    REFERENCES `jwts`.`kategorija` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
 CREATE TABLE `user` (
 	`id` BIGINT NOT NULL AUTO_INCREMENT, 
 	`username` VARCHAR(45) NULL,
 	`password` VARCHAR(45) NULL,
 	PRIMARY KEY(`id`)
 );
 
 

INSERT INTO `kategorija` (`naziv`) VALUES ('hrana');
INSERT INTO `kategorija` (`naziv`) VALUES ('napitak');
INSERT INTO `kategorija` (`naziv`) VALUES ('odelo');
INSERT INTO `kategorija` (`naziv`) VALUES ('cipele');

INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('mlad grasak', '75', '1');
INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('sok od jabuke', '90', '2');
INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('suncokretovo ulje', '120', '1');
INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('muske cipele', '5000', '4');
INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('muski sako', '7000', '3');
INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('decije sandale', '2500', '4');
INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('sok od narandze', '100', '2');
INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('haljina', '8000', '3');
INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('zenske cipele', '5500', '4');
INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('dzemper', '4000', '3');
INSERT INTO `proizvod` (`naziv`, `cena`, `kategorija_id`) VALUES ('zelena salata', '50', '1');

INSERT INTO `user` (`username`, `password`) VALUES ('pera', 'peric');
INSERT INTO `user` (`username`, `password`) VALUES ('steva', 'stevic');
INSERT INTO `user` (`username`, `password`) VALUES ('milan', 'milanovic');