package com.sophos.prueba.service;

import com.sophos.prueba.model.dto.DTOIntKanban;
import com.sophos.prueba.service.dto.Kanban;
import com.sophos.prueba.service.dto.Usuario;

import java.util.List;

public interface IService {

     Usuario loginUser(Usuario usuario);
     void createUser(Usuario usuario);
     void createTask(Kanban kanban);
     List<Kanban> listTask();
     void updateKanban(Kanban kanban, String id);
     void removeTask(String codigoTarea);
}
