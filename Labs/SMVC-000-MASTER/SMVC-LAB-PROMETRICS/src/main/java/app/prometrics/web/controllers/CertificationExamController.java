package app.prometrics.web.controllers;

import java.util.List;
import java.util.Set;

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
import app.prometrics.beans.ExamDto;
import app.prometrics.beans.ExamMode;
import app.prometrics.beans.ExamReportDto;
import app.prometrics.beans.QuestionDto;
import app.prometrics.services.ExamService;


@RestController
@RequestMapping(value = "/api/exams/cert")
@Slf4j
public class CertificationExamController {

	
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value = "/start",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(DataViews.CommonView.class)
	public ExamDto startCertificationExam(
			@RequestParam(value="examCode", required = true)String examCode, 
			@RequestParam(value="userKey", required = true)String userKey,
			@RequestParam(value="pInit", required = false,defaultValue ="1")int pageInit, 
			@RequestParam(value="pSize", required = false,defaultValue ="10")int pageSize){		
		
		log.info("Check {} Authorization  ",userKey);
		return examService.createQuiz(examCode,userKey, ExamMode.CERTIFICATION);			
	}
	
	@RequestMapping(value = "/questions",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	@JsonView(DataViews.CommonView.class)
	public List<QuestionDto> getNextExamQuestionsCertificationExamMode(		 			
			@RequestParam(value="eeId", required = true)String examExecutionId, 			
			@RequestParam(value="pSize", required = false,defaultValue ="10")int noQuestions){			
		return examService.getQuestions(examExecutionId, noQuestions);
	}
	
	
	@RequestMapping(value = "/terminate",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(DataViews.CommonView.class)
	public ExamReportDto terminateExam(@RequestParam(value="eeId", required = true)String examExecutionId){
		return examService.terminateExam(examExecutionId);
	}
	
	
	@RequestMapping(value = "/confirmQuestion",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean confirmQuestion (@RequestParam(value="eeId", required = true)String examExecutionId,
									@RequestParam(value="qid", required = true)Long questionId,
									@RequestParam(value="aid", required = true)char answerId){
		examService.confirmQuestion(examExecutionId, questionId, answerId);
		return true;
	}
	
	
}
