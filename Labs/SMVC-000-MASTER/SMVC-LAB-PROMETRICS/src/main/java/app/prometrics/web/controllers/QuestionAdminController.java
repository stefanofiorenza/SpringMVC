package app.prometrics.web.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.prometrics.beans.QuestionDto;
import app.prometrics.services.QuestionService;


@RestController
@RequestMapping(value = "/api/admin/questions")
@Slf4j
public class QuestionAdminController {

	
	@Autowired
	private QuestionService questionService;
	
	
	@PutMapping(value = "/",			 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)	
	public Long createQuestion(@RequestBody QuestionDto question) {
		return questionService.createQuestion(question);
	}
	
	
	@PostMapping(value = "/",			 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)	
	public Long updateQuestion(@RequestBody QuestionDto question) {
		return questionService.updateQuestion(question);
	}
	
	
	@DeleteMapping(value = "/{qid}",			 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public Long deleteQuestion(@PathVariable long qid) {
		return questionService.deleteQuestion(qid);
	}
}
