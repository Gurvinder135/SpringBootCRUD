package com.consultadd.config;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee emp=employeeRepository.findByUsername(username);
        if(emp==null){
          throw new UsernameNotFoundException("User not found");
        } else{
            return User.withDefaultPasswordEncoder().username(emp.getUsername()).password(emp.getPassword()).roles().build();
        }
    }
}
