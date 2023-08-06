package com.example.homework26.service;

import com.example.homework26.exception.EmployeeNotFoundException;
import com.example.homework26.model.Employee;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class departamentService {
    private final EmloyeeService emloyeeService;

    public departamentService(EmloyeeService emloyeeService) {
        this.emloyeeService = emloyeeService;
    }

    public double maxSalary(int deptId) {
        return emloyeeService.getAll()
                .stream()
                .filter(e -> e.getDepartament() == deptId)
                .map(Employee::getSalary)
                .max(Comparator.comparingDouble(o -> o))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public double minSalary(int deptId) {
        return emloyeeService.getAll()
                .stream()
                .filter(e -> e.getDepartament() == deptId)
                .map(Employee::getSalary)
                .min(Comparator.comparingDouble(o -> o))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findAllByDept(int deptId) {
        return emloyeeService.getAll()
                .stream()
                .filter(e -> e.getDepartament() == deptId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> groopByDept() {
        return emloyeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartament));
    }
}
