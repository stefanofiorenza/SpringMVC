package app.prometrics.adapters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import app.prometrics.model.Answer;
import app.prometrics.model.Exam;
import app.prometrics.model.Question;

public class QuizIOAdapter {

	Exam quiz;
	
	public Exam getQuiz() {
		return quiz;
	}

	public QuizIOAdapter(){
		this.quiz= new Exam(1L);
	}
	
	public void readFile(File file)throws IOException{
		FileReader fR = new FileReader(file);
		
		BufferedReader input= new BufferedReader(fR);

		String line = input.readLine();
		
		List<Question> listQuestions = new ArrayList<Question>();
		
		while(!line.equals("FineFile")){
			line = input.readLine();
			
			Question domandaTemp = new Question();
			domandaTemp.setId(Long.valueOf(line.split(" ")[1]));
			
			line = input.readLine(); //Legge Testo:
			String testoDomandaTemp = "";
			
			while(!line.equals("Risposte:")){
				line = input.readLine();
				if(!line.equals("Risposte:"))
					testoDomandaTemp += line;
			}
			domandaTemp.setContent(testoDomandaTemp);
			
			List<Answer> risposteDomandaTemp = new ArrayList<Answer>();
			line = input.readLine();
			while(!line.startsWith("Answer:")){
				Answer rispostaTemp = new Answer();
				rispostaTemp.setContent(line.substring(3));
				rispostaTemp.setIdentifier(line.charAt(0));
				risposteDomandaTemp.add(rispostaTemp);
				line = input.readLine();
			}
			
			String answer = line.replace("Answer: ", "");
			
			for(Answer t : risposteDomandaTemp)
				for(int i=0; i<answer.length(); i++){
					if(t.getIdentifier() == answer.charAt(i))
						t.setCorrect(true);
			}
			
			
			domandaTemp.getAnswers().addAll(risposteDomandaTemp);
			listQuestions.add(domandaTemp);
			//System.out.println(domandaTemp.toString());
			line = input.readLine();
		}
		//this.quiz.getQuestions().addAll(listQuestions);
	}
	
	public void serializeTxtFile(String file){
		File destinazione = new File (file);
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream (destinazione);
			ObjectOutputStream obStream = new ObjectOutputStream(fileOut);
			obStream.writeObject(this.quiz);
			
			obStream.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void fromSerializeToTxt(String fileSorgente, String fileDestinazione){
		File sorgente = new File (fileSorgente);
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream (sorgente);
			ObjectInputStream obStreamIn = new ObjectInputStream(fileIn);
			Exam recuperato = (Exam) obStreamIn.readObject();
			
			File destinazione =  new File(fileDestinazione);
			FileOutputStream out = new FileOutputStream (destinazione);
			
			String temp = "";
			String risposte= "";
			
			for(Question d : recuperato.getQuestions()){
				temp += "QUESTION "+d.getId()+"\n";
				temp += "Testo:\n "+d.getContent()+"\n";
				risposte= "";
				for(Answer r : d.getAnswers()){
					temp += r.getIdentifier()+". "+r.getContent()+"\n";
					if(r.isCorrect())
						risposte += r.getIdentifier();
				}
				temp += "Answer: "+risposte+"\n\n";
			}
			System.out.println(temp);
			BufferedWriter b = new BufferedWriter(new FileWriter(fileDestinazione));
			b.write(temp);
			
			b.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
}
