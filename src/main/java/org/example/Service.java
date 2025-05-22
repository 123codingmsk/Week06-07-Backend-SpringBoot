package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repo repo;

    public List<Contact> getAllContacts(){
        return repo.findAll();
    }

    public Contact getContactById(int id){
        return repo.findById(id).orElseThrow(()-> new ContactNotFoundException("Contact with ID: "+id+" not found!"));

    }

    public Contact addContact(Contact contact){
        return repo.save(contact);
    }

    public Contact updateContact(int id, Contact updatedContact){
        return repo.findById(id).map(existed->{
            existed.setName(updatedContact.getName());
            existed.setPhoneNum(updatedContact.getPhoneNum());
            existed.setAddress(updatedContact.getAddress());
            return repo.save(existed);
        }).orElseThrow(()->new ContactNotFoundException("Contact with ID: "+id+" not found!"));
    }

    public String deleteContact(int id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Contact with ID: "+id+" got deleted";
        }else{
            throw new ContactNotFoundException("Contact with ID: "+id+" not found!");
        }
    }
}
