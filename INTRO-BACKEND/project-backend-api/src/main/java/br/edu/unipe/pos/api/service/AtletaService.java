package br.edu.unipe.pos.api.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unipe.pos.api.dto.AtletaDTO;
import br.edu.unipe.pos.api.repository.AtletaRepository;

@Service
public class AtletaService {

  @Autowired
  private AtletaRepository repository;

  @SuppressWarnings("null")
  public AtletaDTO cadastrar(AtletaDTO atleta) {
    // Neste ponto você pode fazer validações de negócio
    return repository.save(atleta);
  }

  public List<AtletaDTO> listar() {
    // Neste ponto você pode fazer validações de negócio
    return repository.findAll();
  }

  public List<AtletaDTO> buscarPorNome(String nome) {
    // Neste ponto você pode fazer validações de negócio
    return repository.findByNomeOrderByNomeAsc(nome);
  }

  @SuppressWarnings("null")
  public AtletaDTO buscarPorId(Integer id) {
    // Neste ponto você pode fazer validações de negócio
    return repository.findById(id).orElse(null);
  }

  public AtletaDTO alterar(AtletaDTO atleta) {
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
