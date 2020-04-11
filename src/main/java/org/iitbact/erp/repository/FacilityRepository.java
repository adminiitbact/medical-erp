package org.iitbact.erp.repository;

import java.util.List;

import org.iitbact.erp.entities.Facility;
import org.iitbact.erp.entities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	@Query(value = "Select * from facilities a left join wards b on a.facility_id = b.facility_id having b.available_beds > 0 and b.`type` = ?1", nativeQuery = true)
	List<Facility> fetchFacilityList(String type);

}