package xyz.cars.restapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import xyz.cars.restapi.models.MessageDto;

@Service
public class MessageSenderImpl implements MessageSender {
  private static final String HOOKS_URL = "https://hooks.slack.com/services/%s";

  @Override
  public void sendMessage(String userName, MessageDto message) throws JsonProcessingException {
    Map<String, String> myMap = new HashMap<String, String>();
    myMap.put(userName, "T04GLFELDK4/B04HA6R7UTS/hs1KnVvPAxgzDMAvr6Zr2Pw3");

    String userChannelId = myMap.get(userName);
    String userWebhookUrl = String.format(HOOKS_URL, userChannelId);
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    headers.setContentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    String messageJson = objectMapper.writeValueAsString(message);
    HttpEntity<String> entity = new HttpEntity<>(messageJson, headers);

    restTemplate.exchange(userWebhookUrl, HttpMethod.POST, entity, String.class);
  }

}
