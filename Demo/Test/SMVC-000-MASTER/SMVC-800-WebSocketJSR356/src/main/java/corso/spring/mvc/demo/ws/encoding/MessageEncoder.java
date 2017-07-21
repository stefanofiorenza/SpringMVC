package corso.spring.mvc.demo.ws.encoding;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import corso.spring.mvc.demo.ws.beans.Message;

@Slf4j
public class MessageEncoder implements Encoder.Text<Message>{

		private static final ObjectMapper mapper = new ObjectMapper();
	
	 	@Override
	    public String encode(Message message) throws EncodeException {
	 		String messageAsJson=null;
	        try {
	        	messageAsJson= mapper.writeValueAsString(message);				
			} catch (JsonProcessingException e) {
				log.error(e.getMessage(),e);
			}
	        return messageAsJson;
	    }
	 
	    @Override
	    public void init(EndpointConfig endpointConfig) {
	    	log.info("Custom config logic for MessageEncoder");
	    }
	 
	    @Override
	    public void destroy() {
	    	log.info("Close resources MessageEncoder");
	    }
}
