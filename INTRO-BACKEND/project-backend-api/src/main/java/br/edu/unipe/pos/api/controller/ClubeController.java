package br.edu.unipe.pos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unipe.pos.api.client.ClubeClient;
import br.edu.unipe.pos.api.dto.ClubeDTO;
import br.edu.unipe.pos.api.service.ClubeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/clube")
public class ClubeController {

  @Autowired
  private ClubeService service;

  @Autowired
  private ClubeClient clubeClient;

  // CRUD

  @GetMapping("/buscar")
  public ResponseEntity<List<ClubeDTO>> buscarTodos() {
    return ResponseEntity.ok(service.buscarTodos());
  }

  @GetMapping("/buscar/{id}")
  public ResponseEntity<ClubeDTO> buscarPorId(@RequestParam Integer id) {
      return ResponseEntity.ok(service.buscarPorId(id));
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<ClubeDTO> cadastrar(@RequestParam ClubeDTO clube) {
      return ResponseEntity.ok(service.cadastrar(clube));
  }

  @PutMapping("/alterar")
  public ResponseEntity<ClubeDTO> alterar(@RequestParam ClubeDTO clube) {
      return ResponseEntity.ok(service.alterar(clube));
  }

  @DeleteMapping("/excluir/{id}")
  public ResponseEntity<Void> excluir(@RequestParam Integer id) {
    service.excluir(id);
    return ResponseEntity.ok().build();
  }
  
  @GetMapping("/buscar/nome")
  public ResponseEntity<List<ClubeDTO>> buscarPorNome(@RequestParam String nome) {
    return ResponseEntity.ok(service.buscarPorNome(nome));
  }

  // Consultas externas

  @GetMapping("/clube/{nome}")
  public ResponseEntity<ClubeDTO> buscarClubeExternoPorNome(@RequestParam String nome) {
    return ResponseEntity.ok(clubeClient.buscarClubeExternoPorNome(nome));
  }
}
