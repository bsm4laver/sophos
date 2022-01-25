package com.sophos.prueba.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Usuario {

     @Getter
     @Setter
     private Integer id;
     @Getter @Setter
     private String nombre;
     @Getter @Setter
     private String apellido;
     @Getter @Setter
     private String email;
     @Getter @Setter
     private String telefono;
     @Getter @Setter
     private String password;
}
