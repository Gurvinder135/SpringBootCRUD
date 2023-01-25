package com.consultadd.controller;

import com.consultadd.model.Employee;

import com.consultadd.service.EmployeeService;
import com.consultadd.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @PostMapping("/addemp")
    public String saveEmployees(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @PutMapping("/editemp/{id}")
    public String editEmployee(@RequestBody Employee employee, @PathVariable String id){
        return employeeService.editEmployee(id, employee);
    }
    @DeleteMapping("/deleteemp/{id}")
    public String deleteEmployee(@PathVariable("id") String id){
        return employeeService.deleteEmployee(id);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody Employee authRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }
}
