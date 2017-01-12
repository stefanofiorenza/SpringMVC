package corso.spring.mvc.demo.json.services;

import java.util.Date;
import java.util.List;

import corso.spring.mvc.demo.json.beans.Contact;

public interface ContactService {

	List<Contact> contactsByFilters(String name,Date addedOn);
	
	Contact getContact(Long id);
	
	
}
