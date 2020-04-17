package org.iitbact.erp.repository;

import java.util.List;

import org.iitbact.erp.entities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WardRepository extends JpaRepository<Ward, Integer> {
	
	@Query(nativeQuery = true,value = "SELECT * FROM wards w WHERE w.facility_id=?1 ORDER BY IF(w.severity=?3 AND w.covid_status=?2,1,0) DESC")
	List<Ward> findByFacilityIdAndCovidStatusAndSeverity(int facilityId, String covidStatus, String severity);

	Ward findByIdAndFacilityId(int wardId, int facilityId);
}
