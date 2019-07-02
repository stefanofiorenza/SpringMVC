package app.prometrics.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import app.prometrics.model.Answer;
import app.prometrics.model.Exam;
import app.prometrics.model.Question;

public class TestSerialToConsole {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File sorgente = new File ("res/test.quiz");
		FileInputStream fileIn = new FileInputStream (sorgente);
		ObjectInputStream obStreamIn = new ObjectInputStream(fileIn);

		Exam recuperato = (Exam) obStreamIn.readObject();
		stampaQuiz(recuperato);
	}


	public static void stampaQuiz(Exam quiz){

		for (Question domanda :quiz.getQuestions()){			
			System.out.println(domanda.getId()+") "+domanda.getContent());
			for(Answer risposta : domanda.getAnswers())
				System.out.println("	"+risposta.getIdentifier()+". "+risposta.getContent());
			System.out.println("");
		}
	}
}
