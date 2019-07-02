package corso.spring.mvc.crm.services.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;

//type is 1st because of @JsonTypeInfo inheritance constraints
@JsonPropertyOrder({"id","name","telephone","joinDate","type","pictureAsUrl","subjects","customer","groups"}) 
public class TechnicalContact extends Contact{

	@Getter
	List<String> subjects = new ArrayList<String>();

	public TechnicalContact() {
		super(ContactTypeEnum.TECHNICAL.getText());	
	}
	
	
}
