CREATE TABLE `cities` (
	`city_id` BIGINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
	`zip` VARCHAR(4) NOT NULL,
	`city` VARCHAR(40) NOT NULL,
	PRIMARY KEY (`city_id`) USING BTREE
)
COLLATE='utf8_hungarian_ci';
