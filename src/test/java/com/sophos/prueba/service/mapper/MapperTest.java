package com.sophos.prueba.service.mapper;

import com.sophos.prueba.DummyMock;
import com.sophos.prueba.model.dto.DTOIntKanban;
import com.sophos.prueba.model.dto.DTOIntUsuario;
import com.sophos.prueba.service.IService;
import com.sophos.prueba.service.Impl.ServiceImpl;
import com.sophos.prueba.service.dto.Kanban;
import com.sophos.prueba.service.dto.Usuario;
import com.sophos.prueba.service.mapper.Impl.MapperServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MapperTest {

     private IMapperService mapperService;
     private DummyMock dummyMock;

     @Before
     public void setUp() {
          dummyMock = new DummyMock();
          mapperService = new MapperServiceImpl();
     }

     @Test
     public void testMapInCreateUsuario(){
          Usuario usuario = dummyMock.testMapIntCreateUser();
          DTOIntUsuario dtoIntUsuario = mapperService.mapIntCreateUser(dummyMock.testMapIntCreateUser());
          Assert.assertEquals(usuario.getNombre(), dtoIntUsuario.getNombre());
          Assert.assertEquals(usuario.getApellido(), dtoIntUsuario.getApellido());
          Assert.assertEquals(usuario.getTelefono(), dtoIntUsuario.getTelefono());
          Assert.assertEquals(usuario.getEmail(), dtoIntUsuario.getEmail());
          Assert.assertEquals(usuario.getPassword(), dtoIntUsuario.getPassword());
     }

     @Test
     public void testMapInLogin(){
          DTOIntUsuario dtoIntUsuario = dummyMock.testMapOutCreateUser();
          Usuario usuario = mapperService.mapOutLogin(dtoIntUsuario);
          Assert.assertEquals(dtoIntUsuario.getEmail(), usuario.getEmail());
          Assert.assertEquals(dtoIntUsuario.getNombre(), usuario.getNombre());
          Assert.assertEquals(dtoIntUsuario.getApellido(), usuario.getApellido());
          Assert.assertEquals(dtoIntUsuario.getPassword(), usuario.getPassword());
     }

     @Test
     public void testMapInCreateTask(){
          Kanban kanban = dummyMock.testMapCreateKanban();
          DTOIntKanban dtoIntKanban = mapperService.mapIntCreateTask(kanban);
          Assert.assertEquals(kanban.getNombreTarea(), dtoIntKanban.getNombreTarea());
          Assert.assertEquals(kanban.getDescripcionTarea(), dtoIntKanban.getDescripcionTarea());
          Assert.assertEquals(kanban.getEstadoTarea(), dtoIntKanban.getEstadoTarea());
          Assert.assertEquals(kanban.getCodigoTarea(), dtoIntKanban.getCodigoTarea());
     }

     @Test
     public void testMamListTask(){
          List<DTOIntKanban> kanbanList = dummyMock.testMapListKanban();
          List<Kanban> usuarios = mapperService.mapOutListTasks(kanbanList);
          Assert.assertEquals(kanbanList.get(0).getNombreTarea(), usuarios.get(0).getNombreTarea());
          Assert.assertEquals(kanbanList.get(0).getDescripcionTarea(), usuarios.get(0).getDescripcionTarea());
          Assert.assertEquals(kanbanList.get(0).getEstadoTarea(), usuarios.get(0).getEstadoTarea());
          Assert.assertEquals(kanbanList.get(0).getCodigoTarea(), usuarios.get(0).getCodigoTarea());
          Assert.assertEquals(kanbanList.get(0).getId(), usuarios.get(0).getId());
     }
}
