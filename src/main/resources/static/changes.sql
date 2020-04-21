ALTER TABLE `wards`
ADD COLUMN `active` BIT(1) NOT NULL DEFAULT b'1' AFTER `covid_ward`;

ALTER TABLE `wards_history`
	ADD COLUMN `active` BIT(1) NOT NULL DEFAULT b'1' AFTER `covid_ward`;
	
	ALTER TABLE `wards`
	DROP INDEX `facility_id_name_ward_number_floor_building_name`;

	------------ Changes to accept DOB instead of age (22-04-2020)----------
	ALTER TABLE `patients`
	ADD COLUMN `dob` DATE NOT NULL DEFAULT '0000-00-00' AFTER `gender`;

	ALTER TABLE `patients`
	DROP COLUMN `age`;
