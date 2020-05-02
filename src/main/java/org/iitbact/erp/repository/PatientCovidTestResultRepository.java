package org.iitbact.erp.repository;

import org.iitbact.erp.entities.PatientCovidTestDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientCovidTestResultRepository extends JpaRepository<PatientCovidTestDetails, Integer> {

}
