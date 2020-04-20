ALTER TABLE `wards`
	ADD COLUMN `ventilators_occupied` INT(11) NOT NULL DEFAULT '0' AFTER `ventilators`;


ALTER TABLE `wards`
	DROP COLUMN `icu_beds`;
ALTER TABLE `wards`
	ADD COLUMN `covid_ward` BIT NOT NULL DEFAULT b'0' AFTER `extra_fields`;



ALTER TABLE `wards_history`
	ADD COLUMN `covid_ward` BIT NOT NULL DEFAULT b'0' AFTER `extra_fields`,
	ADD COLUMN `ventilators_occupied` INT NOT NULL DEFAULT 0 AFTER `covid_ward`,
	DROP COLUMN `icu_beds`;

ALTER TABLE `patients`
	ADD COLUMN `pre_existing_medical_condition` JSON NULL DEFAULT NULL AFTER `goi_covid_id`;