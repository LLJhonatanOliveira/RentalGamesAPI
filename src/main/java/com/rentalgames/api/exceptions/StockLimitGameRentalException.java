package com.rentalgames.api.exceptions;

public class StockLimitGameRentalException extends RuntimeException {
    public StockLimitGameRentalException() {
      super("Stock limit for renting this game");
    }
  }
