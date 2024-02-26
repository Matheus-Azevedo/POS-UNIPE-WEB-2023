package br.edu.unipe.pos.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unipe.pos.api.dto.ClubeDTO;
import br.edu.unipe.pos.api.repository.ClubeRepository;

@Service
public class ClubeService {

  @Autowired
  private ClubeRepository repository;
  
  @SuppressWarnings("null")
  public ClubeDTO cadastrar(ClubeDTO clube) {
    // Neste ponto você pode fazer validações de negócio
    return repository.save(clube);
  }

  @SuppressWarnings("null")
  public ClubeDTO buscarPorId(Integer id) {
    // Neste ponto você pode fazer validações de negócio
    return repository.findById(id).orElse(null);
  }

  public ClubeDTO alterar(ClubeDTO clube) {
    // Neste ponto você pode fazer validações de negócio
    if (clube.getId() == null) {
      throw new RuntimeException("O id do clube não pode ser nulo");
    }
    return repository.save(clube);
  }

  @SuppressWarnings("null")
  public void excluir(Integer id) {
    // Neste ponto você pode fazer validações de negócio
    repository.deleteById(id);
  }

  public List<ClubeDTO> buscarTodos() {
    // Neste ponto você pode fazer validações de negócio
    return repository.findAll();
  }

  public List<ClubeDTO> buscarPorNome(String nome) {
    // Neste ponto você pode fazer validações de negócio
    return repository.findByNomeOrderByNomeAsc(nome);
  }
  
}
