package com.posunipe.backend.apisports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posunipe.backend.apisports.model.ClubeModel;

public interface ClubeRepository extends JpaRepository<ClubeModel, Integer> {

    public List<ClubeModel> findByNomeOrderByNomeAsc(String nome);

}
