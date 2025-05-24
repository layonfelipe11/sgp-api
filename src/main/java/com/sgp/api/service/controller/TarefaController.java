package com.sgp.api.service.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgp.api.model.Tarefa;
import com.sgp.api.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    
    @Autowired
    private TarefaService tarefaService;
    
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas(){
        return ResponseEntity.ok().body(tarefaService.carregarTarefas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tarefa>> buscarTarefa(@PathVariable("id") Long id){

        Optional<Tarefa> tarefa = tarefaService.carregarDadosTarefaPeloId(id);

        if (tarefa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

            return ResponseEntity.ok().body(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable("id") Long id){

        Optional<Tarefa> tarefa = tarefaService.carregarDadosTarefaPeloId(id);

        if (tarefa.isEmpty()) {
            return ResponseEntity.notFound().build(); 
        }


            tarefaService.deletarTarefa(id);
            return ResponseEntity.noContent().build();



    }

}
