package com.rentalgames.api.exceptions;

public class RentalNotFoundException extends RuntimeException {
    public RentalNotFoundException(String message) {
      super(message);
    }
    
    public RentalNotFoundException() {
      super("Rental not found");
    }
  }