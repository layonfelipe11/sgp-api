package com.sgp.api.model;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sgp.api.constants.StatusUsuario;
import com.sgp.api.dto.UsuarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String nome;

    @NotNull
    @Pattern(
        regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}",
        message = "O campo 'cpf' deve estar no formato xxx.xxx.xxx-xx"
    )
    @Column(nullable = false, unique = true)
    private String cpf;

    @Pattern(
        regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
        message = "Email invalido."
    )
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 19)
    private String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    public UsuarioDTO converterParaDto(){
         UsuarioDTO dto = new UsuarioDTO();

            dto.setId(id);
            dto.setNome(nome);
            dto.setEmail(email);
            dto.setCpf(cpf);
            dto.setDataNascimento(dataNascimento);
            dto.setStatus(status);

            LocalDate dataAtual = LocalDate.now();

            Period periodo = Period.between(dataNascimento, dataAtual);

            dto.setIdade(periodo.getYears());
            return dto;
        }

}
