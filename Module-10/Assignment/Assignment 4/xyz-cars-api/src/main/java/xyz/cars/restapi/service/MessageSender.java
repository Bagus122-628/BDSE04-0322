package xyz.cars.restapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import xyz.cars.restapi.models.MessageDto;

public interface MessageSender {

  public void sendMessage(String userName, MessageDto message) throws JsonProcessingException;
}
