package br.edu.unipe.pos.api.dto;

import lombok.Data;

@Data
public class AtletaDTO {
    
    private Integer id;
    private String nome;
    private String esporte;
    private String email;
    private String cpf;
    private Integer anoNascimento;
  
}
