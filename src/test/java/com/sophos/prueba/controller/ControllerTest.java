package com.sophos.prueba.controller;

import com.sophos.prueba.DummyMock;
import com.sophos.prueba.service.Impl.ServiceImpl;
import com.sophos.prueba.service.mapper.Impl.MapperServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

     private DummyMock dummyMock;

     @Mock
     private ServiceImpl service;

     @Mock
     private MapperServiceImpl mapperService;

     @InjectMocks
     private Controller controller;

     @Before
     public void setUp() throws Exception{
          dummyMock = new DummyMock();
          mapperService = new MapperServiceImpl();
     }

     @Test
     public void testCreateProduct(){
          controller.createUsuario(dummyMock.testMapIntCreateUser());
     }

     @Test
     public void testLoginUser(){
          controller.loginUsuario(dummyMock.testMapIntCreateUser());
     }

     @Test
     public void testListTask(){
          controller.listTasks();
     }

     @Test
     public void testCreateTask(){
          controller.createTask(dummyMock.testMapCreateKanban());
     }

     @Test
     public void testUpdateTask(){
          controller.updateTask("CA23456",dummyMock.testMapCreateKanban());
     }

     @Test
     public void testDeleteTask(){
          controller.deleteProduct("CA23456");
     }
}
