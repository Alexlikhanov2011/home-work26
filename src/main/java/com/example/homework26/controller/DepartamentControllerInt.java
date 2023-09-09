package com.example.homework26.controller;

import com.example.homework26.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DepartamentControllerInt {
    @GetMapping("/max-salary")
    Employee max(@RequestParam int departamentId);

    @GetMapping("/max-salary")
    Employee min(@RequestParam int departamentId);

    @GetMapping("/All")
    List<Employee> all(@RequestParam int departamentId);
}
