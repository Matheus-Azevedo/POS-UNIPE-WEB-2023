package br.edu.unipe.pos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unipe.pos.api.model.CampeonatoModel;

@Repository
public interface CampeonatoRepository extends JpaRepository<CampeonatoModel, Integer>{

}
