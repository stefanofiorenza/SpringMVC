package corso.spring.mvc.crm.services.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;




public abstract class Contact {

	protected Contact(String type){
		setType(ContactTypeEnum.fromText(type));
	}
	
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String telephone;
	
	@Getter
	private Set<Group> groups= new HashSet<Group>();
	
	@Getter
	@Setter
	private boolean active;

	@Getter
	@Setter
	private Customer customer;
	
	@Getter
	@Setter	
	private Date joinDate;
	
	@Getter
	@Setter
	private String pictureAsUrl;
	

	@Getter
	@Setter	
	private byte[] pictureAsBytes;
	
	
	@Getter
	@Setter
	private ContactTypeEnum type=ContactTypeEnum.USER;

	@Getter
	@Setter
	private String groupSelected;
	
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", telephone="
				+ telephone + ", groups=" + groups + ", customer=" + customer
				+ ", joinDate=" + joinDate + ", pictureAsUrl=" + pictureAsUrl
				+ ", pictureAsBytes=" + Arrays.toString(pictureAsBytes)
				+ ", type=" + type + "]";
	} //default value
	
	
	

}
