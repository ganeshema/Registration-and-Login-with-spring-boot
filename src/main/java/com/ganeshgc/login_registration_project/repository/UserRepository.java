package com.ganeshgc.login_registration_project.repository;

import com.ganeshgc.login_registration_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);


}
