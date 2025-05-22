package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name is empty? Try to fill it bro")
    private String name;
    @NotNull(message = "Give your PhoneNumber Man")
    private long phoneNum;
    @NotBlank(message = "Give your address Please!")
    private String address;
}