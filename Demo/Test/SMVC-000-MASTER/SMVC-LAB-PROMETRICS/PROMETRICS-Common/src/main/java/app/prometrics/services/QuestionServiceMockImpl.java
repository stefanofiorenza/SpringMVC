package app.prometrics.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import app.prometrics.beans.QuestionDto;
import app.prometrics.exceptions.ServiceException;
import static app.prometrics.config.PrometricsConsts.MOCK_EXAM_FILE;

@Slf4j
@Service
public class QuestionServiceMockImpl implements QuestionService{

	
	private static List<QuestionDto> mockQuestions = new ArrayList<QuestionDto>();
	
	@Override
	public List<QuestionDto> searchQuestions(String examCode, String topic,
			int pageInit, int pageSize) {
		return loadMockQuestions ();
		
	}

	@Override
	public QuestionDto getQuestion(String qid) {	
		return loadMockQuestions().get(0);
	}

	@Override
	public List<QuestionDto> getQuestionsByFilters(String examCode,
			String qids, String topic, int dRate) {
		return loadMockQuestions ();
	}

	@Override
	public Long createQuestion(QuestionDto question) {
		return 1L;
	}

	@Override
	public Long updateQuestion(QuestionDto question) {
		return 1L;
	}

	@Override
	public Long deleteQuestion(long qid) {	
		return qid;
	}

	
	private List<QuestionDto> loadMockQuestions (){
		try {
			if(mockQuestions.isEmpty()){
				mockQuestions= ExamIOUtils.loadExam(MOCK_EXAM_FILE).getQuestions();
			}
			return mockQuestions;
		} catch (IOException e) {
			throw new ServiceException(e);
		}
	}
	
}
