package corso.spring.mvc.user.api.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class User {
	
	private Integer id;
	private String name;
	private String email;
	private String address;
	private String gender;	
	private String password;
	private String confirmPassword;
	boolean newsletter;
	private List<String> framework= new ArrayList<String>();
	private Integer number;
	private String country;
	private List<String> skill= new ArrayList<String>();

	public boolean isNew() {
		return (this.id == null);
	}



}
