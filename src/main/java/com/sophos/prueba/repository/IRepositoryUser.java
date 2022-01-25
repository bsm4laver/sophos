package com.sophos.prueba.repository;

import com.sophos.prueba.model.dto.DTOIntUsuario;
import com.sophos.prueba.service.dto.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryUser extends JpaRepository<DTOIntUsuario, Integer> {

     DTOIntUsuario findAllByEmail(String email);
}
