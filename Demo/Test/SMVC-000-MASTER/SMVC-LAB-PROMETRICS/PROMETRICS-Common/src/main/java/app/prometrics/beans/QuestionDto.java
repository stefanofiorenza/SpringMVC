package app.prometrics.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
public class QuestionDto implements Serializable{

	@Getter
	@Setter
	@JsonView(DataViews.CommonView.class)
	private Long id;
	
	@Getter
	@Setter
	@JsonView(DataViews.CommonView.class)
	private String content;
	
	@Getter
	@JsonView(DataViews.CommonView.class)
	private List<AnswerDto> answers= new ArrayList<AnswerDto>();
	
	@Getter
	@Setter
	private int rate;
	
	@Getter
	@Setter
	private String explaination;
	

}
