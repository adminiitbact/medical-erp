ALTER TABLE `wards`
ADD COLUMN `active` BIT(1) NOT NULL DEFAULT b'1' AFTER `covid_ward`;

ALTER TABLE `wards_history`
	ADD COLUMN `active` BIT(1) NOT NULL DEFAULT b'1' AFTER `covid_ward`;