package com.ganeshgc.login_registration_project.service;

import com.ganeshgc.login_registration_project.model.User;
import com.ganeshgc.login_registration_project.web.Dto.UserRegistrationDto;

public interface UserService {

    UserRegistrationDto saveUser(UserRegistrationDto userRegistrationDto);
}
