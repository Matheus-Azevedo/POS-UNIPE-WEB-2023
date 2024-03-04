package com.posunipe.backend.apisports.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.posunipe.backend.apisports.dto.CepResponseDTO;


@FeignClient(value = "viacep", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping("{cep}/json")
    CepResponseDTO consultarCep(@PathVariable("cep") String cep);

}
