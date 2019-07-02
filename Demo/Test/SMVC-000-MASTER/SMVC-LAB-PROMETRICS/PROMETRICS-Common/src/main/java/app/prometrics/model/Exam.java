package app.prometrics.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class Exam {

	@Getter
	private Long id;
	
	@Getter
	private String uuid;
	
	@Getter
	@Setter
	private String user;
	
	@Getter
	@Setter
	private List<Question> questions = new ArrayList<Question>();
	
	public Exam(Long id){
		this.id=id;
		this.uuid=UUID.randomUUID().toString();
	}
}
