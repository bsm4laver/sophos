package com.sophos.prueba.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "kanban")
@ToString
public class DTOIntKanban {

     @Getter
     @Setter
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer id;
     @Getter @Setter @Column( name = "nombretarea")
     private String nombreTarea;
     @Getter @Setter @Column(name = "descripciontarea")
     private String descripcionTarea;
     @Getter @Setter @Column(name = "estadotarea")
     private String estadoTarea;
     @Getter @Setter @Column(name = "codigotarea")
     private String codigoTarea;
}
