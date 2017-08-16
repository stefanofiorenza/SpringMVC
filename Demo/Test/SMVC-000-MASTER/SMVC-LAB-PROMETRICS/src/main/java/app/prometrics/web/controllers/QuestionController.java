package app.prometrics.web.controllers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import app.prometrics.beans.DataViews;
import app.prometrics.beans.QuestionDto;
import app.prometrics.services.QuestionService;

@RestController
@RequestMapping(value = "/api/exams/questions")
@Slf4j
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	
	@RequestMapping(value = "/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	@JsonView(DataViews.LearningView.class)
	public List<QuestionDto> searchQuestionsByIds(			
			@RequestParam(value="examCode", required = false,defaultValue ="ALL")String examCode,	
			@RequestParam(value="qids", required = false,defaultValue ="1")String qids,			
			@RequestParam(value="topic", required = false,defaultValue ="1")String topic,
			@RequestParam(value="dRate", required = false,defaultValue ="1")int dRate,
			@RequestParam(value="pInit", required = false,defaultValue ="1")int pageInit, 
			@RequestParam(value="pSize", required = false,defaultValue ="10")int pageSize){	
		
		return questionService.getQuestionsByFilters(examCode,qids,topic,dRate);	
	}
	
	@RequestMapping(value = "/{qid}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	@JsonView(DataViews.LearningView.class)
	public QuestionDto searchQuestionById(@PathVariable String qid){			
		return questionService.getQuestion(qid);	
	}
	
	
	@RequestMapping(value = "/exam/{examCode}/topic/{topic}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(DataViews.LearningView.class)
	public List<QuestionDto> searchQuestionsByTopic(			
			@RequestParam(value="pInit", required = false,defaultValue ="1")int pageInit, 
			@RequestParam(value="pSize", required = false,defaultValue ="10")int pageSize,	
			@PathVariable String examCode, @PathVariable String topic){
		
//		log.info("Parameters Received: ExamId :{}, username: {}, pageInit: {}, pageSize: {}, examCode: {}, topic: {}, qid: {}",
//				examId, username, pageInit,  pageSize, examCode,  topic,qid	);
		return questionService.searchQuestions(examCode,topic,pageInit,pageSize);	
	}
			
	
}
