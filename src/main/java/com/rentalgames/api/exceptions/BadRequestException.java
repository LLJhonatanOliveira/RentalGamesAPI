package com.rentalgames.api.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
      super(message);
    }
  
    public BadRequestException() {
      super();
    }
  }
