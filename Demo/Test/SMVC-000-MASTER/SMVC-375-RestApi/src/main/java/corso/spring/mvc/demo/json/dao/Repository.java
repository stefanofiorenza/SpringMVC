package corso.spring.mvc.demo.json.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.Group;

public interface Repository {

	 List<Contact> contactsByFilters(String name, Date addedOn);
	 
	 Contact contactDetail (Long contactId);
	 	 
	 List<Group> groupsByFilters(String name);
	 
	 Group groupDetails(Long contactId);

	List<Contact> contactsByFilters(String name, String telephone,
			String customerName, String ctcType, Date addedOn, Set<String> fields);
	 
}
