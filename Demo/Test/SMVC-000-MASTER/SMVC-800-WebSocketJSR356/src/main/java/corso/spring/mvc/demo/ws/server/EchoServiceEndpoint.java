package corso.spring.mvc.demo.ws.server;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import lombok.extern.slf4j.Slf4j;
import corso.spring.mvc.demo.ws.beans.Message;
import corso.spring.mvc.demo.ws.encoding.MessageDecoder;
import corso.spring.mvc.demo.ws.encoding.MessageEncoder;


@ServerEndpoint(value = "/wsDemoServer", 
decoders = MessageDecoder.class, 
encoders = MessageEncoder.class)
@Slf4j
public class EchoServiceEndpoint {

		private static final MessageEncoder encoder = new MessageEncoder();
	
	 	@OnOpen
	    public void onOpen(Session session) throws IOException {
	 		log.info("Open a new Connection with sessionID:{} ",session.getId());
	    }
	 
	    @OnMessage
	    public void onMessage(Session session, Message message) throws IOException, EncodeException {	        
	    	log.info("Session: {}, Received message :{} ",session.getId(),message.toString());
	    	log.info("Session: {}, processed message.. ",session.getId());
	       	session.getBasicRemote().sendText(encoder.encode(message));
	       	log.info("Session: {}, Response for message Sent ",session.getId());
	    }
	 
	    @OnClose
	    public void onClose(Session session) throws IOException {
	    	log.info("Close Connection for session: "+session.getId());
	    }
	 
	    @OnError
	    public void onError(Session session, Throwable throwable) {
	    	log.info("Exception {} for session: {} ",throwable.getMessage(),session.getId());
	    }
	
}
