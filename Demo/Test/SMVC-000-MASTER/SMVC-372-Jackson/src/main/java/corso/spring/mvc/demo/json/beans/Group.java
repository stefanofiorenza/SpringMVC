package corso.spring.mvc.demo.json.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonView;

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
