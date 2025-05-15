package org.example;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class Controller {

    @Autowired
    ServicePerson service;

    @PostMapping("/create")
    public Person addPerson(@Valid @RequestBody Person person){
        return service.addPerson(person);
    }

    @GetMapping("/get/{id}")
    public Person getPersonByID(@PathVariable Long id){
        return service.getPersonByID(id);
    }

    @GetMapping("/")
    public List<Person> getAllPersons(){
        return service.getAllPersons();
    }

    @PutMapping("/update/{id}")
    public Person editPersonByID(@PathVariable Long id, @RequestBody Person person){
        return service.editPersonByID(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePersonByID(@PathVariable Long id){
        return service.deletePersonByID(id);
    }
}
