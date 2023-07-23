package com.example.homework26.controller;

import com.example.homework26.model.Employee;
import com.example.homework26.service.EmloyeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmloyeeService service;

    public EmployeeController(EmloyeeService service) {
        this.service = service;
    }


    @GetMapping("/add")
    public void add(@RequestParam String lastName, @RequestParam String firstName) {
        service.addEmployee(lastName, firstName);
    }

    @GetMapping("/get")
    public Employee get(@RequestParam String lastName, @RequestParam String firstName) {
        return service.findEmployee(lastName, firstName);
    }

    @GetMapping("/remove")
    public boolean remove(@RequestParam String lastName, @RequestParam String firstName) {
        return service.removeEmployee(lastName, firstName);
    }

    @GetMapping("/all")
    public Collection<Employee> getAll() {
        return service.getAll();
    }
}
