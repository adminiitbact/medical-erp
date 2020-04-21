ALTER TABLE `wards`
ADD COLUMN `active` BIT(1) NOT NULL DEFAULT b'1' AFTER `covid_ward`;

ALTER TABLE `wards_history`
	ADD COLUMN `active` BIT(1) NOT NULL DEFAULT b'1' AFTER `covid_ward`;
	
	ALTER TABLE `wards`
	DROP INDEX `facility_id_name_ward_number_floor_building_name`;
