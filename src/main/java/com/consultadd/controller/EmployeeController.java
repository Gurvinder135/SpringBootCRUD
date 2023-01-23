package com.consultadd.controller;

import com.consultadd.model.Employee;

import com.consultadd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

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


}
