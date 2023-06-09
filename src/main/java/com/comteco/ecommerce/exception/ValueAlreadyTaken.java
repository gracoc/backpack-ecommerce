package com.comteco.ecommerce.exception;

public class ValueAlreadyTaken extends RuntimeException{

  private static final String ERROR_MESSAGE = "%s %s already exists";

  public ValueAlreadyTaken(String field,String value){
    super(String.format(ERROR_MESSAGE, field, value));
  }
}
