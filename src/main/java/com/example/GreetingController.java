package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controls")
public class GreetingController {

    @Autowired
    private ServiceImp service;

    @GetMapping
    public List<MessageClass> getAllMsgs() {
        return service.getAll();
    }

    @PostMapping
    public MessageClass addMsgData(@RequestBody Person person) {
        return service.addMsg(person);
    }

    @GetMapping("/{id}")
    public MessageClass getMsgByID(@PathVariable Long id){
        return service.getMsgById(id);
    }

    @PutMapping("/put/{id}")
    public MessageClass editMsg(@PathVariable Long id, @RequestBody MessageClass message){
        return service.editMsgById(id, message.getMessage());
    }

    @DeleteMapping("/del/{id}")
    public String delMsg(@PathVariable Long id){
        return service.deleteById(id);
    }
}
