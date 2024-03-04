package com.posunipe.backend.apisports.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import com.posunipe.backend.apisports.validator.EmailValidation;

@Data
@Entity
@Table(name = "atleta")
public class AtletaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 150)
    @NotNull
    @NotEmpty(message = "O nome não pode ser nulo nem em branco")
    private String nome;

    @NotNull
    private Integer anoNascimento;

    @NotEmpty
    @NotNull
    private String esporte;

    @NotEmpty
    @NotNull
    @Email
    @EmailValidation
    private String email;

    @NotEmpty
    @NotNull
    @CPF
    private String cpf;

}
