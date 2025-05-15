package org.example.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    List<Contact> contactList = new ArrayList<>();

    public List<Contact> getAllContacts(){
        return contactList;
    }

    public Contact getContactById(int id){
        for(Contact c : contactList){
            if(c.getId() == id){
                return c;
            }
        }
        throw new ContactNotFoundException("Contact with ID: "+id+" not found!");
    }

    public Contact addContact(Contact contact){
        contactList.add(contact);
        return contact;
    }

    public Contact updateContact(int id, Contact updatedContact){
        for(Contact c : contactList){
            if(c.getId() == id){
                c.setName(updatedContact.getName());
                c.setPhoneNum(updatedContact.getPhoneNum());
                c.setAddress(updatedContact.getAddress());
                return c;
            }
        }
        throw new ContactNotFoundException("Contact with ID: "+id+" not found!");
    }

    public String deleteContact(int id){
        Iterator<Contact> it = contactList.iterator();

        while(it.hasNext()){
            Contact c = it.next();
            if(c.getId() == id){
                it.remove();
                return "String with id: "+id+" got deleted";
            }
        }
        throw new ContactNotFoundException("Contact with ID: "+id+" not found!");
    }
}
