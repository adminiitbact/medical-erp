package org.iitbact.erp.repository;

import java.util.List;

import org.iitbact.erp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	List<Patient> findByName(String name);
	Patient findById(int id);
	
	 @Query(value = "Select * from patients a where patient_id in (Select patient_id from patient_history b where b.facility_id = ?1 ) group by a.patient_id", nativeQuery = true)
	 List<Patient> findByFacilityId(int facility_id);
}
