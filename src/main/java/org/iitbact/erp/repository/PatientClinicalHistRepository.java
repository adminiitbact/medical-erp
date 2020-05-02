package org.iitbact.erp.repository;

import org.iitbact.erp.entities.PatientClinicalHist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientClinicalHistRepository extends JpaRepository<PatientClinicalHist, Integer> {

}
