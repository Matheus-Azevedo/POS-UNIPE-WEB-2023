package com.posunipe.backend.apisports.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.posunipe.backend.apisports.dto.ClubeDTO;

@FeignClient(value = "clube", url = "https://api.api-futebol.com.br/v1/")
public interface ClubeClient {

  @GetMapping("times/{nome_popular}")
  ClubeDTO consultarClube(String clube);
  
}
