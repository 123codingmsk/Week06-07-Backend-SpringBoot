package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImp implements com.example.Service {

    @Autowired
    private Repo repo;

    @Override
    public List<MessageClass> getAll() {
        return repo.findAll();
    }

    @Override
    public MessageClass addMsg(Person person) {
        MessageClass msg = new MessageClass();
        msg.setMessage("Hello " + person.getFirstName() + " " + person.getLastName());
        return repo.save(msg);
    }

    @Override
    public MessageClass getMsgById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public MessageClass editMsgById(Long id, String message){
        return repo.findById(id).map(existed->{
            existed.setMessage(message);
            return repo.save(existed);
        }).orElse(null);
    }

    @Override
    public String deleteById(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Message with ID: "+id+" got deleted!";
        }else{
            return "Message with ID: "+id+" not found!";
        }
    }
}
