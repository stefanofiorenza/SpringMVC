package corso.spring.mvc.crm.services.beans;

import lombok.Getter;
import lombok.Setter;

public class BusinessContact extends Contact{

	@Getter
	@Setter
	private String department;
	
	public BusinessContact(){
		super(ContactTypeEnum.BUSINESS.getText());
	}
}
