package br.edu.unipe.pos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import br.edu.unipe.pos.api.client.AtletaClient;
import br.edu.unipe.pos.api.client.ViaCepClient;
import br.edu.unipe.pos.api.dto.AtletaDTO;
import br.edu.unipe.pos.api.dto.CepResponseDTO;
import br.edu.unipe.pos.api.service.AtletaService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/atleta")
public class AtletaController {

  @Autowired
  private AtletaService service;

  @Autowired
  private ViaCepClient viaCepClient;

  @Autowired
  private AtletaClient atletaClient;

  // Consultas externas

  @GetMapping("/cep/{cep}")
  public ResponseEntity<CepResponseDTO> consultaCep(@PathVariable String cep) {
    return ResponseEntity.ok(viaCepClient.consultaCep(cep));
  }

  @GetMapping("/integracao")
  public ResponseEntity<List<AtletaDTO>> listar(@PathVariable String cep) {
    return ResponseEntity.ok(atletaClient.listarAtleta());
  }
  
  // CRUD

  @GetMapping("/listar")
  public  ResponseEntity<List<AtletaDTO>> listar() {
    return ResponseEntity.ok(service.listar());
  }
  
  @GetMapping("/buscar/{nome}")
  public  ResponseEntity<List<AtletaDTO>> buscarPorNome(@PathVariable String nome) {
    return ResponseEntity.ok(service.buscarPorNome(nome));
  }

  @GetMapping("/buscar/{id}")
  public  ResponseEntity<AtletaDTO> buscarPorId(Integer id) {
    return ResponseEntity.ok(service.buscarPorId(id));
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<AtletaDTO> cadastrar(@RequestBody AtletaDTO atleta) {
    return ResponseEntity.ok(service.cadastrar(atleta));
  }

  @PutMapping("/alterar")
  public ResponseEntity<AtletaDTO> alterar(@RequestBody AtletaDTO atleta) {
    return ResponseEntity.ok(service.alterar(atleta));
  }

  @DeleteMapping("/excluir/{id}")
  public ResponseEntity<Void> excluir(@RequestBody Integer id) {
    service.excluir(id);
    return ResponseEntity.ok().build();
  }
  
}
