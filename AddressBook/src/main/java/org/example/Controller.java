package org.example;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/addressBook")
public class Controller {

    @Autowired
    Service service;

    @GetMapping
    public List<Contact> getAllContacts() {
        return service.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable int id) {
        return service.getContactById(id);
    }

    @PostMapping
    public Contact addContact(@Valid @RequestBody Contact contact) {
        return service.addContact(contact);
    }

    @PutMapping("/put/{id}")
    public Contact updateContact(@PathVariable int id,
                                 @Valid @RequestBody Contact updatedContact) {
        return service.updateContact(id, updatedContact);
    }

    @DeleteMapping("/del/{id}")
    public String deleteContact(@PathVariable int id) {
        return service.deleteContact(id);
    }
}
