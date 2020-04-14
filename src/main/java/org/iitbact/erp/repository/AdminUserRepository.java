package org.iitbact.erp.repository;

import org.iitbact.erp.entities.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {

	AdminUser findByEmailId(String emailId);

	AdminUser findByUserId(String userId);

}
