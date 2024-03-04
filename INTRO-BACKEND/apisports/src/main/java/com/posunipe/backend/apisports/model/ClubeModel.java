package com.posunipe.backend.apisports.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CNPJ;

import com.posunipe.backend.apisports.validator.EmailValidation;
import com.posunipe.backend.apisports.validator.NameValidation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "clube")
public class ClubeModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @NotNull
    @NameValidation
    private String nome;

    @NotEmpty
    @NotNull
    private String estado;

    @NotEmpty
    @NotNull
    @Email
    @EmailValidation
    private String email;

    @NotEmpty
    @NotNull
    @CNPJ
    private String cnpj;

    @NotEmpty
    @NotNull
    private String dataCriacao;
  
}
