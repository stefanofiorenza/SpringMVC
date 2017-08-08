package corso.spring.mvc.demo.json.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import corso.spring.mvc.demo.json.beans.BusinessContact;
import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.Customer;
import corso.spring.mvc.demo.json.beans.Group;
import corso.spring.mvc.demo.json.beans.TechnicalContact;

public class ContactMocks {

	public static List<Group> createGroupList(String name) {
		List<Group> groups = new ArrayList<Group>();
		for (int i = 0; i < 15; i++) {
			groups.add(createMockGroup((long) i, name));
		}
		return groups;
	}

	public static Map<String,Contact> createContactMap() {
		
		Map<String,Contact> contactMap = new HashMap<String, Contact>();
		
		for (int i=0; i<15; i++){
			contactMap.put(i+"",createMockContact((long) i, "ContactMockName" + i));
		}
		
		return contactMap;
	}
	
	
	public static List<Contact> createContactList() {
		List<Contact> contacts = new ArrayList<Contact>();
		for (int i = 0; i < 15; i++) {
			contacts.add(createMockContact((long) i, "ContactMockName" + i));
		}

		return contacts;
	}

	public static Group createMockGroup(Long groupId) {
		return createMockGroup(groupId, "MockGroupName");

	}

	public static Group createMockGroup(Long groupId, String name) {
		Group group = new Group();
		group.setId(groupId);
		group.setName(name);
		group.getContacts().addAll(createContactList());
		return group;
	}

	public static Contact createMockContact(Long id, String name) {
		Contact contact = null;
		if (id % 2 == 0) {
			contact = new BusinessContact();
			((BusinessContact) contact).setDepartment("A Mock Department");
		} else {
			contact = new TechnicalContact();
			((TechnicalContact) contact).getSubjects().add("SA");
			((TechnicalContact) contact).getSubjects().add("DevOps");
			((TechnicalContact) contact).getSubjects().add(
					"ProductScriptsConfig");
		}

		contact.setId(id);
		contact.setName(name);
		contact.setTelephone("069843298332");
		contact.setCustomer(createMockCustomer(3L));
		contact.setJoinDate(new Date());
		// contact.setPictureAsBytes(pictureAsBytes);
		contact.setPictureAsUrl("/pics/Ivan.jpg");
		for (int i = 0; i < 10; i++) {
			contact.getGroups().add(new Group((long) i, "group" + i));
		}

		return contact;
	}

	public static Customer createMockCustomer(Long id) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName("MockCustomer");
		return customer;
	}

}
