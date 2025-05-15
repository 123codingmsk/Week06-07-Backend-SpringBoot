package com.example;

import java.util.List;

public interface Service{
    List<MessageClass> getAll();
    MessageClass addMsg(Person person);
    MessageClass getMsgById(Long id);
    MessageClass editMsgById(Long id, String msg);
    String deleteById(Long id);
}
