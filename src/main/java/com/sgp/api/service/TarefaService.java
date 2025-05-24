package com.sgp.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgp.api.repository.TarefasRepository;
import com.sgp.api.model.Tarefa;


@Service
public class TarefaService {
    
    @Autowired
    private TarefasRepository tarefasRepository;

    public List<Tarefa> carregarTarefas(){
        return tarefasRepository.findAll();
    }

    public Optional<Tarefa> carregarDadosTarefaPeloId(Long id){
        return tarefasRepository.findById(id);
    }

    public void deletarTarefa(Long id){
        tarefasRepository.deleteById(id);
    }
}
