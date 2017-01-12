package corso.spring.mvc.demo.json.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;


public class Contact {

	
	@JsonView(JsonViews.ContactData.class)
	private Long id;
	
	@JsonView(JsonViews.ContactData.class)
	private String name;
	
	@JsonView(JsonViews.ContactData.class)
	private String telephone;
	
	@JsonView(JsonViews.ContactDetails.class)
	private List<Group> groups= new ArrayList<Group>();

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Group> getGroups() {
		return groups;
	}
}
