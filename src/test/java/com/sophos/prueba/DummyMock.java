package com.sophos.prueba;

import com.sophos.prueba.model.dto.DTOIntKanban;
import com.sophos.prueba.model.dto.DTOIntUsuario;
import com.sophos.prueba.service.dto.Kanban;
import com.sophos.prueba.service.dto.Usuario;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DummyMock {


    public Usuario testMapIntCreateUser(){
         Usuario usuario = new Usuario();
         usuario.setNombre("Brayan");
         usuario.setApellido("Malaver");
         usuario.setTelefono("3209764353");
         usuario.setEmail("bsmalaver@gmail.com");
         usuario.setPassword("123456");
         return usuario;
    }

    public DTOIntUsuario testMapOutCreateUser(){
         DTOIntUsuario dtoIntUsuario = new DTOIntUsuario();
         dtoIntUsuario.setNombre("Brayan");
         dtoIntUsuario.setApellido("Malaver");
         dtoIntUsuario.setTelefono("3209764353");
         dtoIntUsuario.setEmail("bsmalaver@gmail.com");
         dtoIntUsuario.setPassword("123456");
         return dtoIntUsuario;
    }

     public Kanban testMapCreateKanban(){
          Kanban kanban = new Kanban();
          kanban.setNombreTarea("Analisis");
          kanban.setDescripcionTarea("Analisis de datos");
          kanban.setEstadoTarea("En progreso");
          kanban.setCodigoTarea("CA25361");
          return kanban;
     }

     public DTOIntKanban testMapOutCreateKanban(){
          DTOIntKanban dtoIntKanban = new DTOIntKanban();
          dtoIntKanban.setNombreTarea("Analisis");
          dtoIntKanban.setDescripcionTarea("Analisis de datos");
          dtoIntKanban.setEstadoTarea("En progreso");
          dtoIntKanban.setCodigoTarea("CA25361");
          return dtoIntKanban;
     }

     public List<DTOIntKanban> testMapListKanban(){
          List<DTOIntKanban> kanbanList = new ArrayList<>();
          DTOIntKanban dtoIntKanban = new DTOIntKanban();
          dtoIntKanban.setId(1);
          dtoIntKanban.setNombreTarea("Analisis");
          dtoIntKanban.setDescripcionTarea("Analizar datos");
          dtoIntKanban.setEstadoTarea("En progeso");
          dtoIntKanban.setCodigoTarea("CA23456");
          kanbanList.add(dtoIntKanban);
          return kanbanList;
     }

}
