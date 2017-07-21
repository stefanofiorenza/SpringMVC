package corso.spring.mvc.demo.ws.controllers.beans;

import java.util.Date;

import lombok.Data;

@Data
public class OutputMessage
{
    private String from;
    private String message;
    private String topic;
    private Date time = new Date();


    public OutputMessage(String from,String message,String topic)    {
		this.from = from;
		this.message = message;
		this.topic = topic;
    }


}
