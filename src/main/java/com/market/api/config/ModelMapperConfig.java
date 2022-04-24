package com.market.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

/**
 * The type Model mapper config.
 */
@Configuration
public class ModelMapperConfig {
//    public ModelMapper ModelMapperConfig() { return new ModelMapper(); }

  /**
   * Model mapper config model mapper.
   *
   * @return the model mapper
   */
  public static ModelMapper ModelMapperConfig() {
    return new ModelMapper();
  }

}
