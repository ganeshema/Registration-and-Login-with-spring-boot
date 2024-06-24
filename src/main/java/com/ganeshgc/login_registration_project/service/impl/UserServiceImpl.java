package com.ganeshgc.login_registration_project.service.impl;

import com.ganeshgc.login_registration_project.model.Role;
import com.ganeshgc.login_registration_project.model.User;
import com.ganeshgc.login_registration_project.repository.UserRepository;
import com.ganeshgc.login_registration_project.service.UserService;
import com.ganeshgc.login_registration_project.web.Dto.UserRegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepository userRepository;
    @Override
    public UserRegistrationDto saveUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        BeanUtils.copyProperties(userRegistrationDto, user);
        userRepository.save(user);
        return userRegistrationDto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=userRepository.findByEmail(username);
       if(user==null){
           throw new UsernameNotFoundException("Invalid username or password.");
       }
       return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}
