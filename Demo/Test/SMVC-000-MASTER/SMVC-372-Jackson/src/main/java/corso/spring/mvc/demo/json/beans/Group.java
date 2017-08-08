package corso.spring.mvc.demo.json.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

public class Group {

	@Getter
	@Setter
	@JsonView(JsonViews.EntityData.class)
	private Long id;
	
	@Getter
	@Setter
	@JsonView(JsonViews.EntityData.class)
	private String name;
	
	@Getter
	@JsonView(JsonViews.GroupDetails.class)
	private List<Contact> contacts= new ArrayList<Contact>();
	
	public Group(){}
	
	public Group(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
