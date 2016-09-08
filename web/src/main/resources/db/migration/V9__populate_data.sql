INSERT INTO `fitness`.`roles` (`version`, `role`) VALUES ('0', 'USER');
INSERT INTO `fitness`.`roles` (`version`, `role`) VALUES ('0', 'ADMIN');

INSERT INTO `fitness`.`users` (`version`, `username`, `password`, `enabled`) VALUES ('0', 'bob@aol.com', '$2a$10$8jBGVl3r1DCCHqLHUabm2uV3IT8tA2p8yfYmR7Lru1QcspIYwrf8S', '1');

INSERT INTO `fitness`.`roles_users` (`role_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `fitness`.`roles_users` (`role_id`, `user_id`) VALUES ('2', '1');

INSERT INTO `fitness`.`profiles` (`version`, `gender`, `age`, `height`, `weight`, `photo`, `user_id`)
VALUES ('0', 'M', '25', '70', '165', 'http://findicons.com/files/icons/1072/face_avatars/300/i05.png', '1');

INSERT INTO `fitness`.`exercises` (`version`, `type`, `quantity`, `calories`, `duration`, `user_id`)
VALUES ('0', 'RUN', '3', '900', '45', '1');

INSERT INTO `fitness`.`devices` (`version`, `serial`, `product`, `category`, `user_id`)
VALUES ('0', '123ABC', 'Fitbit Surge', 'Running', '1');
INSERT INTO `fitness`.`devices` (`version`, `serial`, `product`, `category`, `user_id`)
VALUES ('0', '456DEF', 'Fitbit Charge', 'Running', '1');

INSERT INTO `fitness`.`runs` (`version`, `start`, `stop`, `device_id`)
VALUES ('0', '2016-09-07@10:15:30', '2016-09-07@10:25:45', '2');
INSERT INTO `fitness`.`runs` (`version`, `start`, `device_id`)
VALUES ('0', '2016-09-07@10:15:30', '1');

INSERT INTO `fitness`.`positions` (`latitude`, `longitude`, `altitude`, `run_id`, `current`)
VALUES ('32.6', '101.7', '12.8', '1', '2016-09-07@10:15:33');
