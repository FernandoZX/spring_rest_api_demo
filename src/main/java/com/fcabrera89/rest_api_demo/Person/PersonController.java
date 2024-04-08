package com.fcabrera89.rest_api_demo.Person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequiredArgsConstructor
public class PersonController {
  
    private final PersonService personService;

    @GetMapping("/persons")
    @ResponseBody    
    public List<Person> people(){
      return personService.findAll();

    }
    @PostMapping("/persons")
    public void createPerson(@RequestBody Person person) {
      personService.createPerson(person);
    }

    @GetMapping("/person/{id}")
    @ResponseBody
    public Optional<Person> getPerson(@PathVariable Integer id) {
      System.out.println("print id" +id.getClass());
        return personService.getPerson(id);
    }

    @PutMapping("/person/{id}")
    public void putPerson(@PathVariable Integer id, @RequestBody Person person) {
        personService.updatePerson(id, person);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
    }
    
}
