package com.henryxi.springdata.keyvalue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@Controller
@RequestMapping(path = "/spring-data-keyvalue")
public class MainController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/add")
    @ResponseBody
    public String addNewUser(@RequestParam String name, @RequestParam String chatId) {
        Person person = new Person();
        person.setName(name);
        person.setChatId(Integer.valueOf(chatId));
        personRepository.save(person);
        return "Saved";
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @GetMapping(path = "/query")
    @ResponseBody
    public Iterable<Person> query() {
        personRepository.deleteByChatId(1);
        return new ArrayList<Person>();
    }
}