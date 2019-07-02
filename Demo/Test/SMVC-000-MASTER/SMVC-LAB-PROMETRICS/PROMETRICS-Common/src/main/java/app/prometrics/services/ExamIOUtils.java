package app.prometrics.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.prometrics.beans.AnswerDto;
import app.prometrics.beans.ExamDto;
import app.prometrics.beans.QuestionDto;
import app.prometrics.config.PrometricsConsts;

public class ExamIOUtils {

	private static long examCounter=0L;
	
	public static ExamDto loadExam(String fileName)throws IOException{
		FileReader fR = new FileReader(new File(fileName));		
		BufferedReader input= new BufferedReader(fR);
		String line = input.readLine();
		
		ExamDto newExam = new ExamDto(examCounter);
		List<QuestionDto> listQuestions = new ArrayList<QuestionDto>();
		
		while(!line.equals("FineFile")){
			line = input.readLine();
			
			QuestionDto question = new QuestionDto();
			question.setId(Long.valueOf(line.split(" ")[1]));
			
			line = input.readLine(); //Legge Testo:
			String questionContent = "";
			
			while(!line.equals("Risposte:")){
				line = input.readLine();
				if(!line.equals("Risposte:"))
					questionContent += line;
			}
			question.setContent(questionContent);
			
			List<AnswerDto> risposteDomandaTemp = new ArrayList<AnswerDto>();
			line = input.readLine();
			while(!line.startsWith("Answer:")){
				AnswerDto rispostaTemp = new AnswerDto();
				rispostaTemp.setContent(line.substring(3));
				rispostaTemp.setIdentifier(line.charAt(0));
				risposteDomandaTemp.add(rispostaTemp);
				line = input.readLine();
			}
			
			String answer = line.replace("Answer: ", "");
			
			for(AnswerDto t : risposteDomandaTemp)
				for(int i=0; i<answer.length(); i++){
					if(t.getIdentifier() == answer.charAt(i))
						t.setCorrect(true);
			}
			question.getAnswers().addAll(risposteDomandaTemp);
			newExam.getQuestions().add(question);
			newExam.getQuestionAnswered().put(question.getId(), PrometricsConsts.UNANSWERED);
			newExam.getQuestionToDeliver().add(question.getId());
			question.setExplaination("Some mock explaination");
			//listQuestions.add(question);
			//System.out.println(domandaTemp.toString());
			line = input.readLine();
		}
		newExam.getQuestions().addAll(listQuestions);
		
		return newExam;
		
	}
	
	
	
	/*
	public static ExamDto loadExam(String fileName)throws IOException{
		FileReader fR = new FileReader(new File(fileName));		
		BufferedReader input= new BufferedReader(fR);
		String line = input.readLine();
		
		examCounter++;
		
		ExamDto newExam = new ExamDto(examCounter);
		List<QuestionDto> listQuestions = new ArrayList<QuestionDto>();
		
		while(!line.equals("FineFile")){
			line = input.readLine();
			
			QuestionDto question = new QuestionDto();
			question.setId(Long.valueOf(line.split(" ")[1]));
			
			line = input.readLine(); //Legge Testo:
			String questionContent = "";
			
			while(!line.equals("Risposte:")){
				line = input.readLine();
				if(!line.equals("Risposte:"))
					questionContent += line;
			}
			question.setContent(questionContent);
			
			List<AnswerDto> risposteDomandaTemp = new ArrayList<AnswerDto>();
			line = input.readLine();
			while(!line.startsWith("Answer:")){
				AnswerDto rispostaTemp = new AnswerDto();
				rispostaTemp.setContent(line.substring(3));
				rispostaTemp.setIdentifier(line.charAt(0));
				risposteDomandaTemp.add(rispostaTemp);
				line = input.readLine();
			}
			
			String answer = line.replace("Answer: ", "");
			
			for(AnswerDto t : risposteDomandaTemp)
				for(int i=0; i<answer.length(); i++){
					if(t.getIdentifier() == answer.charAt(i))
						t.setCorrect(true);
			}
			question.getAnswers().addAll(risposteDomandaTemp);
			newExam.getQuestions().add(question);
			newExam.getQuestionAnswered().put(question.getId(), PrometricsConsts.UNANSWERED);
			newExam.getQuestionToDeliver().add(question.getId());
			question.setExplaination("Some mock explaination");
			//listQuestions.add(question);
			//System.out.println(domandaTemp.toString());
			line = input.readLine();
		}
		newExam.getQuestions().addAll(listQuestions);
		return newExam;
	}
	*/
}
