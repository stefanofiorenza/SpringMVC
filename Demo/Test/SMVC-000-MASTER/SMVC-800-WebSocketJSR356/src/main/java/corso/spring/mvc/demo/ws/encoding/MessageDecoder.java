package corso.spring.mvc.demo.ws.encoding;

import java.io.IOException;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.databind.ObjectMapper;

import corso.spring.mvc.demo.ws.beans.Message;

@Slf4j
public class MessageDecoder implements Decoder.Text<Message>{

	private static final ObjectMapper mapper = new ObjectMapper();
	
	@Override
    public boolean willDecode(String s) {
        return (s != null);
    }
 
    @Override
    public void init(EndpointConfig endpointConfig) {
    	log.info("Custom Config logic for MessageDecoder");
    }
 
    @Override
    public void destroy() {
    	log.info("Close resources MessageDecoder");
    }

	@Override
	public Message decode(String messageAsString) throws DecodeException {
		Message message=null;
		
		try {
			message= mapper.readValue(messageAsString, Message.class);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
		return message;
	}



}
