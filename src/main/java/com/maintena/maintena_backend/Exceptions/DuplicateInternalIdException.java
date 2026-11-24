package com.maintena.maintena_backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateInternalIdException extends RuntimeException {
  public DuplicateInternalIdException(String message) {
    super(message);
  }
}
