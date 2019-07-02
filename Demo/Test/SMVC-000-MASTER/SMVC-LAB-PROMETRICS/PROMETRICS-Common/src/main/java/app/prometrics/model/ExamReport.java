package app.prometrics.model;

import lombok.Data;

@Data
public class ExamReport {

	private int correctAnswers;
	private Long[] correctAnswersIds;
	private int wrongAnswers;
	private Long[] wrongAnswersIds;
	private boolean examPassed;
	private int examRate;
}
