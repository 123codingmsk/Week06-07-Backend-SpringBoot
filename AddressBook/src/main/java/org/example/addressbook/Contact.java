package org.example.addressbook;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Contact {
    private int id;
    static int counter = 1;
    @NotBlank(message = "Name is empty? Try to fill it bro")
    private String name;
    @NotNull(message = "Give your PhoneNumber Man")
    private long phoneNum;
    @NotBlank(message = "Give your address Please!")
    private String address;

    public Contact(String name, long phoneNum, String address){
        this.id = counter++;
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
    }
}
