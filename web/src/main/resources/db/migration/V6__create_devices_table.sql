CREATE TABLE `fitness`.`devices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `serial` VARCHAR(255) NOT NULL,
  `product` VARCHAR(255) NOT NULL,
  `category` ENUM('RUNNING', 'SWIMMING', 'BIKING') NOT NULL,
  `user_id` INT NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT NOW(),
  `modified` TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `serial_UNIQUE` (`serial` ASC),
  CONSTRAINT `fk_users_v6`
  FOREIGN KEY (`user_id`)
  REFERENCES `fitness`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
