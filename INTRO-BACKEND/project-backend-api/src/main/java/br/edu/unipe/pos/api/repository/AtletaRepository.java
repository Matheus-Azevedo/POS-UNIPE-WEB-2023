package br.edu.unipe.pos.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unipe.pos.api.dto.AtletaDTO;

@Repository
public interface AtletaRepository extends JpaRepository<AtletaDTO, Integer>{

  public List<AtletaDTO> findByNomeOrderByNomeAsc(String nome);

  @Query("SELECT a FROM AtletaModel a WHERE a.nome = :nome ORDER BY a.nome DESC")
  public List<AtletaDTO> buscarPorNomeEmOrdemDesc(@Param("nome") String nome);
  
}
