package com.example.homework26.service;

import com.example.homework26.exception.EmployeeAllreadyAddedException;
import com.example.homework26.exception.EmployeeNotFoundException;
import com.example.homework26.exception.EmployeeStorageIsFullException;
import com.example.homework26.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmloyeeService {
    private static final int SIZE = 10;
    private final List<Employee>employees = new ArrayList<>();
    public void addEmployee(String lastName, String firstName){
        if (employees.size()==SIZE){
            throw new EmployeeStorageIsFullException();
        }
        var employee= new Employee(lastName,firstName);
        if (employees.contains(employee)){
            throw new EmployeeAllreadyAddedException();
        }
        employees.add(employee);
    }
    public Employee findEmployee (String lastName, String firstName){
        var employee= new Employee(lastName,firstName);
        for (Employee emp : employees){
            if (emp.equals(employee)){
                return emp;
            }
        }
        throw new EmployeeNotFoundException();
    }
    public boolean removeEmployee(String lastName, String firstName){
        var employee= new Employee(lastName,firstName);
        for (Employee e : employees){
            if (e.equals(employee)){
               employees.remove(e);
               return true;
            }
        }
throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getAll() {
        return employees;
    }
}
