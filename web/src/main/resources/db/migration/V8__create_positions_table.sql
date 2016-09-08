CREATE TABLE `fitness`.`positions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `latitude` FLOAT NULL,
  `longitude` FLOAT NULL,
  `altitude` FLOAT NULL,
  `current` DATETIME NULL,
  `run_id` INT NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT NOW(),
  `modified` TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_runs_v8`
  FOREIGN KEY (`run_id`)
  REFERENCES `fitness`.`runs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
