package corso.spring.mvc.demo.json.beans;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

//type is 1st because of @JsonTypeInfo inheritance constraints
@JsonPropertyOrder({"id","name","telephone","joinDate","type","pictureAsUrl","department","customer","groups"})
public class BusinessContact extends Contact{

	@Getter
	@Setter
	private String department;
	
	public BusinessContact(){
		super(ContactTypeEnum.BUSINESS.getText());
	}
}
