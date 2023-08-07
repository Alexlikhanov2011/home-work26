package com.example.homework26.service;

import com.example.homework26.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartamentService {
    Employee maxSalary(int deptId);

    Employee minSalary(int deptId);

    List<Employee> findAllByDept(int deptId);

    Map<Integer, List<Employee>> groopByDept();


}
