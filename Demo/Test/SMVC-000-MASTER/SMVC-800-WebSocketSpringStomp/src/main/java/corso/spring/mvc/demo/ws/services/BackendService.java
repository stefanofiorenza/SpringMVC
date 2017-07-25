package corso.spring.mvc.demo.ws.services;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Component;

import corso.spring.mvc.demo.ws.controllers.beans.MessageBean;

@Slf4j
@Component
public class BackendService {

	
	@Autowired
	private MessageSendingOperations<String> messagingTemplate; 
	
	
	 private static Thread rateThread ; //publishing thread
	
	 private static int counter=0;
	 
	 
	 public BackendService(){
		 startSendingMessagesThread();
	 }
	 
	 
	 private void startSendingMessagesThread(){
		 
		rateThread = new Thread() {
			public void run() {

				while (counter<10_000) {
					try {
						Thread.sleep(3000L);// send a new message every 3 second	
						sendMessageOnOutboundChannel();	
						counter++;
						
					} catch (InterruptedException e) {
						log.error(e.getMessage(),e);
						rateThread.interrupt();
					} 					
				}
				log.info("!!!!!!!!!!!!!!!!!!Sent last message");
			};
		};
		rateThread.start();
	}
	 
	 
	 private MessageBean createMockMessageBean(){
		 
		 MessageBean message = new MessageBean();
		 Date now = new Date();
		 int month=now.getMonth()+1;
		 String dateAsString = now.getDate()+"/"+ month+"/"+now.getYear()+" "+now.getMinutes()+":"+now.getSeconds();
		 message.setDate(dateAsString);
		 message.setFrom("Backend System");
		 message.setGroup("backend");
		 message.setMessage("new message "+counter);
		 return message;
	 }
	 
	 
	 private void sendMessageOnOutboundChannel(){
			messagingTemplate.convertAndSend("/broker/backend",createMockMessageBean());
			log.info("Sent message for counter: "+counter);
	 }
}
