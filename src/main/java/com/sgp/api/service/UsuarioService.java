package com.sgp.api.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgp.api.dto.UsuarioDTO;
import com.sgp.api.model.Usuario;
import com.sgp.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    public List<UsuarioDTO> carregarUsuariosCadastrados() {
        // TODO: Logica adicional (ex. calcular e retornar idade)
        List<Usuario> usuarios = usuarioRepository.findAll();
    
        List<UsuarioDTO> dtos = new ArrayList<>();

        for (Usuario usuario: usuarios){
           

            dtos.add(usuario.converterParaDto());
            
        }
        return dtos;
    }

    public UsuarioDTO obterDadosUsuarioPeloId(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            return usuario.converterParaDto();
        }
        return null;

    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;
    
}