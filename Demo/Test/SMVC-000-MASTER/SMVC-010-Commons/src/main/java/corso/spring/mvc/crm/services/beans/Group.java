package corso.spring.mvc.crm.services.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Group {

	@Getter
	@Setter	
	private Long id;
	
	@Getter
	@Setter	
	private String name;
	
	@Getter	
	private List<Contact> contacts= new ArrayList<Contact>();
	
	public Group(){}
	
	public Group(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
