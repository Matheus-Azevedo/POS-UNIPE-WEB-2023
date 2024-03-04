package com.posunipe.backend.apisports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posunipe.backend.apisports.model.ClubeModel;
import com.posunipe.backend.apisports.repository.ClubeRepository;

@Service
public class ClubeService {

  @Autowired
  private ClubeRepository repository;

  public ClubeModel cadastrar(ClubeModel clube){
    return repository.save(clube);
  }

  public ClubeModel alterar(ClubeModel clube){
    if(clube.getId() == null){
      throw new RuntimeException();
    }
    return repository.save(clube);
  }

  public void deletar(Integer id){
    repository.deleteById(id);
  }

  public ClubeModel consultarPorId(Integer id){
    return repository.findById(id)
            .orElseThrow(RuntimeException::new);
  }

  public List<ClubeModel> listar(){
    return repository.findAll();
  }

  public List<ClubeModel> listarPorNome(String nome){
    return repository.findByNomeOrderByNomeAsc(nome);
  }
  
}
