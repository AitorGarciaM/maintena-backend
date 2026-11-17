package com.maintena.maintena_backend.Converters;

import com.maintena.maintena_backend.Enums.State;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<State, String> {
  
  @Override 
  public String convertToDatabaseColumn(State state) {
    if(state == null) {
      return null;
    }

    return state.getCode();
  }

  @Override 
  public State convertToEntityAttribute(String code) {
    if(code == null) {
      return null;
    }

    return Stream.of(State.values()).filter(e -> e.getCode().equals(code)).findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown state" + code));
  }
}
