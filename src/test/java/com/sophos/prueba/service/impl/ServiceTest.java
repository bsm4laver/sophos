package com.sophos.prueba.service.impl;

import com.sophos.prueba.DummyMock;
import com.sophos.prueba.repository.IRepositoryKanban;
import com.sophos.prueba.repository.IRepositoryUser;
import com.sophos.prueba.service.Impl.ServiceImpl;
import com.sophos.prueba.service.dto.Kanban;
import com.sophos.prueba.service.mapper.Impl.MapperServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

     private DummyMock dummyMock;

     @Mock
     private IRepositoryUser iRepositoryUser;

     @Mock
     private IRepositoryKanban iRepositoryKanban;

     @Mock
     private MapperServiceImpl mapperService;

     @InjectMocks
     private ServiceImpl service;

     @Before
     public void setUp() throws Exception {
          MockitoAnnotations.initMocks(this);
          dummyMock = new DummyMock();
          mapperService = new MapperServiceImpl();
     }

     @Test
     public void testServiceCreateUser(){
          service.createUser(dummyMock.testMapIntCreateUser());
     }

     @Test
     public void testServiceCreateTask(){
          service.createTask(dummyMock.testMapCreateKanban());
     }

     @Test
     public void testListTask(){
          Mockito.when(iRepositoryKanban.findAll()).thenReturn(dummyMock.testMapListKanban());
          List<Kanban> kanbanList =service.listTask();
          Assert.assertNotNull(kanbanList);
     }

     @Test
     public void testUpdateProduct() {
          Mockito.when(iRepositoryKanban.findByCodigoTarea("CA42523")).thenReturn(dummyMock.testMapOutCreateKanban());
          service.updateKanban(dummyMock.testMapCreateKanban(), "CA42523");
     }

     @Test
     public void testDeleteProduct() {
          Mockito.when(iRepositoryKanban.findByCodigoTarea("CA42523")).thenReturn(dummyMock.testMapOutCreateKanban());
          service.removeTask("CA42523");
     }
}
