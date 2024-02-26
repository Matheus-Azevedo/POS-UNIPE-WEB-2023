package br.edu.unipe.pos.api.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import br.edu.unipe.pos.api.validator.EmailValidation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


// For the getters and setters you can use the Lombok annotation @Getter and @Setter too
@Data
@Entity
@Table(name = "Atleta")
public class AtletaModel implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 100)
  @NotEmpty(message = "O nome do atleta é obrigatório")
  private String nome;
  
  @NotEmpty
  private String esporte;

  @Email
  @EmailValidation
  private String email;

  @CPF
  private String cpf;

  private Integer anoNascimento;


}
