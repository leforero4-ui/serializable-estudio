package com.example.serializableestudio;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
@AllArgsConstructor
public class Animal implements Serializable {
    
    private String nombre;
}
