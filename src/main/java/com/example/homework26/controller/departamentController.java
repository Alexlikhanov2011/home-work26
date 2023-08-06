package com.example.homework26.controller;

import com.example.homework26.service.departamentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departament")
public class departamentController {
    private final departamentService service;

    public departamentController(departamentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public double max(@RequestParam int departamentId) {
        return service.maxSalary(departamentId);
    }
}
