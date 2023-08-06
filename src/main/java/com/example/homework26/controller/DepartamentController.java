package com.example.homework26.controller;

import com.example.homework26.model.Employee;
import com.example.homework26.service.DepartamentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departament")
public class DepartamentController implements DepartamentControllerInt {
    private final DepartamentService service;

    public DepartamentController(DepartamentService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/max-salary")
    public Employee max(@RequestParam int departamentId) {
        return service.maxSalary(departamentId);
    }

    @Override
    @GetMapping("/min-salary")
    public Employee min(@RequestParam int departamentId) {
        return service.minSalary(departamentId);
    }

    @Override
    @GetMapping("/All")
    public List<Employee> all(@RequestParam int departamentId) {
        return service.findAllByDept(departamentId);
    }

    @GetMapping("/All-salary")
    public Map<Integer, List<Employee>> allsalary(@RequestParam int departamentId) {
        return service.groopByDept(departamentId);
    }
}
