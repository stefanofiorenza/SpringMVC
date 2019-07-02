package app.prometrics.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.prometrics.beans.AnswerDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@Data
public class Question implements Serializable{

	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String content;
	
	@Getter
	private List<Answer> answers= new ArrayList<Answer>();
	
	@Getter
	@Setter
	private int rate;
	
	@Getter
	@Setter
	private String explaination;
	

}
