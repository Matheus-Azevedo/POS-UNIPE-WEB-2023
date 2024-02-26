package br.edu.unipe.pos.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.unipe.pos.api.dto.ClubeDTO;

@FeignClient(value = "clube-dos-meus-sonhos", url = "https://clube-dos-meus-sonhos.herokuapp.com/")
public interface ClubeClient {
  
  @GetMapping("/clube/{nome}")
  ClubeDTO buscarClubeExternoPorNome(@PathVariable("nome") String nome);
}
