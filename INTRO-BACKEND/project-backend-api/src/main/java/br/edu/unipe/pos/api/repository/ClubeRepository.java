package br.edu.unipe.pos.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unipe.pos.api.dto.ClubeDTO;

@Repository
public interface ClubeRepository extends JpaRepository<ClubeDTO, Integer>{
  // Criar uma chamada no repository de clube uma listagem que ordene pelo nome do clube de forma ascendente.

  public List<ClubeDTO> findByNomeOrderByNomeAsc(String nome);
}
