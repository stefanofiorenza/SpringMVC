package app.prometrics.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import app.prometrics.beans.ExamDto;
import app.prometrics.beans.ExamMode;
import app.prometrics.beans.ExamReportDto;
import app.prometrics.beans.QuestionDto;
import static app.prometrics.config.PrometricsConsts.MOCK_EXAM_FILE;
import app.prometrics.exceptions.ServiceException;



@Slf4j
@Service
public class ExamServiceMockImpl implements ExamService{

	
	private Map<String, ExamDto> cacheExams = new HashMap<String, ExamDto>();
	
	@Override
	public ExamDto createQuiz(String examCode, String username, ExamMode mode) {
		try {
			
			ExamDto newExam=ExamIOUtils.loadExam(MOCK_EXAM_FILE);
			log.info("Choose random 100 questions from DB for exam with code: {} ",examCode);
			log.info("Create a Record in ExamExecution for user: {} and executionId : {} ",username,newExam.getExecutionId());
			
			log.info("Load Exam data in cache with executionId {} ",newExam.getExecutionId());			
			cacheExams.putIfAbsent(newExam.getExecutionId(), newExam);
			return newExam;
		} catch (IOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public ExamReportDto terminateExam(String examUuId) {
		ExamReportDto report = new ExamReportDto();
		report.setCorrectAnswers(5);
		report.setCorrectAnswersIds(new long[]{1,4,5,78,23});
		report.setExamPassed(false);
		report.setExamRate(40);
		report.setWrongAnswers(5);
		report.setWrongAnswersIds(new long[]{11,24,35,71,22});
		return report;
	}

	@Override
	public void confirmQuestion(String examUuId,Long questionId, char answerId) {
		log.info("Updated question: {} with choice {} ",questionId,answerId);		
	}




	@Override
	public List<QuestionDto> getQuestions(String examExecutionId,
			int noQuestions) {
		try {
			return ExamIOUtils.loadExam(MOCK_EXAM_FILE).getQuestions();
		} catch (IOException e) {
			throw new ServiceException(e);
		}
	}

}
