package org.iitbact.erp.repository;

import org.iitbact.erp.entities.PatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientHistoryRepository extends JpaRepository<PatientHistory,Integer> {
	
	 @Query(value = "Select * from patient_history where patient_id = ?1 order by id desc limit 1", nativeQuery = true)
	 PatientHistory findLatestStatus(int patientId);
}
