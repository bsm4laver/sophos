package com.sophos.prueba.service.Impl;

import com.sophos.prueba.model.dto.DTOIntKanban;
import com.sophos.prueba.repository.IRepositoryKanban;
import com.sophos.prueba.repository.IRepositoryUser;
import com.sophos.prueba.service.IService;
import com.sophos.prueba.service.dto.Kanban;
import com.sophos.prueba.service.dto.Usuario;
import com.sophos.prueba.service.mapper.IMapperService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService {

     @Autowired
     private IRepositoryUser iRepositoryUser;

     @Autowired
     private IRepositoryKanban iRepositoryKanban;

     @Autowired
     private IMapperService iMapperService;

     @Override
     public Usuario loginUser(Usuario usuario) {
          Usuario login = iMapperService.mapOutLogin(iRepositoryUser.findAllByEmail(usuario.getEmail()));
          if(login==null){
               return null;
          }
          Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
          if(argon2.verify(login.getPassword(), usuario.getPassword())){
               return login;
          }
          return null;
     }

     @Override
     public void createUser(Usuario usuario) {
          iRepositoryUser.save(iMapperService.mapIntCreateUser(usuario));
     }

     @Override
     public void createTask(Kanban kanban) {
          iRepositoryKanban.save(iMapperService.mapIntCreateTask(kanban));
     }

     @Override
     public List<Kanban> listTask() {
          return iMapperService.mapOutListTasks(iRepositoryKanban.findAll());
     }

     @Override
     public void updateKanban(Kanban kanban, String id) {
          DTOIntKanban dtoIntKanban = iRepositoryKanban.findByCodigoTarea(id);
          if(kanban.getNombreTarea()!=null){
               dtoIntKanban.setNombreTarea(kanban.getNombreTarea());
          }
          if(kanban.getDescripcionTarea()!=null){
               dtoIntKanban.setDescripcionTarea(kanban.getDescripcionTarea());
          }
          if(kanban.getEstadoTarea()!=null){
               dtoIntKanban.setEstadoTarea(kanban.getEstadoTarea());
          }
          if(kanban.getCodigoTarea()!=null){
               dtoIntKanban.setCodigoTarea(kanban.getCodigoTarea());
          }
          iRepositoryKanban.save(dtoIntKanban);
     }

     @Override
     public void removeTask(String codigoTarea) {
          DTOIntKanban dtoIntKanban = iRepositoryKanban.findByCodigoTarea(codigoTarea);
          iRepositoryKanban.delete(dtoIntKanban);
     }


}
