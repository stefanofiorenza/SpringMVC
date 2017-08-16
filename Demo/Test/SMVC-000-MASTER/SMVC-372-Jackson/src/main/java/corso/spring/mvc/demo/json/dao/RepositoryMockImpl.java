package corso.spring.mvc.demo.json.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import corso.spring.mvc.demo.json.beans.BusinessContact;
import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.Customer;
import corso.spring.mvc.demo.json.beans.Group;
import corso.spring.mvc.demo.json.beans.TechnicalContact;


@Component
public class RepositoryMockImpl implements Repository{

	
	@Override
	public List<Contact> contactsByFilters(String name, Date addedOn) {
		return createContactList();
	}


	@Override
	public Contact contactDetail(Long contactId) {		
		return createMockContact(contactId,"ContactMockName"+contactId);
	}



	@Override
	public List<Group> groupsByFilters(String name) {		
		return createGroupList(name);
	}

	@Override
	public Group groupDetails(Long groupId) {		
		return createMockGroup(groupId);
	}
	
	
	@Override
	public List<Contact> contactsByFilters(String name, String telephone,
			String customerName, String ctcType, Date addedOn, Set<String> fields) {
		
		// query should fetch only requested columns and fill with null other fields
		List<Contact> contacts = createContactList();
		
		if(!fields.isEmpty()){
			for (Contact contact : contacts){
				if(!fields.contains("name")){
					contact.setName(null);
				}
				if(!fields.contains("telephone")){
					contact.setTelephone(null);
				}
				//...
			}			
		}
		
		return contacts;
	}
	
	
	

	private List<Group> createGroupList(String name) {
		List<Group> groups= new ArrayList<Group>();
		for (int i=0; i<15; i++){
			groups.add(createMockGroup((long)i, name));
		}
		return groups;
	}
	
	
	private List<Contact> createContactList() {
		List<Contact> contacts = new ArrayList<Contact>();
		for (int i=0; i<15; i++){
			contacts.add(createMockContact((long)i, "ContactMockName"+i));
		}
		
		return contacts;
	}
	
	
	private Group createMockGroup(Long groupId){
		return createMockGroup(groupId,"MockGroupName");
		
	}
	private Group createMockGroup(Long groupId, String name){
		Group group = new Group();
		group.setId(groupId);
		group.setName(name);
		group.getContacts().addAll(createContactList());
		return group;
	}
	
	private Contact createMockContact(Long id, String name){
			Contact contact =null;
			if(id%2==0){
				contact =new BusinessContact();
				((BusinessContact)contact).setDepartment("A Mock Department");
			}else{
				contact =new TechnicalContact();
				((TechnicalContact)contact).getSubjects().add("SA");
				((TechnicalContact)contact).getSubjects().add("DevOps");
				((TechnicalContact)contact).getSubjects().add("ProductScriptsConfig");
			}
			
			contact.setId(id);
			contact.setName(name);
			contact.setTelephone("069843298332");
			contact.setCustomer(createMockCustomer(3L));
			contact.setJoinDate(new Date());
			//contact.setPictureAsBytes(pictureAsBytes);
			contact.setPictureAsUrl("/pics/Ivan.jpg");
			for (int i=0; i<10; i++){
				contact.getGroups().add(new Group((long)i, "group"+i));
			}
			
			return contact;
		}
	
	private Customer createMockCustomer(Long id){
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName("MockCustomer");
		return customer;
	}






	
}
