package br.edu.unipe.pos.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unipe.pos.api.model.CampeonatoModel;
import br.edu.unipe.pos.api.repository.CampeonatoRepository;

@Service
public class CampeonatoService {
  
  @Autowired
  private CampeonatoRepository repository;

  @SuppressWarnings("null")
  public CampeonatoModel cadastrar(CampeonatoModel campeonato) {
    // Neste ponto você pode fazer validações de negócio
    return repository.save(campeonato);
  }

  public List<CampeonatoModel> buscarTodos() {
    // Neste ponto você pode fazer validações de negócio
    return repository.findAll();
  }

  @SuppressWarnings("null")
  public CampeonatoModel buscarPorId(Integer id) {
    // Neste ponto você pode fazer validações de negócio
    return repository.findById(id).orElse(null);
  }

  public CampeonatoModel alterar(CampeonatoModel campeonato) {
    // Neste ponto você pode fazer validações de negócio
    if (campeonato.getId() == null) {
      throw new RuntimeException("O id do campeonato não pode ser nulo");
    }
    return repository.save(campeonato);
  }

  @SuppressWarnings("null")
  public void excluir(Integer id) {
    // Neste ponto você pode fazer validações de negócio
    repository.deleteById(id);
  }
}
