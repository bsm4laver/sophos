package com.sophos.prueba.service.mapper;

import com.sophos.prueba.model.dto.DTOIntKanban;
import com.sophos.prueba.model.dto.DTOIntUsuario;
import com.sophos.prueba.service.dto.Kanban;
import com.sophos.prueba.service.dto.Usuario;

import java.util.List;

public interface IMapperService {

     Usuario mapOutLogin (DTOIntUsuario dtoIntUsuario);
     DTOIntUsuario mapIntCreateUser(Usuario usuario);
     DTOIntKanban mapIntCreateTask(Kanban kanban);
     List<Kanban> mapOutListTasks(List<DTOIntKanban> dtoIntKanban);

}
