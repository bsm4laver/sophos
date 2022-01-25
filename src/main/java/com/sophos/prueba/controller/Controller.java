package com.sophos.prueba.controller;

import com.sophos.prueba.service.IService;
import com.sophos.prueba.service.dto.Kanban;
import com.sophos.prueba.service.dto.Usuario;
import com.sophos.prueba.utils.JWT;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

     @Autowired
     private IService service;

     @Autowired
     private JWT jwt;


     @PostMapping("/sophos/login")
     public String loginUsuario(@RequestBody Usuario usuario) {
          Usuario user = service.loginUser(usuario);
          if (user != null) {
               return "TRUE";
          }
          return "FAIL";
     }

     @PostMapping("/sophos/user")
     public void createUsuario(@RequestBody Usuario usuario){
          Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
          usuario.setPassword(argon2.hash(1, 1024, 1, usuario.getPassword()));
          service.createUser(usuario);
     }

     @PostMapping("/sophos/task")
     public void createTask(@RequestBody Kanban kanban){
          service.createTask(kanban);
     }

     @GetMapping("/sophos/tasks")
     public List<Kanban> listTasks(){
          return service.listTask();
     }

     @PatchMapping("/sophos/taks/{id}")
     public void updateTask(@PathVariable String id,
                              @RequestBody Kanban kanban){
          service.updateKanban(kanban, id);
     }

     @DeleteMapping("/sophos/task/{codigoTarea}")
     public ResponseEntity<String> deleteProduct(@PathVariable String codigoTarea){
          service.removeTask(codigoTarea);
          return ResponseEntity.ok().build();
     }
}