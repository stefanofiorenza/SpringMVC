package corso.spring.mvc.crm.services;

import java.util.List;

import corso.spring.mvc.crm.dao.filters.FilterContact;
import corso.spring.mvc.crm.services.beans.Contact;

public interface ContactService {

	Contact findById(long id);
	
	List<Contact> listContacts();
	
	List<Contact> findByFilters(FilterContact filter);
	
	Long delete(Contact toDelete);
	
	Long update(Contact updatedContact);
	
	Long save(Contact newContact);
}
