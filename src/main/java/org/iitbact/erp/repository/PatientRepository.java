package org.iitbact.erp.repository;

import java.util.List;

import org.iitbact.erp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	List<Patient> findByName(String name);
	Patient findById(int id);
}
