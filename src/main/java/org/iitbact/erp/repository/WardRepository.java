package org.iitbact.erp.repository;

import java.util.List;

import org.iitbact.erp.entities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WardRepository extends JpaRepository<Ward, Integer> {

	@Query(value = "Select * from wards  where available_beds > 0 and `type` = ?1 and facility_id = ?2", nativeQuery = true)
	List<Ward> fetchFacilityWardList(String type,int facilityId);
}
