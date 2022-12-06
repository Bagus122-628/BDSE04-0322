package com.lithan.a5.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lithan.a5.exception.StoreNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(StoreNotFoundException.class)
  public String handleNoStoreException(StoreNotFoundException e, Model model) {
    model.addAttribute("message", e.getMessage());

    return "search";
  }

  @ExceptionHandler(Exception.class)
  public String handleGeneralException(Exception e, Model model) {
    model.addAttribute("message", e.getMessage());

    return "global-error";
  }
}