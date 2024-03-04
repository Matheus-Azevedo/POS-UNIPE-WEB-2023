package com.posunipe.backend.apisports.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posunipe.backend.apisports.dto.AtletaDTO;
import com.posunipe.backend.apisports.model.AtletaModel;
import com.posunipe.backend.apisports.repository.AtletaRepository;

import java.util.List;
import java.util.Objects;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public AtletaDTO cadastrar(AtletaModel atleta){
        return modelMapper.map(repository.save(atleta), AtletaDTO.class);
    }

    public List<AtletaDTO> listar(){
        List<AtletaModel> atletas = repository.findAll();
        return atletas.stream()
                .map(atleta -> modelMapper.map(atleta, AtletaDTO.class))
                .toList();
    }

    public List<AtletaDTO> listarPorNome(String nome){
        List<AtletaModel> atletas = repository.findByNomeOrderByNomeAsc(nome);
        return atletas.stream()
                .map(atleta -> modelMapper.map(atleta, AtletaDTO.class))
                .toList();
    }

    public AtletaDTO alterar(AtletaModel atleta){
        if(Objects.isNull(atleta.getId())){
            throw new RuntimeException();
        }
        return modelMapper.map(repository.save(atleta), AtletaDTO.class);
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }

    public AtletaDTO consultarPorId(Integer id){
        return modelMapper.map(repository.findById(id).orElseThrow(), AtletaDTO.class);
    }

}
