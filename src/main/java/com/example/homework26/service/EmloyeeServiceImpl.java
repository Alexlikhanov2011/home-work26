package com.example.homework26.service;

import com.example.homework26.exception.EmployeeAllreadyAddedException;
import com.example.homework26.exception.EmployeeNotFoundException;
import com.example.homework26.exception.EmployeeStorageIsFullException;
import com.example.homework26.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class EmloyeeServiceImpl implements EmloyeeService {
    private static final int SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public void addEmployee(String lastName, String firstName) {
        if (employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = makeKey(lastName, firstName);
        if (employees.containsKey(key)) {
            throw new EmployeeAllreadyAddedException();
        }
        employees.put(key, new Employee(capitalize(firstName), lastName));
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        var emp = employees.get(makeKey(lastName, firstName));
        if (emp == null) {
            throw new EmployeeNotFoundException();
        }
        return emp;
    }

    @Override
    public boolean removeEmployee(String lastName, String firstName) {
        Employee removed = employees.remove(makeKey(lastName, firstName));
        var employee = new Employee(lastName, firstName);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return true;
    }

    @Override
    public Collection<Employee> getAll() {
        return employees.values();
    }

}
