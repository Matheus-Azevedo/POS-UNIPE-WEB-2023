package com.posunipe.backend.apisports.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posunipe.backend.apisports.client.ClubeClient;
import com.posunipe.backend.apisports.dto.ClubeDTO;
import com.posunipe.backend.apisports.model.ClubeModel;
import com.posunipe.backend.apisports.service.ClubeService;

@RestController
@RequestMapping("/clube")
public class ClubeController {

  @Autowired
  private ClubeService service;

  // @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private ClubeClient clubeClient;

  // Métodos CRUD

  @PostMapping("/cadastrar")
  public ResponseEntity<ClubeDTO> cadastrar(@RequestBody ClubeModel clube){
    ClubeModel clubeCadastrado = service.cadastrar(clube);
    ClubeDTO clubeDTO = modelMapper.map(clubeCadastrado, ClubeDTO.class); // Converta o modelo em DTO
    return ResponseEntity.ok(clubeDTO);
  }

  @PutMapping("/alterar")
  public ResponseEntity<ClubeDTO> alterar(@RequestBody ClubeModel clube){
    ClubeModel clubeAlterado = service.alterar(clube);
    ClubeDTO clubeDTO = modelMapper.map(clubeAlterado, ClubeDTO.class); // Converta o modelo em DTO
    return ResponseEntity.ok(clubeDTO);
  }

  @DeleteMapping("/deletar/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Integer id){
    service.deletar(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/buscar/{id}")
  public ResponseEntity<ClubeDTO> consultarPorId(@PathVariable Integer id){
    ClubeModel clubeEncontrado = service.consultarPorId(id);
    ClubeDTO clubeDTO = modelMapper.map(clubeEncontrado, ClubeDTO.class); // Converta o modelo em DTO
    return ResponseEntity.ok(clubeDTO);
  }

  @GetMapping("/buscar/todos")
  public ResponseEntity<List<ClubeDTO>> listarTodos(){
    List<ClubeModel> clubes = service.listar();
    List<ClubeDTO> clubesDTO = clubes
                                .stream()
                                .map(clube -> modelMapper.map(clube, ClubeDTO.class))
                                .collect(Collectors.toList());
    return ResponseEntity.ok(clubesDTO);
  }

  @GetMapping("/buscar/nome/{nome}")
  public ResponseEntity<List<ClubeDTO>> listarPorNome(@PathVariable String nome){
    List<ClubeModel> clubes = service.listarPorNome(nome);
    List<ClubeDTO> clubesDTO = clubes
                                .stream()
                                .map(clube -> modelMapper.map(clube, ClubeDTO.class))
                                .collect(Collectors.toList());
    return ResponseEntity.ok(clubesDTO);
  }
  
  // Consulta externa

  @GetMapping("/clube/{clube}")
  public ResponseEntity<ClubeDTO> consultarCepAtleta(@PathVariable String clube){
      var cepResponse = clubeClient.consultarClube(clube);
      return ResponseEntity.ok(cepResponse);
  }
}
