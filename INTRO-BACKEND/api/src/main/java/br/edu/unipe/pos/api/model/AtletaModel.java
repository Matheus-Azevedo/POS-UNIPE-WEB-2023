package br.edu.unipe.pos.api.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
  @NotEmpty
  private String nome;
  
  private Integer anoNascimento;

  @NotEmpty
  private String esporte;

}
