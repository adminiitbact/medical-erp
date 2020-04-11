package org.iitbact.erp.repository;

import java.util.List;

import org.iitbact.erp.entities.PatientLiveStatus;
import org.iitbact.erp.entities.PatientLiveStatusInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientLiveStatusRepository extends JpaRepository<PatientLiveStatus, Integer>{
		
	@Query(nativeQuery = true, value = "SELECT pls.patient_id,pls.`condition`,pls.test_outcome,f.name,w.name,w.`type` wardType FROM patient_live_status pls INNER JOIN facilities f ON f.facility_id=pls.facility_id LEFT JOIN wards w ON w.id=pls.ward_id WHERE pls.patient_id=?1;")
	PatientLiveStatusInterface findByPatientId(int patientId);

	@Query(nativeQuery = true, value = "SELECT pls.patient_id,pls.`condition`,pls.test_outcome,f.name,w.name,w.`type` wardType FROM patient_live_status pls INNER JOIN facilities f ON f.facility_id=pls.facility_id LEFT JOIN wards w ON w.id=pls.ward_id WHERE pls.facility_id=?1;")
	List<PatientLiveStatusInterface> findByFacilityId(int facility_id);

}
