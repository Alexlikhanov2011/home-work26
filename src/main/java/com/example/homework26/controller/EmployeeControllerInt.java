package com.example.homework26.controller;

import com.example.homework26.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public interface EmployeeControllerInt {
    @GetMapping("/add")
    void add(@RequestParam String lastName, @RequestParam String firstName);

    @GetMapping("/get")
    Employee get(@RequestParam String lastName, @RequestParam String firstName);

    @GetMapping("/remove")
    boolean remove(@RequestParam String lastName, @RequestParam String firstName);

    @GetMapping("/all")
    Collection<Employee> getAll();
}
