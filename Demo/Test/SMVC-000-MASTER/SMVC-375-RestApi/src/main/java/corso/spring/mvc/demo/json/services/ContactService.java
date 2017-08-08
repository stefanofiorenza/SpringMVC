package corso.spring.mvc.demo.json.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import corso.spring.mvc.demo.json.beans.Contact;

public interface ContactService {

	List<Contact> contactsByFilters(String name,String telephone, String customerName, String ctcType, Date addedOn);
	
	Contact getContact(Long id);
	
	Long saveContact(Contact contact);
		
	List<Contact> contactsByFilters(String name,String telephone, String customerName, String ctcType, Date addedOn, Set<String> fields);

	List<Map<String, Object>> contactsAsMapByFilters(String name,String telephone, String customerName, String ctcType,	Date hiredOn, String fields); 
}
