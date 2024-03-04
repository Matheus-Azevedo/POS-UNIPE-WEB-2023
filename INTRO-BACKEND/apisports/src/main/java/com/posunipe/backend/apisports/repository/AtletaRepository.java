package com.posunipe.backend.apisports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.posunipe.backend.apisports.model.AtletaModel;

import java.util.List;

@Repository
public interface AtletaRepository extends JpaRepository<AtletaModel, Integer> {

    public List<AtletaModel> findByNomeOrderByNomeAsc(String nome);

    @Query("SELECT at FROM AtletaModel at WHERE at.nome = :nome ORDER BY at.nome ASC")
    public List<AtletaModel> buscarPorNome(@Param("nome") String nome);

}
