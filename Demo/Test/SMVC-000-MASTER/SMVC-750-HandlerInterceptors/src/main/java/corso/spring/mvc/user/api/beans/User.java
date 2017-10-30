package corso.spring.mvc.user.api.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class User {
	
	// form:hidden - hidden value
	private Integer id;

	// form:input - textbox
	private String name;

	// form:input - textbox
	private String email;

	// form:input - textarea
	private String address;

	// form:select - radio button
	private String gender;
	
	// form:input - password
	private String password;

	// form:input - password
	private String confirmPassword;

	// form:checkbox - single checkbox
	boolean newsletter;

	// form:checkboxes - multiple checkboxes
	private List<String> framework= new ArrayList<String>();



	// form:radiobuttons - radio button
	private Integer number;

	// form:select - form:option - dropdown - single select
	private String country;

	// form:select - multiple=true - dropdown - multiple select
	private List<String> skill= new ArrayList<String>();

	public boolean isNew() {
		return (this.id == null);
	}



}
