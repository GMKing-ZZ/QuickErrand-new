ALTER TABLE `t_runner_blacklist` DROP INDEX `uk_user_runner`;
ALTER TABLE `t_runner_blacklist` ADD UNIQUE KEY `uk_user_runner` (`user_id`, `runner_id`, `deleted`);
