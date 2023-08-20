package com.example.homework26.controller;

import com.example.homework26.exception.NotValidArgumentExeption;
import com.example.homework26.model.Employee;
import com.example.homework26.service.EmloyeeServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmloyeeServiceImpl service;

    public EmployeeController(EmloyeeServiceImpl service) {
        this.service = service;
    }



    @GetMapping("/add")
    public void add(@RequestParam String lastName, @RequestParam String firstName) {
        chek(firstName, lastName);
        service.addEmployee(lastName, firstName);
    }


    @GetMapping("/get")
    public Employee get(@RequestParam String lastName, @RequestParam String firstName) {
        chek(firstName, lastName);
        return service.findEmployee(lastName, firstName);
    }


    @GetMapping("/remove")
    public boolean remove(@RequestParam String lastName, @RequestParam String firstName) {
        chek(firstName, lastName);
        return service.removeEmployee(lastName, firstName);
    }


    @GetMapping("/all")
    public Collection<Employee> getAll() {
        return service.getAll();
    }
    private void chek (String... args){
        for (String arg : args) {
            if (!StringUtils.isAlpha(arg)){
                throw new NotValidArgumentExeption();
            }
            
        }
                
                
    }
}
