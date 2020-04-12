package org.iitbact.erp.repository;

import java.util.List;

import org.iitbact.erp.entities.Facility;
import org.iitbact.erp.entities.FacilityAssignedPatients;
import org.iitbact.erp.entities.FacilityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	@Query(value = "SELECT f.facility_id facilityId,f.name,f.area,f.jurisdiction,f.facility_type facilityType,f.covid_facility_type covidFacilityType,f.telephone,IFNULL(SUM(w.available_beds),0) availablity FROM facilities f INNER JOIN wards w ON f.facility_id=w.facility_id WHERE w.covid_status=?1 AND w.patient_condition=?2 GROUP BY w.facility_id",nativeQuery = true)
	List<FacilityDetails> getFacilities(String covidStatus, String severity);
	
	@Query(value = "SELECT f.facility_id facilityId,f.name,f.area,f.jurisdiction,f.facility_type facilityType,f.covid_facility_type covidFacilityType,f.telephone,IFNULL(SUM(w.available_beds),0) availablity FROM facilities f INNER JOIN wards w ON f.facility_id=w.facility_id GROUP BY w.facility_id",nativeQuery = true)
	List<FacilityDetails> getFacilities();
	
	
	@Query(value = "SELECT p.facility_id,COUNT(1) totalAssigned FROM patient_live_status p WHERE p.ward_id=0 AND p.patient_condition=?1 AND p.test_outcome=?2 GROUP BY p.facility_id;",nativeQuery = true)
	List<FacilityAssignedPatients> assignedPatients(String condition, String teststatus);
	
	@Query(value = "SELECT p.facility_id,COUNT(1) totalAssigned FROM patient_live_status p WHERE p.ward_id=0  GROUP BY p.facility_id",nativeQuery = true)
	List<FacilityAssignedPatients> assignedPatients();

}