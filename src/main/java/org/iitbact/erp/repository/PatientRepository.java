package org.iitbact.erp.repository;

import org.iitbact.erp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
}
