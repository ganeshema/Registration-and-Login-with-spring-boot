package com.ganeshgc.login_registration_project.service.impl;

import com.ganeshgc.login_registration_project.model.User;
import com.ganeshgc.login_registration_project.repository.UserRepository;
import com.ganeshgc.login_registration_project.service.UserService;
import com.ganeshgc.login_registration_project.web.Dto.UserRegistrationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserRegistrationDto saveUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        BeanUtils.copyProperties(userRegistrationDto, user);
        userRepository.save(user);
        return userRegistrationDto;
    }
}
