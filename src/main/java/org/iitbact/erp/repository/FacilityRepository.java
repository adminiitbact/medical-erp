package org.iitbact.erp.repository;

import java.util.List;

import org.iitbact.erp.entities.Facility;
import org.iitbact.erp.entities.FacilityAssignedPatients;
import org.iitbact.erp.entities.FacilityDetails;
import org.iitbact.erp.response.MappedAdminFacilityResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	@Query(value = "Select facility_data.*,IF(m.mapped_facility is null,'false','true') as mapping from (SELECT f.facility_id facilityId,f.name,f.area,f.jurisdiction,f.facility_type facilityType,f.covid_facility_type covidFacilityType,f.telephone,IFNULL(SUM(w.available_beds),0) availability FROM facilities f INNER JOIN wards w ON f.facility_id=w.facility_id  WHERE (w.covid_status=?1 AND w.severity=?2)  GROUP BY w.facility_id) facility_data left join hospitaldb.facility_mapping m on facility_data.facilityId = m.mapped_facility and m.source_facility = ?3  order by mapping desc",nativeQuery = true)
	List<FacilityDetails> getFacilities(String covidStatus, String severity,int facilityId);
	
	@Query(value = "SELECT f.facility_id facilityId,f.name,f.area,f.jurisdiction,f.facility_type facilityType,f.covid_facility_type covidFacilityType,f.telephone,IFNULL(SUM(w.available_beds),0) availability FROM facilities f INNER JOIN wards w ON f.facility_id=w.facility_id GROUP BY w.facility_id",nativeQuery = true)
	List<FacilityDetails> getFacilities();
	
	
	@Query(value = "SELECT p.facility_id,IFNULL(COUNT(1),0) totalAssigned FROM patient_live_status p WHERE p.ward_id=0 AND p.severity=?1 AND p.test_status=?2 GROUP BY p.facility_id;",nativeQuery = true)
	List<FacilityAssignedPatients> assignedPatients(String condition, String teststatus);
	
	@Query(value = "SELECT p.facility_id,IFNULL(COUNT(1),0) totalAssigned FROM patient_live_status p WHERE p.ward_id=0  GROUP BY p.facility_id",nativeQuery = true)
	List<FacilityAssignedPatients> assignedPatients();

	@Query(value = "Select f.facility_id,f.name,f.area,f.jurisdiction,f.facility_type,f.covid_facility_type,f.government_hospital from admin_user_facility_mapping a inner join facilities f on a.facility_id = f.facility_id where a.admin_user_id = ?1",nativeQuery = true)
	List<Facility> fetchFacilityListAdmin(int adminId);
	
	@Query(nativeQuery = true,value = "Select f.facility_id facilityId,f.name,f.area,f.jurisdiction,f.facility_type facilityType,f.covid_facility_type covifFacilityType,f.government_hospital governmentHospital,if(fm.mapped_facility is null,'false','true') mapping from facility_mapping fm  right join facilities f on fm.mapped_facility = f.facility_id and fm.source_facility = ?1 order by mapping desc")
	List<MappedAdminFacilityResponse> fetchMappedFacilityList(int facilityId);
	
	
	//query for restricted facility access -> Select f.facility_id,f.name,f.area,f.jurisdiction,f.facility_type,f.covid_facility_type,f.government_hospital,if(fm.mapped_facility is null,'false','true') from admin_user_facility_mapping a inner join facilities f on a.facility_id = f.facility_id left join facility_mapping fm on fm.source_facility=a.facility_id where a.admin_user_id = ?1;

	
}