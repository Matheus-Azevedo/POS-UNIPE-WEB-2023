package com.posunipe.backend.apisports.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubeDTO {
  
    private Integer id;
    private String nome;
    private String estado;
    private String email;
    private String cnpj;
    private String dataCriacao;
}
