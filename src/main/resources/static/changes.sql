










--------------------------------- Done -------------------------------

ALTER TABLE `facilities`
	ADD COLUMN `address` TINYTEXT NULL DEFAULT NULL AFTER `is_fever_clinic_available`,
	ADD COLUMN `ulb_ward_name` VARCHAR(50) NULL DEFAULT NULL AFTER `address`,
	ADD COLUMN `ulb_zone_name` VARCHAR(50) NULL DEFAULT NULL AFTER `ulb_ward_name`;
	