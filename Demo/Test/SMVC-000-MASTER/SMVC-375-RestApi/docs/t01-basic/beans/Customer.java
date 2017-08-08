package corso.spring.mvc.demo.json.beans;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private Long id;
	private String name;
	private Set<Contact> contacts= new HashSet<>();
			
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Contact> getContacts() {
		return contacts;
	}
	
	
}
