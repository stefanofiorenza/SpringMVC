package corso.spring.mvc.crm.services.beans;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonView;

public class Customer {


	@Getter
	@Setter
	private Long id;
	
	
	@Getter
	@Setter
	private String name;
		
	@Getter	
	private Set<Contact> contacts= new HashSet<>();
			

	
	
}
