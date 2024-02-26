package br.edu.unipe.pos.api.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unipe.pos.api.model.AtletaModel;
import br.edu.unipe.pos.api.repository.AtletaRepository;

@Service
public class AtletaService {

  @Autowired
  private AtletaRepository repository;

  @SuppressWarnings("null")
  public AtletaModel cadastrar(AtletaModel atleta) {
    // Neste ponto você pode fazer validações de negócio
    return repository.save(atleta);
  }

  public List<AtletaModel> listar() {
    // Neste ponto você pode fazer validações de negócio
    return repository.findAll();
  }

  public List<AtletaModel> buscarPorNome(String nome) {
    // Neste ponto você pode fazer validações de negócio
    return repository.findByNomeOrderByNomeAsc(nome);
  }

  @SuppressWarnings("null")
  public AtletaModel buscarPorId(Integer id) {
    // Neste ponto você pode fazer validações de negócio
    return repository.findById(id).orElse(null);
  }

  public AtletaModel alterar(AtletaModel atleta) {
    // Neste ponto você pode fazer validações de negócio
    if (Objects.isNull(atleta.getId())) {
      throw new RuntimeException("O id do atleta não pode ser nulo");
    }
    return repository.save(atleta);
  }

  @SuppressWarnings("null")
  public void excluir(Integer id) {
    // Neste ponto você pode fazer validações de negócio
    repository.deleteById(id);
  }
  
}
