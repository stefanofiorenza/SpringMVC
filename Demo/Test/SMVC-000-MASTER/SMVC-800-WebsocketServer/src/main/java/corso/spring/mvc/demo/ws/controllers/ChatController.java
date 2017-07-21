package corso.spring.mvc.demo.ws.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;

import corso.spring.mvc.demo.ws.controllers.beans.Message;
import corso.spring.mvc.demo.ws.controllers.beans.OutputMessage;


@Controller
@Slf4j
public class ChatController 
{
    @MessageMapping("/chat/{topic}") //receive from /app/chat/{topic}
    @SendTo("/topic/messages") //forward to Destination /topic/messages
    public OutputMessage processMessage(@DestinationVariable("topic") String topic,
			      Message message) throws Exception
    {
    	log.info("Received: {}",message.toString());
    	return new OutputMessage(message.getFrom(), message.getText(), topic);
    }
}
