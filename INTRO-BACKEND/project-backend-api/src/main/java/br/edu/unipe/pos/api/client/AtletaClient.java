package br.edu.unipe.pos.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.unipe.pos.api.dto.AtletaDTO;
import br.edu.unipe.pos.api.dto.CepResponseDTO;

@FeignClient(value = "atleta-gambi", url = "https://localhost:9090")
public interface AtletaClient {

    @GetMapping("/atleta/cep/{cep}")
    CepResponseDTO consultaCep(@PathVariable("cep") String cep);

    @GetMapping("/atleta")
    List<AtletaDTO> listarAtleta();

}
