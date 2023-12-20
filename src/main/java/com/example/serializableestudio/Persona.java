package com.example.serializableestudio;

import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Setter
@ToString
public class Persona implements Serializable {

    @Serial
    // private static final long serialVersionUID = 3457911541638393113L;
    private static final long serialVersionUID = -3152424149383682736L;
    
    private int edad;
    
    private String nombre;
    
    // esta propiedad no se convertirá a byte
    private transient String ciudad;
    
    // la clase de esta propiedad debe implementar Serializable también o fallará al serializar esta clase
    private Animal animalDomestico;
    
    public static String pais = "españa";
}
