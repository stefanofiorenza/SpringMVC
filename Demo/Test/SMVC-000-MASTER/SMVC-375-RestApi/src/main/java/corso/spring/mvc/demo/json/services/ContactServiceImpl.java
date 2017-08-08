package corso.spring.mvc.demo.json.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.dao.Repository;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService{

	
	@Autowired
	private Repository repository;
	
	@Override
	public List<Contact> contactsByFilters(String name,String telephone, String customerName, String ctcType, Date addedOn) {
		return repository.contactsByFilters(name, addedOn);		
	}

	@Override
	public Contact getContact(Long id) {		
		return repository.contactDetail(id);
	}

	@Override
	public Long saveContact(Contact contact) {
		log.info("Saved new Contact with data: \n {}",contact.toString());
		return contact.getId();
	}

	@Override
	public List<Map<String, Object>> contactsAsMapByFilters(String name, String telephone,String customerName, String ctcType, Date addedOn,String fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> contactsByFilters(String name, String telephone,String customerName, 
			String ctcType, Date addedOn, Set<String> fields) {
		return repository.contactsByFilters(name, telephone,customerName, ctcType, addedOn, fields);		
	}
	
	
}
