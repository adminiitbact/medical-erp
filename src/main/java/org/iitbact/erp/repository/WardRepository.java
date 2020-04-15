package org.iitbact.erp.repository;

import java.util.List;

import org.iitbact.erp.entities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardRepository extends JpaRepository<Ward, Integer> {
	List<Ward> findByFacilityIdAndCovidStatusAndSeverity(int facilityId, String covidStatus, String severity);
}
