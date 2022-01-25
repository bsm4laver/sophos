package com.sophos.prueba.repository;

import com.sophos.prueba.model.dto.DTOIntKanban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryKanban extends JpaRepository<DTOIntKanban, Integer> {

     DTOIntKanban findByCodigoTarea(String codigo);
}
