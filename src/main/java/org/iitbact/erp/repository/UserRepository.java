package org.iitbact.erp.repository;

import org.iitbact.erp.entities.HospitalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<HospitalUser, Integer> {

	HospitalUser findByEmailId(String emailId);

	HospitalUser findByUserId(String userId);

}
