package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePerson {

    @Autowired
    Repo repo;

    public Person addPerson(Person person){
        return repo.save(person);
    }

    public Person getPersonByID(Long id){
        return repo.findById(id).orElse(null);
    }

    public List<Person> getAllPersons(){
        return repo.findAll();
    }

    public Person editPersonByID(Long id, Person person){
        return repo.findById(id).map(existed->{
            existed.setName(person.getName());
            existed.setSalary(person.getSalary());
            return repo.save(existed);
        }).orElse(null);
    }

    public String deletePersonByID(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Person with ID: "+id+" got deleted!";
        }else{
            return "Person with ID: "+id+" not found!";
        }
    }
}
