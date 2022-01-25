package com.sophos.prueba.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@ToString
public class DTOIntUsuario {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Getter
     @Setter
     @Column(name = "id")
     private Integer id;
     @Getter @Setter @Column(name = "nombre")
     private String nombre;
     @Getter @Setter @Column(name = "apellido")
     private String apellido;
     @Getter @Setter @Column(name = "email")
     private String email;
     @Getter @Setter @Column(name = "telefono")
     private String telefono;
     @Getter @Setter @Column(name = "password")
     private String password;
}
