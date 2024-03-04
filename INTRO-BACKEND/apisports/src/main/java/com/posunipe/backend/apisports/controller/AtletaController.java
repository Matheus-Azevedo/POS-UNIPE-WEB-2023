package com.posunipe.backend.apisports.controller;

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

import com.posunipe.backend.apisports.dto.AtletaDTO;
import com.posunipe.backend.apisports.client.ViaCepClient;
import com.posunipe.backend.apisports.dto.CepResponseDTO;
import com.posunipe.backend.apisports.model.AtletaModel;
import com.posunipe.backend.apisports.service.AtletaService;

import java.util.List;


@RestController
@RequestMapping("/atleta")
public class AtletaController {
    
    @Autowired
    private AtletaService service;

    @Autowired
    private ViaCepClient viaCepClient;

    // Métodos CRUD

    @PostMapping("/cadastrar")
    public ResponseEntity<AtletaDTO> cadastrar(@RequestBody AtletaModel atleta){
        return ResponseEntity.ok(service.cadastrar(atleta));        
    }

    @PutMapping("/alterar")
    public ResponseEntity<AtletaDTO> alterar(@RequestBody AtletaModel atleta){
        return ResponseEntity.ok(service.alterar(atleta));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<AtletaDTO> consultarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));   
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<AtletaDTO>> listarTodos(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<AtletaDTO>> listarPorNome(@PathVariable String nome){
        return ResponseEntity.ok(service.listarPorNome(nome));   
    }

    // Consulta externa

    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepResponseDTO> consultarCepAtleta(@PathVariable String cep){
        var cepResponse = viaCepClient.consultarCep(cep);
        return ResponseEntity.ok(cepResponse);
    }

}
