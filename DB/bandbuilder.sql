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
  `enabled` TINYINT NULL,
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
  `zip` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(50) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `image` ;

CREATE TABLE IF NOT EXISTS `image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(2000) NULL,
  `alt` TEXT(1000) NULL,
  `description` TEXT(1000) NULL,
  `active` VARCHAR(45) NULL,
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
  `active` TINYINT NULL,
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
  `active` TINYINT NULL,
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
  `image_id` INT NOT NULL,
  `email` VARCHAR(1000) NOT NULL,
  `time_commitment` VARCHAR(200) NULL,
  `updated_at` DATETIME NULL,
  `created_at` DATETIME NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_id_idx` (`address_id` ASC),
  INDEX `fk_band_Profile1_idx` (`leader_id` ASC),
  INDEX `fk_band_image1_idx` (`image_id` ASC),
  CONSTRAINT `fk_band_address_id`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_band_Profile1`
    FOREIGN KEY (`leader_id`)
    REFERENCES `profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_band_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `image` (`id`)
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
  `active` TINYINT NULL,
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
  `active` TINYINT NULL,
  PRIMARY KEY (`id`))
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
  `active` TINYINT NULL,
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
  `active` TINYINT NULL,
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
  `active` TINYINT NULL,
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
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`, `enabled`) VALUES (1, 'rocker', '$2a$10$PJkxc5kRSRB2W8zlhSyNcO86w0XoF1OT58TcSlrgLhh9wpnPJgUU.', 1, 'admin', 1);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`, `enabled`) VALUES (2, 'pianoPro', '$2a$10$9qpOuJo1VUXcq8NYzFdFb.3RmKFoR4nqc4Ny86K.4fc1glUs3DQI.', 1, 'standard', 1);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`, `enabled`) VALUES (3, 'guitarest', '$2a$10$ipXmHlbSdKTDlf7InxZJ3Ocb0KDPlUMELIbJyIFd9qUhvs3jtai7a', 1, 'standard', 1);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`, `enabled`) VALUES (4, 'drummer', '$2a$10$KhdhhY2aRukWLCrfZ1Mvqu4kep9CrCG5PKOLbJKjTaOx/Fp5K/fxW', 1, 'standard', 1);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `role`, `enabled`) VALUES (5, 'bassest', '$2a$10$onpwcO4wa1Le5bitil8I8./fHQiIfNmnoAwLDwXcptgNWKDeIexG2', 1, 'standard', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`, `active`) VALUES (1, '123 Colorado Drive ', NULL, 'Denver', 'Colorado', '80220', '7201234567', '2019-04-01 23:08:48', '2019-04-01 23:08:48', 1);
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`, `active`) VALUES (2, '456 Broadway Drive', NULL, 'Denver', 'Colorado', '80202', '3035461111', '2019-04-08 23:08:48', '2019-04-08 23:08:48', 1);
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`, `active`) VALUES (3, '20965 Aurora Parkway', NULL, 'Aurora', 'Colorado', '80011', '3035231234', '2019-04-08 23:18:48', '2019-04-08 23:18:48', 1);
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`, `active`) VALUES (4, '1303 Colfax Avenue', NULL, 'Denver', 'Colorado', '80212', '7203256070', '2019-04-09 23:18:48', '2019-04-09 23:18:48', 1);
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`, `active`) VALUES (5, '3060 Main Street', NULL, 'Parker', 'Colorado', '80108', '3035046423', '2019-04-09 23:18:48', '2019-04-09 23:18:48', 1);
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`, `active`) VALUES (6, '15054 Halifax Way', NULL, 'Littleton', 'Colorado', '80121', '7205556743', '2019-04-10 22:38:48', '2019-04-10 22:38:48', 1);
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`, `active`) VALUES (7, '3317 E Colfax Ave', NULL, 'Denver', 'Colorado', '80226', '3033771666', '2019-04-11 09:38:48', '2019-04-11 09:38:48', 1);
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`, `active`) VALUES (8, '17900 Trading Post Rd', NULL, 'Morrison', 'Colorado', '80465', '7204567654', '2019-04-17 22:38:48', '2019-04-17 22:38:48', 1);
INSERT INTO `address` (`id`, `street`, `street_2`, `city`, `state`, `zip`, `phone`, `created_at`, `updated_at`, `active`) VALUES (9, '1419 Houston Steet', NULL, 'Sacramento', 'California', '95814', '3039876567', '2019-04-17 23:38:48', '2019-04-17 23:38:48', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `image`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (1, 'http://electricguitarhub.com/wp-content/uploads/2014/07/Best-guitarists-to-learn-from-tommy-.png', 'justin the guitarest image', 'This is an image of Justin the Guitarest', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (2, 'https://bestdigitalpianoguides.com/wp-content/uploads/2016/01/Learn-to-play-digital-piano-quickly.jpg', 'selena the pianest', 'This is an image of Selena at one of the practice sessions', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3R-yXJFW6Yc5jdMNHENe041nrbvZQZNRsHiE9rzHr65PVuWOF', 'Steve', 'This is an image of Steve that plays', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (4, 'http://www.jewcy.com/wp-content/uploads/2011/02/2.jpg', 'Rachel', 'This is an image of a standard drum set.', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (5, 'https://i.ytimg.com/vi/7PgnbtWvp4o/maxresdefault.jpg', 'Matthew', 'This is an image of Matthew playing the bass.', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (6, 'https://media.musiciansfriend.com/is/image/MMGS7/2018-L-00-Standard-Acoustic-Electric-Guitar-Vintage-Sunburst/K45486000001000-00-500x500.jpg', 'generic guitar', 'This is an image a standard guitar', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (7, 'https://www.colinbattremovals.co.uk/wp-content/uploads/2015/03/Bosendorfer-Imperial-Concert-Grand-Flagship-Model-290-Imperial.jpg', 'generic piano', 'This is an image of a standard piano', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (8, 'https://www.liveandlearn.com/shop/images/products/8867.jpg', 'generic electric guitar', 'This is an image of an electric guitar', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (9, 'https://worthly.com/wp-content/uploads/2015/08/Most-Expensive-Drum-Kits.png', 'generic drum set', 'This is an image of a drum set', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (10 , 'https://media.sweetwater.com/api/i/q-82__ha-4e7259dfbf2cadfe__hmac-f226978006fcf14a7522d3ddfcb6c8d65032d774/images/guitars/Wav4MatBlk/W150494/W150494-body-large.jpg', 'generic bass guitar', 'This is an image of a bass guitar', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (11, 'https://cdn.mos.cms.futurecdn.net/wpEgipYD7TJYpuYvbb3mi-320-80.jpg', 'generic band ', 'This is an image of a band at practice', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (12, 'https://i.ytimg.com/vi/23pYfDKyfBk/maxresdefault.jpg', 'This is band 2 image', 'This is band 2 Image', '1');
INSERT INTO `image` (`id`, `url`, `alt`, `description`, `active`) VALUES (13, 'https://www.amwpro.com/wp-content/uploads/band-on-a-stage.jpg', 'This is band 3 image', 'This is band 3 image', '1');

COMMIT;


-- -----------------------------------------------------
-- Data for table `profile`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about_me`, `address_id`, `image_id`, `created_at`, `updated_at`, `user_id`, `active`) VALUES (1, 'Justin ', 'Blake', 'biebs@gmail.com', 'I have played the guitar since I was a small boy. My first guitar was gifted to me by my grandfather who was also a guitarest. ', 1, 1, '2019-04-01 22:08:48', '2019-04-14 22:08:48', 1, 1);
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about_me`, `address_id`, `image_id`, `created_at`, `updated_at`, `user_id`, `active`) VALUES (2, 'Selena', 'Smith', 'selena20@gmail.com', 'I have been playing the piano for quite sometime. ', 2, 2, '2019-04-08 22:08:48', '2019-04-04 22:08:48', 2, 1);
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about_me`, `address_id`, `image_id`, `created_at`, `updated_at`, `user_id`, `active`) VALUES (3, 'Steve', 'Jackson', 'stevejackson@gmail.com', 'I can play the electric guitar very well. Enjoy teaching others build their talent skills. ', 3, 3, '2019-04-08 23:18:48', '2019-04-08 23:18:48', 3, 1);
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about_me`, `address_id`, `image_id`, `created_at`, `updated_at`, `user_id`, `active`) VALUES (4, 'Rachel', 'Chelsea', 'rachelchelsea@gmail.com', 'I can play the drums.', 4, 4, '2019-04-09 23:18:48', '2019-04-09 23:18:48', 4, 1);
INSERT INTO `profile` (`id`, `first_name`, `last_name`, `email`, `about_me`, `address_id`, `image_id`, `created_at`, `updated_at`, `user_id`, `active`) VALUES (5, 'Matthew', 'Adams', 'matthewadams@gmail.com', 'I can play the bass. I typically play at my local church on Sundays. ', 5, 5, '2019-04-10 02:18:48', '2019-04-10 02:18:48', 5, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `instrument`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `instrument` (`id`, `name`, `approved`, `image_id`, `description`, `active`) VALUES (1, 'Guitar', 1, 6, 'This is a guitar', 1);
INSERT INTO `instrument` (`id`, `name`, `approved`, `image_id`, `description`, `active`) VALUES (2, 'Piano', 1, 7, 'This is a piano', 1);
INSERT INTO `instrument` (`id`, `name`, `approved`, `image_id`, `description`, `active`) VALUES (3, 'Electric Guitar', 1, 8, 'This is a electric guitar', 1);
INSERT INTO `instrument` (`id`, `name`, `approved`, `image_id`, `description`, `active`) VALUES (4, 'Drums', 1, 9, 'This is a drums', 1);
INSERT INTO `instrument` (`id`, `name`, `approved`, `image_id`, `description`, `active`) VALUES (5, 'Bass Guitar', 1, 10, 'This is a bass guitar', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `band`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `band` (`id`, `name`, `about_us`, `genre`, `address_id`, `leader_id`, `image_id`, `email`, `time_commitment`, `updated_at`, `created_at`, `active`) VALUES (1, 'Piss-ant Graphite', 'What starts out as yearning soon becomes manipulated into a carnival of distress, leaving only a sense of unreality and the chance of a new synthesis.', 'Rock', 6, 1, 11, 'thegarageband@gmail.com', 'Test', '2019-04-01 22:38:48', '2019-04-01 22:38:48', 1);
INSERT INTO `band` (`id`, `name`, `about_us`, `genre`, `address_id`, `leader_id`, `image_id`, `email`, `time_commitment`, `updated_at`, `created_at`, `active`) VALUES (2, 'Torrent Technician', 'As shifting derivatives become distorted through emergent and personal practice, the viewer is left with a tribute to the darkness of our existence', 'Heavy Metal', 8, 2, 12, 'heavymetal@gmail.com', 'Test2', '2019-04-17 22:38:48', '2019-04-17 22:38:48', 1);
INSERT INTO `band` (`id`, `name`, `about_us`, `genre`, `address_id`, `leader_id`, `image_id`, `email`, `time_commitment`, `updated_at`, `created_at`, `active`) VALUES (3, 'Haven', 'It challenges the binaries we continually reconstruct between Self and Other, between our own ‘cannibal’ and ‘civilized’ selves.', 'Christian Rock', 9, 3, 13, 'haven@gmail.com', 'Test3', '2019-04-17 23:38:48', '2019-04-17 23:38:48', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `band_member`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `band_member` (`id`, `band_id`, `instrument_id`, `profile_id`, `description`, `experience`, `created_at`, `joined_at`, `active`) VALUES (1, 1, 1, 1, 'This is the lead Guitar Player', 'Expert', '2019-04-01 22:38:48', '2019-04-01 22:38:48', 1);
INSERT INTO `band_member` (`id`, `band_id`, `instrument_id`, `profile_id`, `description`, `experience`, `created_at`, `joined_at`, `active`) VALUES (2, 1, 2, 2, 'This is the lead piano player ', 'Expert', '2019-04-01 22:48:48', '2019-04-01 22:48:48', 1);
INSERT INTO `band_member` (`id`, `band_id`, `instrument_id`, `profile_id`, `description`, `experience`, `created_at`, `joined_at`, `active`) VALUES (3, 1, 3, 3, 'This is the electric guitar player', 'Intermidiate', '2019-04-01 22:58:48', '2019-04-01 22:58:48', 1);
INSERT INTO `band_member` (`id`, `band_id`, `instrument_id`, `profile_id`, `description`, `experience`, `created_at`, `joined_at`, `active`) VALUES (4, 1, 4, 4, 'This is the Drummer', 'Intermidiate', '2019-04-01 23:08:48', '2019-04-01 23:08:48', 1);
INSERT INTO `band_member` (`id`, `band_id`, `instrument_id`, `profile_id`, `description`, `experience`, `created_at`, `joined_at`, `active`) VALUES (5, 1, 5, 5, 'This is the Bass guitar player', 'Intermidiate', '2019-04-01 23:18:48', '2019-04-01 23:18:48', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `social_media`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `social_media` (`id`, `name`, `image_url`, `active`) VALUES (1, 'facebook ', 'http://cofarming.info/wp-content/uploads/2017/01/facebook-icon-preview-1-400x400.png', 1);
INSERT INTO `social_media` (`id`, `name`, `image_url`, `active`) VALUES (2, 'twitter', 'https://instagram-brand.com/wp-content/uploads/2016/11/Instagram_AppIcon_Aug2017.png?w=300', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `band_social_media`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `band_social_media` (`id`, `social_media_id`, `band_id`, `url`, `active`) VALUES (1, 1, 1, 'https://www.facebook.com/bandpage/', 1);
INSERT INTO `band_social_media` (`id`, `social_media_id`, `band_id`, `url`, `active`) VALUES (2, 2, 1, 'https://twitter.com/bandpage?lang=en', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_instrument`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `user_instrument` (`id`, `profile_id`, `instrument_id`, `experience`, `description`, `active`) VALUES (1, 1, 1, 'Expert', 'This is the description for the guitarest', 1);
INSERT INTO `user_instrument` (`id`, `profile_id`, `instrument_id`, `experience`, `description`, `active`) VALUES (2, 2, 2, 'Expert', 'This is the description for the piano user', 1);
INSERT INTO `user_instrument` (`id`, `profile_id`, `instrument_id`, `experience`, `description`, `active`) VALUES (3, 3, 3, 'Intermidiate', 'This is the description for the electric guitar player', 1);
INSERT INTO `user_instrument` (`id`, `profile_id`, `instrument_id`, `experience`, `description`, `active`) VALUES (4, 4, 4, 'Intermidiate', 'This is the description for the drum player', 1);
INSERT INTO `user_instrument` (`id`, `profile_id`, `instrument_id`, `experience`, `description`, `active`) VALUES (5, 5, 5, 'Intermidiate', 'This is the desctiption for the bass player', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `bandbuilderdb`;
INSERT INTO `event` (`id`, `address_id`, `band_id`, `description`, `start_date`, `end_date`, `created_at`, `updated_at`, `active`) VALUES (1, 7 , 1, 'What starts out as yearning soon becomes manipulated into a carnival of distress, leaving only a sense of unreality and the chance of a new synthesis.', '2019-04-26 20:00:00', '2019-04-26 22:00:00', '2019-04-11 09:38:48', '2019-04-11 09:38:48', 1);

COMMIT;

