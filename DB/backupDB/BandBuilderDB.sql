-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bandbuilderdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bandbuilderdb` ;

-- -----------------------------------------------------
-- Schema bandbuilderdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bandbuilderdb` DEFAULT CHARACTER SET utf8 ;
USE `bandbuilderdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(1000) NOT NULL,
  `password` VARCHAR(1000) NOT NULL,
  `active` TINYINT NOT NULL,
  `role` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(1000) NULL,
  `street_2` VARCHAR(1000) NULL,
  `city` VARCHAR(100) NOT NULL,
  `state` VARCHAR(100) NOT NULL,
  `zip` INT NOT NULL,
  `phone` INT NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `image` ;

CREATE TABLE IF NOT EXISTS `image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(2000) NOT NULL,
  `alt` TEXT(1000) NULL,
  `description` TEXT(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `profile` ;

CREATE TABLE IF NOT EXISTS `profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(200) NOT NULL,
  `last_name` VARCHAR(200) NULL,
  `email` VARCHAR(1000) NOT NULL,
  `about_me` TEXT(1000) NULL,
  `address_id` INT NOT NULL,
  `image_id` INT NOT NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Profile_address1_idx` (`address_id` ASC),
  INDEX `fk_Profile_image1_idx` (`image_id` ASC),
  INDEX `fk_Profile_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_Profile_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profile_address_id`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profile_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instrument`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `instrument` ;

CREATE TABLE IF NOT EXISTS `instrument` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(300) NOT NULL,
  `approved` TINYINT NOT NULL,
  `image_id` INT NULL,
  `description` TEXT(1000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_instrument_image1_idx` (`image_id` ASC),
  CONSTRAINT `fk_image_instrument_id`
    FOREIGN KEY (`image_id`)
    REFERENCES `image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `band`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `band` ;

CREATE TABLE IF NOT EXISTS `band` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `about_us` TEXT(1000) NULL,
  `genre` VARCHAR(200) NULL,
  `address_id` INT NOT NULL,
  `leader_id` INT NOT NULL,
  `email` VARCHAR(1000) NOT NULL,
  `time_commitment` VARCHAR(200) NULL,
  `updated_at` DATETIME NULL,
  `created_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_id_idx` (`address_id` ASC),
  INDEX `fk_band_Profile1_idx` (`leader_id` ASC),
  CONSTRAINT `fk_band_address_id`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_band_Profile1`
    FOREIGN KEY (`leader_id`)
    REFERENCES `profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `band_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `band_member` ;

CREATE TABLE IF NOT EXISTS `band_member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `band_id` INT NOT NULL,
  `instrument_id` INT NOT NULL,
  `profile_id` INT NULL,
  `description` TEXT(1000) NOT NULL,
  `experience` TEXT(1000) NOT NULL,
  `created_at` DATETIME NULL,
  `joined_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_band_member_instrument1_idx` (`instrument_id` ASC),
  INDEX `fk_band_member_Profile1_idx` (`profile_id` ASC),
  INDEX `fk_band_member_band1_idx` (`band_id` ASC),
  CONSTRAINT `fk_band_member_instrument1`
    FOREIGN KEY (`instrument_id`)
    REFERENCES `instrument` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_band_member_Profile1`
    FOREIGN KEY (`profile_id`)
    REFERENCES `profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_band_member_band1`
    FOREIGN KEY (`band_id`)
    REFERENCES `band` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_media`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_media` ;

CREATE TABLE IF NOT EXISTS `social_media` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `image_url` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `band_image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `band_image` ;

CREATE TABLE IF NOT EXISTS `band_image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `band_id` INT NOT NULL,
  `image_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_band_image_band1_idx` (`band_id` ASC),
  INDEX `fk_band_image_image1_idx` (`image_id` ASC),
  CONSTRAINT `fk_band_image_band1`
    FOREIGN KEY (`band_id`)
    REFERENCES `band` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_band_image_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `band_social_media`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `band_social_media` ;

CREATE TABLE IF NOT EXISTS `band_social_media` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `social_media_id` INT NOT NULL,
  `band_id` INT NOT NULL,
  `url` VARCHAR(2000) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_band_social_media_band1_idx` (`band_id` ASC),
  INDEX `fk_band_social_media_social_media1_idx` (`social_media_id` ASC),
  CONSTRAINT `fk_band_social_media_band1`
    FOREIGN KEY (`band_id`)
    REFERENCES `band` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_band_social_media_social_media1`
    FOREIGN KEY (`social_media_id`)
    REFERENCES `social_media` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_instrument`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_instrument` ;

CREATE TABLE IF NOT EXISTS `user_instrument` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profile_id` INT NOT NULL,
  `instrument_id` INT NOT NULL,
  `experience` TEXT(1000) NOT NULL,
  `description` TEXT(1000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_instrument_Profile1_idx` (`profile_id` ASC),
  INDEX `fk_user_instrument_instrument1_idx` (`instrument_id` ASC),
  CONSTRAINT `fk_user_instrument_Profile1`
    FOREIGN KEY (`profile_id`)
    REFERENCES `profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_instrument_instrument1`
    FOREIGN KEY (`instrument_id`)
    REFERENCES `instrument` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NOT NULL,
  `band_id` INT NOT NULL,
  `description` TEXT(1000) NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_address1_idx` (`address_id` ASC),
  INDEX `fk_event_band1_idx` (`band_id` ASC),
  CONSTRAINT `fk_event_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_band1`
    FOREIGN KEY (`band_id`)
    REFERENCES `band` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS banduser;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'banduser' IDENTIFIED BY 'bandpass';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'banduser';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`) VALUES (1, 'rocker', 'rocker1', 1, 'user');
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`) VALUES (2, 'pianoPro', 'pianoPro1', 1, 'user');
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`) VALUES (3, 'guitarest', 'guitarest1', 1, 'user');
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`) VALUES (4, 'drummer', 'drumer1', 1, 'user');
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`) VALUES (5, 'bassest', 'bassest1', 1, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`) VALUES (1, '123 Colorado Drive ', NULL, 'Denver', 'Colorado', 80220, 7201234567, '2019-04-01 23:08:48', '2019-04-01 23:08:48');
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`) VALUES (2, '456 Broadway Drive', NULL, 'Denver', 'Colorado', 80202, 3035461111, '2019-04-08 23:08:48', '2019-04-08 23:08:48');
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`) VALUES (3, '20965 Aurora Parkway', NULL, 'Aurora', 'Colorado', 80011, 3035231234, '2019-04-08 23:18:48', '2019-04-08 23:18:48');
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`) VALUES (4, '1303 Colfax Avenue', NULL, 'Denver', 'Colorado', 80212, 7203256070, '2019-04-09 23:18:48', '2019-04-09 23:18:48');
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`) VALUES (5, '3060 Main Street', NULL, 'Parker', 'Colorado', 80108, 3035046423, '2019-04-09 23:18:48', '2019-04-09 23:18:48');
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`) VALUES (6, '15054 Halifax Way', NULL, 'Littleton', 'Colorado', 80121, 7205556743, '2019-04-10 22:38:48', '2019-04-10 22:38:48');
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`) VALUES (7, '3317 E Colfax Ave', NULL, 'Denver', 'Colordo', 80226, 3033771666, '2019-04-11 09:38:48', '2019-04-11 09:38:48');

COMMIT;


-- -----------------------------------------------------
-- Data for table `image`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (1, 'http://electricguitarhub.com/wp-content/uploads/2014/07/Best-guitarists-to-learn-from-tommy-.png', 'justin the guitarest image', 'This is an image of Justin the Guitarest');
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (2, 'https://bestdigitalpianoguides.com/wp-content/uploads/2016/01/Learn-to-play-digital-piano-quickly.jpg', 'selena the pianest', 'This is an image of Selena at one of the practice sessions');
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3R-yXJFW6Yc5jdMNHENe041nrbvZQZNRsHiE9rzHr65PVuWOF', 'Steve', 'This is an image of Steve that plays');
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (4, 'http://www.jewcy.com/wp-content/uploads/2011/02/2.jpg', 'Rachel', 'This is an image of a standard drum set.');
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (5, 'https://i.ytimg.com/vi/7PgnbtWvp4o/maxresdefault.jpg', 'Matthew', 'This is an image of Matthew playing the bass.');
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (6, 'https://media.musiciansfriend.com/is/image/MMGS7/2018-L-00-Standard-Acoustic-Electric-Guitar-Vintage-Sunburst/K45486000001000-00-500x500.jpg', 'generic guitar', 'This is an image a standard guitar');
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (7, 'https://www.colinbattremovals.co.uk/wp-content/uploads/2015/03/Bosendorfer-Imperial-Concert-Grand-Flagship-Model-290-Imperial.jpg', 'generic piano', 'This is an image of a standard piano');
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (8, 'https://www.liveandlearn.com/shop/images/products/8867.jpg', 'generic electric guitar', 'This is an image of an electric guitar');
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (9, 'https://worthly.com/wp-content/uploads/2015/08/Most-Expensive-Drum-Kits.png', 'generic drum set', 'This is an image of a drum set');
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (10 , 'data:image/jpeg;base64,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', 'generic bass guitar', 'This is an image of a bass guitar');
INSERT INTO `image` (`id`, `url`, `alt`, `description`) VALUES (11, 'https://cdn.mos.cms.futurecdn.net/wpEgipYD7TJYpuYvbb3mi-320-80.jpg', 'generic band ', 'This is an image of a band at practice');

COMMIT;


-- -----------------------------------------------------
-- Data for table `profile`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about_me`, `address_id`, `image_id`, `created_at`, `updated_at`, `user_id`) VALUES (1, 'justin ', 'blake', 'biebs@gmail.com', 'I have played the guitar since I was a small boy. My first guitar was gifted to me by my grandfather who was also a guitarest. ', 1, 1, '2019-04-01 22:08:48', '2019-04-14 22:08:48', 1);
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about_me`, `address_id`, `image_id`, `created_at`, `updated_at`, `user_id`) VALUES (2, 'selena', 'smith', 'selena20@gmail.com', 'I have been playing the piano for quite sometime. ', 2, 2, '2019-04-08 22:08:48', '2019-04-04 22:08:48', 2);
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about_me`, `address_id`, `image_id`, `created_at`, `updated_at`, `user_id`) VALUES (3, 'steve', 'jackson', 'stevejackson@gmail.com', 'I can play the electric guitar very well. Enjoy teaching others build their talent skills. ', 3, 3, '2019-04-08 23:18:48', '2019-04-08 23:18:48', 3);
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about_me`, `address_id`, `image_id`, `created_at`, `updated_at`, `user_id`) VALUES (4, 'rachel', 'chelsea', 'rachelchelsea@gmail.com', 'I can play the drums.', 4, 4, '2019-04-09 23:18:48', '2019-04-09 23:18:48', 4);
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about_me`, `address_id`, `image_id`, `created_at`, `updated_at`, `user_id`) VALUES (5, 'matthew', 'adams', 'matthewadams@gmail.com', 'I can play the bass. I typically play at my local church on Sundays. ', 5, 5, '2019-04-10 02:18:48', '2019-04-10 02:18:48', 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `instrument`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `instrument` (`id`, `name`, `approved`, `image_id`, `description`) VALUES (1, 'guitar', 1, 6, 'This is a guitar');
INSERT INTO `instrument` (`id`, `name`, `approved`, `image_id`, `description`) VALUES (2, 'piano', 1, 7, 'This is a piano');
INSERT INTO `instrument` (`id`, `name`, `approved`, `image_id`, `description`) VALUES (3, 'electric guitar', 1, 8, 'This is a electric guitar');
INSERT INTO `instrument` (`id`, `name`, `approved`, `image_id`, `description`) VALUES (4, 'drums', 1, 9, 'This is a drums');
INSERT INTO `instrument` (`id`, `name`, `approved`, `image_id`, `description`) VALUES (5, 'bass guitar', 1, 10, 'This is a bass guitar');

COMMIT;


-- -----------------------------------------------------
-- Data for table `band`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `band` (`id`, `name`, `about_us`, `genre`, `address_id`, `leader_id`, `email`, `time_commitment`, `updated_at`, `created_at`) VALUES (1, 'Piss-ant Graphite', 'What starts out as yearning soon becomes manipulated into a carnival of distress, leaving only a sense of unreality and the chance of a new synthesis.', 'Rock', 6, 1, 'thegarageband@gmail.com', 'Test', '2019-04-01 22:38:48', '2019-04-01 22:38:48');

COMMIT;


-- -----------------------------------------------------
-- Data for table `band_member`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `band_member` (`id`, `band_id`, `instrument_id`, `profile_id`, `description`, `experience`, `created_at`, `joined_at`) VALUES (1, 1, 1, 1, 'This is the lead Guitar Player', 'Expert', '2019-04-01 22:38:48', '2019-04-01 22:38:48');
INSERT INTO `band_member` (`id`, `band_id`, `instrument_id`, `profile_id`, `description`, `experience`, `created_at`, `joined_at`) VALUES (2, 1, 2, 2, 'This is the lead piano player ', 'Expert', '2019-04-01 22:48:48', '2019-04-01 22:48:48');
INSERT INTO `band_member` (`id`, `band_id`, `instrument_id`, `profile_id`, `description`, `experience`, `created_at`, `joined_at`) VALUES (3, 1, 3, 3, 'This is the electric guitar player', 'Intermidiate', '2019-04-01 22:58:48', '2019-04-01 22:58:48');
INSERT INTO `band_member` (`id`, `band_id`, `instrument_id`, `profile_id`, `description`, `experience`, `created_at`, `joined_at`) VALUES (4, 1, 4, 4, 'This is the Drummer', 'Intermidiate', '2019-04-01 23:08:48', '2019-04-01 23:08:48');
INSERT INTO `band_member` (`id`, `band_id`, `instrument_id`, `profile_id`, `description`, `experience`, `created_at`, `joined_at`) VALUES (5, 1, 5, 5, 'This is the Bass guitar player', 'Intermidiate', '2019-04-01 23:18:48', '2019-04-01 23:18:48');

COMMIT;


-- -----------------------------------------------------
-- Data for table `social_media`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `social_media` (`id`, `name`, `image_url`) VALUES (1, 'facebook ', 'http://cofarming.info/wp-content/uploads/2017/01/facebook-icon-preview-1-400x400.png');
INSERT INTO `social_media` (`id`, `name`, `image_url`) VALUES (2, 'twitter', 'https://instagram-brand.com/wp-content/uploads/2016/11/Instagram_AppIcon_Aug2017.png?w=300');

COMMIT;


-- -----------------------------------------------------
-- Data for table `band_image`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `band_image` (`id`, `band_id`, `image_id`) VALUES (1, 1, 11);

COMMIT;


-- -----------------------------------------------------
-- Data for table `band_social_media`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `band_social_media` (`id`, `social_media_id`, `band_id`, `url`) VALUES (1, 1, 1, 'https://www.facebook.com/bandpage/');
INSERT INTO `band_social_media` (`id`, `social_media_id`, `band_id`, `url`) VALUES (2, 2, 1, 'https://twitter.com/bandpage?lang=en');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_instrument`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `user_instrument` (`id`, `profile_id`, `instrument_id`, `experience`, `description`) VALUES (1, 1, 1, 'Expert', 'This is the description for the guitarest');
INSERT INTO `user_instrument` (`id`, `profile_id`, `instrument_id`, `experience`, `description`) VALUES (2, 2, 2, 'Expert', 'This is the description for the piano user');
INSERT INTO `user_instrument` (`id`, `profile_id`, `instrument_id`, `experience`, `description`) VALUES (3, 3, 3, 'Intermidiate', 'This is the description for the electric guitar player');
INSERT INTO `user_instrument` (`id`, `profile_id`, `instrument_id`, `experience`, `description`) VALUES (4, 4, 4, 'Intermidiate', 'This is the description for the drum player');
INSERT INTO `user_instrument` (`id`, `profile_id`, `instrument_id`, `experience`, `description`) VALUES (5, 5, 5, 'Intermidiate', 'This is the desctiption for the bass player');

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `event` (`id`, `address_id`, `band_id`, `description`, `start_date`, `end_date`, `created_at`, `updated_at`) VALUES (1, 7 , 1, 'What starts out as yearning soon becomes manipulated into a carnival of distress, leaving only a sense of unreality and the chance of a new synthesis.', '2019-04-26 20:00:00', '2019-04-26 22:00:00', '2019-04-11 09:38:48', '2019-04-11 09:38:48');

COMMIT;

