package com.example.homework26.service;

import com.example.homework26.exception.EmployeeNotFoundException;
import com.example.homework26.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartamentService {
    private final EmloyeeService emloyeeService;

    public DepartamentService(EmloyeeService emloyeeService) {
        this.emloyeeService = emloyeeService;
    }

    public Employee maxSalary(int deptId) {
        return emloyeeService.getAll()
                .stream()
                .filter(e -> e.getDepartament() == deptId)
                .max(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee minSalary(int deptId) {
        return emloyeeService.getAll()
                .stream()
                .filter(e -> e.getDepartament() == deptId)
                .min(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findAllByDept(int deptId) {
        return emloyeeService.getAll()
                .stream()
                .filter(e -> e.getDepartament() == deptId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> groopByDept(int departamentId) {
        return emloyeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartament));
    }
}
