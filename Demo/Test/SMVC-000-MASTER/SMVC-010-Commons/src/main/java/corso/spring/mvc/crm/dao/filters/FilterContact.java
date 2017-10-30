package corso.spring.mvc.crm.dao.filters;

import java.util.Date;

import lombok.Data;

@Data
public class FilterContact {


	private String name;
	private String telephone;
	private String groupName;
	private String customerName;
	private Date joinDate;
	private String contactType;
	
}
