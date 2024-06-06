package com.rentalgames.api.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
      super(message);
    }
    
    public CustomerNotFoundException() {
      super("Customer not found");
    }
  }
