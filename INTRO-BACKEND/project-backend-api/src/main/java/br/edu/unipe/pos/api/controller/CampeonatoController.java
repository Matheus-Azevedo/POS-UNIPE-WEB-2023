package br.edu.unipe.pos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unipe.pos.api.dto.CampeonatoDTO;
import br.edu.unipe.pos.api.service.CampeonatoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/campeonato")
public class CampeonatoController {

  @Autowired
  private CampeonatoService service;

  @GetMapping("/buscar")
  public ResponseEntity<List<CampeonatoDTO>> buscarTodos() {
    return ResponseEntity.ok(service.buscarTodos());
  }
  
  @GetMapping("/buscar/{id}")
  public ResponseEntity<CampeonatoDTO> buscarPorId(@RequestParam Integer id) {
      return ResponseEntity.ok(service.buscarPorId(id));
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<CampeonatoDTO> cadastrar(@RequestBody CampeonatoDTO campeonato) {
      return ResponseEntity.ok(service.cadastrar(campeonato));
  }
  
  @PutMapping("/alterar")
  public ResponseEntity<CampeonatoDTO> alterar(@RequestBody CampeonatoDTO campeonato) {
      return ResponseEntity.ok(service.alterar(campeonato));
  }

  @DeleteMapping("/excluir/{id}")
  public ResponseEntity<Void> excluir(@RequestBody Integer id) {
    service.excluir(id);
    return ResponseEntity.ok().build();
  }
  
}
