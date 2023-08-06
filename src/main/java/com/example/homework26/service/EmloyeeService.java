package com.example.homework26.service;

import com.example.homework26.exception.EmployeeAllreadyAddedException;
import com.example.homework26.exception.EmployeeNotFoundException;
import com.example.homework26.exception.EmployeeStorageIsFullException;
import com.example.homework26.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmloyeeService {
    private static final int SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    public void addEmployee(String lastName, String firstName) {
        if (employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = makeKey(lastName, firstName);
        if (employees.containsKey(key)) {
            throw new EmployeeAllreadyAddedException();
        }
        var employee = new Employee(lastName, firstName);
        employees.put(key, employee);
    }

    public Employee findEmployee(String lastName, String firstName) {
        var emp = employees.get(makeKey(lastName, firstName));
        if (emp == null) {
            throw new EmployeeNotFoundException();
        }
        return emp;
    }

    public boolean removeEmployee(String lastName, String firstName) {
        Employee removed = employees.remove(makeKey(lastName, firstName));
        var employee = new Employee(lastName, firstName);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return true;
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    private String makeKey(String lastName, String firstName) {
        return (lastName + "_" + firstName).toLowerCase();
    }
}
