package com.maintena.maintena_backend.Enums;

public enum State {
  OPERATIVE("OPERATIVE"),
  UNDER_MAINTENANCE("UNDER_MAINTENANCE"),
  OUT_OF_SERVICE("OUT_OF_SERVICE");

  private final String code;

  State(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
