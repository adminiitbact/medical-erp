package org.iitbact.erp.repository;

import org.iitbact.erp.entities.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	
	Facility findByFacilityId(int facilityId);
	
}