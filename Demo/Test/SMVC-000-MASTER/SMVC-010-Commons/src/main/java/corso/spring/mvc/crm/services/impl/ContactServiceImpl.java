package corso.spring.mvc.crm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import corso.spring.mvc.crm.dao.ContactDao;
import corso.spring.mvc.crm.dao.filters.FilterContact;
import corso.spring.mvc.crm.services.ContactService;
import corso.spring.mvc.crm.services.beans.Contact;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDao;
	
	
	@Override
	public Contact findById(long id) {	
		return contactDao.findById(id);
	}

	@Override
	public List<Contact> listContacts() {
		return contactDao.listContacts();
	}

	@Override
	public List<Contact> findByFilters(FilterContact filter) {
		return contactDao.findByFilters(filter);
	}

	@Override
	public Long delete(Contact toDelete) {
		return contactDao.delete(toDelete);
	}

	@Override
	public Long update(Contact updatedContact) {
		return contactDao.update(updatedContact);
	}

	@Override
	public Long save(Contact newContact) {
		return contactDao.save(newContact);
	}

}
