package app.prometrics.test;

import java.io.File;
import java.io.IOException;

import app.prometrics.adapters.QuizIOAdapter;
import app.prometrics.model.Exam;
import app.prometrics.model.Question;

public class TestQuizIOAdapter {

	private static final String PATH_DOMANDE_FILE="res/DomandeQuiz.txt";
	private static final String PATH_FILE_QUIZ="res/test.quiz";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuizIOAdapter adapterIO = new QuizIOAdapter();
		try {
			adapterIO.readFile(new File(PATH_DOMANDE_FILE));
			Exam quiz=adapterIO.getQuiz();
			stampaDomande(quiz);
			
			adapterIO.serializeTxtFile(PATH_FILE_QUIZ);
			
			adapterIO.fromSerializeToTxt(PATH_FILE_QUIZ, "res/testFromSerialized.txt");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void stampaDomande(Exam quiz){
		
		for (Question domanda :quiz.getQuestions()){			
			System.out.println(domanda);
		}
	}

}
