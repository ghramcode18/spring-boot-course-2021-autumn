package org.closure.course.controller;

import org.closure.course.dto.Greeting;
import org.closure.course.dto.HelloMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


  @MessageMapping("/hello/{username}")
  @SendTo("/topic/greetings/{username}")
  public Greeting greeting(HelloMessage message, @DestinationVariable String username) throws Exception {
      System.out.println(username);
    Thread.sleep(1000); // simulated delay
    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
  }

}