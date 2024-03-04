package com.posunipe.backend.apisports.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMaperConfiguration {

  @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
  
}
