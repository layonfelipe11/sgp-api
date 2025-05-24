package com.sgp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgp.api.model.Tarefa;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefa, Long> {
    
}
