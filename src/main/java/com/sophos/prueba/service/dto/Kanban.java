package com.sophos.prueba.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Kanban {

     @Getter @Setter
     private Integer id;
     @Getter @Setter
     private String nombreTarea;
     @Getter @Setter
     private String descripcionTarea;
     @Getter @Setter
     private String estadoTarea;
     @Getter @Setter
     private String codigoTarea;
}
