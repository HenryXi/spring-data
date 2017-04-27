package com.henryxi.springdata.quickstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path = "/spring-data-jpa")
public class MainController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(path = "/add")
    @ResponseBody
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
        Employee n = new Employee();
        n.setName(name);
        n.setEmail(email);
        employeeRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }
}