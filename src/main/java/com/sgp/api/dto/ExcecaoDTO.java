package com.sgp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcecaoDTO {
 
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    private List<String> erros;

}
