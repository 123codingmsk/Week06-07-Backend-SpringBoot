package com.example;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MessageClass{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
}
