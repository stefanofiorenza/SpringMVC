package app.prometrics.services;

import java.util.List;

import app.prometrics.beans.QuestionDto;

public interface QuestionService {

	List<QuestionDto> searchQuestions(String examCode, String topic, int pageInit,int pageSize);

	QuestionDto getQuestion(String qid);

	List<QuestionDto> getQuestionsByFilters(String examCode, String qids,String topic, int dRate);

	Long createQuestion(QuestionDto question);

	Long updateQuestion(QuestionDto question);

	Long deleteQuestion(long qid);
}
