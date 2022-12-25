package xyz.cars.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import xyz.cars.restapi.models.MessageDto;
import xyz.cars.restapi.service.MessageSender;

@RestController
@RequestMapping("/api/messages")
public class WeebhookController {

  @Autowired
  private MessageSender messageSender;

  @PostMapping(path = "/{userName}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void sendMessage(@PathVariable("userName") String userName, @RequestBody MessageDto message)
      throws JsonProcessingException {

    messageSender.sendMessage(userName, message);
  }
}
