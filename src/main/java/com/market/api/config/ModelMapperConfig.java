package com.market.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
//    public ModelMapper ModelMapperConfig() { return new ModelMapper(); }

  public static ModelMapper ModelMapperConfig() {
    return new ModelMapper();
  }

}
