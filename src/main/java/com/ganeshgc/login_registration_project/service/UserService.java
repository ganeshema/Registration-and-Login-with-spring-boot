package com.ganeshgc.login_registration_project.service;

import com.ganeshgc.login_registration_project.model.User;
import com.ganeshgc.login_registration_project.web.Dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserRegistrationDto saveUser(UserRegistrationDto userRegistrationDto);
}
