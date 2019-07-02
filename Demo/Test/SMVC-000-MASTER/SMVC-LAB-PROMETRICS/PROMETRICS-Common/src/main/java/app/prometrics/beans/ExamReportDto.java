package app.prometrics.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class ExamReportDto implements Serializable{

	private int correctAnswers;
	
	private long[] correctAnswersIds;
	
	private int wrongAnswers;
	
	private long[] wrongAnswersIds;
	
	@JsonView(DataViews.CommonView.class)
	private boolean examPassed;
	
	@JsonView(DataViews.CommonView.class)
	private int examRate;
}
