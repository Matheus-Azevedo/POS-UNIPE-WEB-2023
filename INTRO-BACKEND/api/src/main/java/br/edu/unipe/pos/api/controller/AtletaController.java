package br.edu.unipe.pos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import br.edu.unipe.pos.api.model.AtletaModel;
import br.edu.unipe.pos.api.service.AtletaService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
 
  @GetMapping("/listar")
  public  ResponseEntity<List<AtletaModel>> listar() {
    return ResponseEntity.ok(service.listar());
  }
  
  @GetMapping("/buscar/{nome}")
  public  ResponseEntity<List<AtletaModel>> buscarPorNome(String nome) {
    return ResponseEntity.ok(service.buscarPorNome(nome));
  }

  @GetMapping("/buscar/{id}")
  public  ResponseEntity<AtletaModel> buscarPorId(Integer id) {
    return ResponseEntity.ok(service.buscarPorId(id));
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<AtletaModel> cadastrar(@RequestBody AtletaModel atleta) {
    return ResponseEntity.ok(service.cadastrar(atleta));
  }

  @PutMapping("/alterar")
  public ResponseEntity<AtletaModel> alterar(@RequestBody AtletaModel atleta) {
    return ResponseEntity.ok(service.alterar(atleta));
  }

  @DeleteMapping("/excluir/{id}")
  public ResponseEntity<Void> excluir(@RequestBody Integer id) {
    service.excluir(id);
    return ResponseEntity.ok().build();
  }
  
}
