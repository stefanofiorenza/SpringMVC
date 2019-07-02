package app.prometrics.services.test;

import java.util.List;

import app.prometrics.beans.ExamMode;
import app.prometrics.beans.QuestionDto;
import app.prometrics.model.Question;
import app.prometrics.services.ExamService;
import app.prometrics.services.ExamServiceMockImpl;

public class ExamServiceTest {

	public static void main(String[] args) {
		ExamService examService = new ExamServiceMockImpl();		
		examService.createQuiz("someMockExamCode", "SomeMOckUSername", ExamMode.CERTIFICATION);
		
		List<QuestionDto> questions= examService.getQuestions("SomeMockExamExecutionId", 100);
		
		questions.forEach(q -> System.out.println(q));

	}

}
