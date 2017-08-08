package corso.spring.mvc.demo.ws.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import corso.spring.mvc.demo.ws.controllers.beans.MessageBean;
import corso.spring.mvc.demo.ws.controllers.beans.OutputMessageBean;


@Controller("/messages")
@Slf4j
public class MessageController 
{
	
	@Autowired
	private MessageSendingOperations<String> messagingTemplate; 
	
	private MultiValueMap<String,MessageBean> messagesReceived = 	
			CollectionUtils.unmodifiableMultiValueMap(new LinkedMultiValueMap<String, MessageBean>(1000)); 
			
	
    @MessageMapping("/incoming") //receive from /service/messages/{destination}  
    public void receiveMessage(Message<MessageBean> message) throws Exception   {
    	
    	String sessionId = SimpMessageHeaderAccessor.getSessionId(message.getHeaders());	
    	logMessageDetails(message);    	
    	updateMessage(message.getPayload(),"Incoming");
    	List<MessageBean> messagesPerThisSession=messagesReceived.getOrDefault(sessionId, new ArrayList<MessageBean>());
    	messagesPerThisSession.add(message.getPayload());
    	
    }
    
    @MessageMapping("/routing")
    public void routeMessage(Message<MessageBean> message) throws Exception   {  
    	logMessageDetails(message);    	
    	updateMessage(message.getPayload(),"Routing");
    	messagingTemplate.convertAndSend("/broker/"+message.getPayload().getGroup(), message.getPayload());
    }

    
    @MessageMapping("/process")
    @SendTo("/broker/messages")
    public OutputMessageBean processMessage(Message<MessageBean> message) throws Exception   {
    	logMessageDetails(message);
    	updateMessage(message.getPayload(),"Process");
    	String destination = SimpMessageHeaderAccessor.getDestination(message.getHeaders());
    	return new OutputMessageBean(message.getPayload().getFrom(), message.getPayload().getMessage(), destination);
    }
    
    
    @MessageMapping("/forward")
    @SendTo("/broker/messages")
    public MessageBean forwardMessage(Message<MessageBean> message) throws Exception   {
    	logMessageDetails(message);
    	updateMessage(message.getPayload(),"Forward");
    	return message.getPayload();
    }
    
    @MessageMapping("/forward")
    @SendToUser("registeredUser")
    public MessageBean forwardMessageToUser(Message<MessageBean> message) throws Exception   {
    	logMessageDetails(message);
    	updateMessage(message.getPayload(),"forwardMessageToUser");
    	return message.getPayload();
    }
    
    private void updateMessage(MessageBean originalMsg, String handlerName){
    	String newMessage=originalMsg.getMessage()+" ["+handlerName+"]";
    	originalMsg.setMessage(newMessage);
    }
    
    private void logMessageDetails(Message<MessageBean> message){
    	
    	MessageHeaders headers = message.getHeaders();
		SimpMessageType messageType = SimpMessageHeaderAccessor.getMessageType(headers);
		String destination = SimpMessageHeaderAccessor.getDestination(headers);
		String sessionId = SimpMessageHeaderAccessor.getSessionId(headers);	
		
		String userName="Anonymous";
		Principal user = SimpMessageHeaderAccessor.getUser(headers);
		if(user!=null){
			userName=user.getName();
		}
		log.info("Received Message with:  \n SessionID: {}\n Destination: {} \n Type: {} \n From User: {}",sessionId,
				destination,messageType.toString(),userName);
    	
    	
    }
    
	
}
