package app.prometrics.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Answer implements Serializable{

	private char identifier;
	private String content;
	private boolean correct;	

	
	
	
}
