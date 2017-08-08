package corso.spring.mvc.demo.json.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class TechnicalContact extends Contact{

	@Getter
	List<String> subjects = new ArrayList<String>();

	public TechnicalContact() {
		super(ContactTypeEnum.TECHNICAL.getText());	
	}
	
	
}
