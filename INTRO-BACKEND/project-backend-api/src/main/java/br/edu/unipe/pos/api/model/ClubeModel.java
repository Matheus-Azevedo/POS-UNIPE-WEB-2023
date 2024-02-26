package br.edu.unipe.pos.api.model;

import org.hibernate.validator.constraints.br.CNPJ;

import br.edu.unipe.pos.api.validator.EmailValidation;
import br.edu.unipe.pos.api.validator.NameValidation;
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
@Table(name = "Clube")
public class ClubeModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotEmpty(message = "O nome do clube é obrigatório")
  @NotNull
  @NameValidation
  private String nome;

  @NotEmpty(message = "O estado do clube é obrigatório")
  @NotNull
  private String estado;

  @Email
  @EmailValidation
  @NotNull
  private String email;

  @CNPJ
  @NotNull
  private String cnpj;

  @NotEmpty(message = "O ano de fundação do clube é obrigatório")
  @NotNull
  private Integer anoFundacao;
  
}
