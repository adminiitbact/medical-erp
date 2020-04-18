package org.iitbact.erp.repository;

import org.iitbact.erp.entities.PatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientHistoryRepository extends JpaRepository<PatientHistory,Integer> {
	
}
