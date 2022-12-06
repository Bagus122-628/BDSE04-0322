package com.lithan.a5.exception;

public class StoreNotFoundException extends Exception {
  public StoreNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}