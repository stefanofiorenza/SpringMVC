package app.prometrics.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

public class ExamDto {

	@Getter
	@JsonView(DataViews.CommonView.class)
	private Long id;
	
	@Getter
	@JsonView(DataViews.CommonView.class)
	private String executionId;
	
	@Getter
	@Setter
	@JsonView(DataViews.CommonView.class)
	private String user;
	
	@Getter
	@JsonView(DataViews.CommonView.class)
	private List<QuestionDto> questions = new ArrayList<QuestionDto>();
	
	@Getter
	@JsonIgnore
	private Map<Long, Character> questionAnswered= new HashMap<Long, Character>();
	
	@Getter
	@JsonIgnore
	private List<Long> questionToDeliver = new ArrayList<Long>();
	
	public ExamDto(Long id){
		this.id=id;
		this.executionId=UUID.randomUUID().toString();
	}
}
