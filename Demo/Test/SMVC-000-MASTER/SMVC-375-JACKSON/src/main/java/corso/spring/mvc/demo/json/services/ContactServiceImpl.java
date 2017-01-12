package corso.spring.mvc.demo.json.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.Group;

public class ContactServiceImpl implements ContactService{

	@Override
	public List<Contact> contactsByFilters(String name, Date addedOn) {
		List<Contact> contacts = new ArrayList<Contact>();
		for (int i=0; i<15; i++){
			contacts.add(createMockContact((long)i, "ContactMockName"+i));
		}
		
		return contacts;
	}

	@Override
	public Contact getContact(Long id) {		
		return createMockContact(id,"mockName");
	}

	
	private Contact createMockContact(Long id, String name){
		
		Contact contact = new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setTelephone("069843298332");
		for (int i=0; i<10; i++){
			contact.getGroups().add(new Group((long)i, "group"+i));
		}
		
		return contact;
	}
	
}
