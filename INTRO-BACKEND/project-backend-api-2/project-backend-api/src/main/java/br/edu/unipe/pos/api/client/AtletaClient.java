package br.edu.unipe.pos.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.unipe.pos.api.dto.CepResponseDTO;
import br.edu.unipe.pos.api.model.AtletaModel;

@FeignClient(value = "atleta-gambi", url = "https://localhost:9090")
public interface AtletaClient {

    @GetMapping("/atleta/{cep}")
    CepResponseDTO consultaCep(@PathVariable("cep") String cep);

    @GetMapping("/atleta")
    List<AtletaModel> listarAtleta();

}
