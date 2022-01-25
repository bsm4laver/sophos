package com.sophos.prueba.service.mapper.Impl;

import com.sophos.prueba.model.dto.DTOIntKanban;
import com.sophos.prueba.model.dto.DTOIntUsuario;
import com.sophos.prueba.service.dto.Kanban;
import com.sophos.prueba.service.dto.Usuario;
import com.sophos.prueba.service.mapper.IMapperService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "mapperServiceImpl")
public class MapperServiceImpl implements IMapperService {


     @Override
     public Usuario mapOutLogin(DTOIntUsuario dtoIntUsuario) {
          Usuario usuario = new Usuario();
          usuario.setEmail(dtoIntUsuario.getEmail());
          usuario.setNombre(dtoIntUsuario.getNombre());
          usuario.setApellido(dtoIntUsuario.getApellido());
          usuario.setPassword(dtoIntUsuario.getPassword());
          return usuario;
     }

     @Override
     public DTOIntUsuario mapIntCreateUser(Usuario usuario) {
          DTOIntUsuario dtoIntUsuario = new DTOIntUsuario();
          dtoIntUsuario.setNombre(usuario.getNombre());
          dtoIntUsuario.setApellido(usuario.getApellido());
          dtoIntUsuario.setEmail(usuario.getEmail());
          dtoIntUsuario.setTelefono(usuario.getTelefono());
          dtoIntUsuario.setPassword(usuario.getPassword());
          return dtoIntUsuario;
     }

     @Override
     public DTOIntKanban mapIntCreateTask(Kanban kanban) {
          DTOIntKanban dtoIntKanban = new DTOIntKanban();
          dtoIntKanban.setNombreTarea(kanban.getNombreTarea());
          dtoIntKanban.setDescripcionTarea(kanban.getDescripcionTarea());
          dtoIntKanban.setEstadoTarea(kanban.getEstadoTarea());
          dtoIntKanban.setCodigoTarea(kanban.getCodigoTarea());
          return dtoIntKanban;
     }

     @Override
     public List<Kanban> mapOutListTasks(List<DTOIntKanban> dtoIntKanban) {
          List<Kanban> kanbanList = new ArrayList<>();
          for(DTOIntKanban dtoIntKanbanFor : dtoIntKanban){
               Kanban kanban = new Kanban();
               kanban.setId(dtoIntKanbanFor.getId());
               kanban.setNombreTarea(dtoIntKanbanFor.getNombreTarea());
               kanban.setDescripcionTarea(dtoIntKanbanFor.getDescripcionTarea());
               kanban.setEstadoTarea(dtoIntKanbanFor.getEstadoTarea());
               kanban.setCodigoTarea(dtoIntKanbanFor.getCodigoTarea());
               kanbanList.add(kanban);
          }
          return kanbanList;
     }

}
