package br.edu.unipe.pos.api.dto;

import lombok.Data;

@Data
public class ClubeDTO {
    
    private Integer id;
    private String nome;
    private String descricao;
    private String local;
    private String dataInicio;
    private String dataFim;
  
}
