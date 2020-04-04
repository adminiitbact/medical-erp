package org.iitbact.erp.repository;

import org.iitbact.erp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailId(String emailId);

	User findByUserId(String userId);

}
