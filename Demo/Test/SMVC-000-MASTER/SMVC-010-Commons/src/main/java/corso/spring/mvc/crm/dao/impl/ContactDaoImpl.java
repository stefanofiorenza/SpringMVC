package corso.spring.mvc.crm.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import corso.spring.mvc.crm.dao.ContactDao;
import corso.spring.mvc.crm.dao.MockUtils;
import corso.spring.mvc.crm.dao.filters.FilterContact;
import corso.spring.mvc.crm.services.beans.BusinessContact;
import corso.spring.mvc.crm.services.beans.Contact;
import corso.spring.mvc.crm.services.beans.ContactTypeEnum;
import corso.spring.mvc.crm.services.beans.TechnicalContact;

@Slf4j
@Repository
public class ContactDaoImpl implements ContactDao{

	private static final int HOW_MANY_CONTACS=1000;
	
	@Override
	public Contact findById(long id) {
		return MockUtils.createMockContact((int)id);
	}

	@Override
	public List<Contact> listContacts() {
		List<Contact> contacts = new ArrayList<Contact>();		
		for (int i=0; i<HOW_MANY_CONTACS; i++){
			contacts.add( MockUtils.createMockContact(i));
		}
		return contacts;
	}

	@Override
	public List<Contact> findByFilters(FilterContact filter) {
		List<Contact> contacts = new ArrayList<Contact>();		
		for (int i=0; i<HOW_MANY_CONTACS; i++){
			contacts.add( MockUtils.createMockContact(i));
		}
		return contacts;
	}

	@Override
	public Long delete(Contact toDelete) {
		log.info("Deleted Contact: {} With ID:{}", toDelete.toString(),toDelete.getId());
		return toDelete.getId();
	}

	@Override
	public Long update(Contact updatedContact) {
		log.info("Updated Contact: {} With ID:{}", updatedContact.toString(),updatedContact.getId());
		return updatedContact.getId();
	}

	@Override
	public Long save(Contact newContact) {
		log.info("Saved Contact: {} With ID:{}", newContact.toString(),newContact.getId());
		return newContact.getId();
	}
	
	

}
