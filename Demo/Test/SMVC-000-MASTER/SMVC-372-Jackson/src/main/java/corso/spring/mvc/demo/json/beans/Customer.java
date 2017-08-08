package corso.spring.mvc.demo.json.beans;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonView;

public class Customer {

	@JsonView(JsonViews.EntityData.class)
	@Getter
	@Setter
	private Long id;
	
	@JsonView(JsonViews.EntityData.class)
	@Getter
	@Setter
	private String name;
		
	@Getter	
	@JsonView(JsonViews.CustomerDetails.class)
	private Set<Contact> contacts= new HashSet<>();
			

	
	
}
