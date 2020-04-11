package org.iitbact.erp.repository;

import org.iitbact.erp.entities.PatientLiveStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientLiveStatusRepository extends JpaRepository<PatientLiveStatus, Integer>{

	PatientLiveStatus findByPatientId(int patientId);

}
