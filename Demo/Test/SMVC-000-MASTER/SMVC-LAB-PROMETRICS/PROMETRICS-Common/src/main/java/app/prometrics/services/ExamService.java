package app.prometrics.services;

import java.util.List;
import java.util.Set;

import app.prometrics.beans.ExamDto;
import app.prometrics.beans.ExamMode;
import app.prometrics.beans.ExamReportDto;
import app.prometrics.beans.QuestionDto;

public interface ExamService {

	ExamDto createQuiz (String examCode, String username,ExamMode mode);
	
	ExamReportDto terminateExam(String examId);
	
	void confirmQuestion (String examExecutionId,Long questionId, char answerId);

	//List<QuestionDto> getQuestions(String examId, int pageInit,	int pageSize);

	List<QuestionDto> getQuestions(String examExecutionId, int noQuestions);


	
	
	
	
}
