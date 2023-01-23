package com.consultadd.service;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        List<Employee> employeeList=employeeRepository.findAll();
        return employeeList;
    }
    public String saveEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            return "ID already exists";
        } else{
            employeeRepository.save(employee);
            return "Employee saved";
        }
    }
    public String editEmployee(String id,Employee employee){
        if(employeeRepository.existsById(id)){
            employeeRepository.save(employee);
            return "Employee edited";
        } else{
            return "Employee id not exist";
        }
    }
    public String deleteEmployee(String id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return "Employee deleted";
        } else{
            return "Employee id not exist";
        }
    }

}
