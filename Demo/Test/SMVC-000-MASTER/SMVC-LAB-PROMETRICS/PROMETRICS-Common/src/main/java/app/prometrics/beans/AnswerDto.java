package app.prometrics.beans;

import java.io.Serializable;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Data
public class AnswerDto implements Serializable{

	@JsonView(DataViews.CommonView.class)
	private char identifier;
	
	@JsonView(DataViews.CommonView.class)
	private String content;
	
	@JsonIgnore
	private boolean correct;	

	
	
	
}
