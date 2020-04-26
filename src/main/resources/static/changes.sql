ALTER TABLE `wards`
ADD COLUMN `active` BIT(1) NOT NULL DEFAULT b'1' AFTER `covid_ward`;

ALTER TABLE `wards_history`
	ADD COLUMN `active` BIT(1) NOT NULL DEFAULT b'1' AFTER `covid_ward`;
	
	ALTER TABLE `wards`
	DROP INDEX `facility_id_name_ward_number_floor_building_name`;
	

	ALTER TABLE `facilities`
	ADD COLUMN `region` TINYINT NOT NULL DEFAULT '1' AFTER `ulb_zone_name`;

	CREATE TABLE `areas` (
	`area_id` INT NOT NULL AUTO_INCREMENT,
	`area` VARCHAR(50) NOT NULL,
	`region` VARCHAR(50) NOT NULL DEFAULT '1',
	PRIMARY KEY (`area_id`)
)
COLLATE='latin1_swedish_ci'
;


	------------ Changes to accept DOB instead of age (22-04-2020)----------
	ALTER TABLE `patients`
	ADD COLUMN `dob` DATE NOT NULL DEFAULT '0000-00-00' AFTER `gender`;

	ALTER TABLE `patients`
	DROP COLUMN `age`;
