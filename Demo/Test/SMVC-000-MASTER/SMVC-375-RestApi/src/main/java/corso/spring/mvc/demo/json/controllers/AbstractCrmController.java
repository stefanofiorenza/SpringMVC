package corso.spring.mvc.demo.json.controllers;

import static corso.spring.mvc.demo.json.config.Consts.EMPTY_STRING;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.Group;
import corso.spring.mvc.demo.json.services.ContactService;
import corso.spring.mvc.demo.json.services.GroupService;

@Slf4j
public abstract class AbstractCrmController {

	@Autowired
	@Getter
	private ContactService contactService;
	
	@Autowired
	@Getter
	private GroupService groupService;
	
		
	protected Long createContact(@RequestBody Contact contact) {
		return contactService.saveContact(contact);
	}
		
	
	protected Contact getContactDetails(@PathVariable long cid) {
		return contactService.getContact(cid);
	}
	
//	protected List<Contact> getContactByFilters(
//			String name, 
//			String telephone, 
//			String customerName, 
//			String ctcType, 			
//			 Date hiredOn){
//					
//		return contactService.contactsByFilters(name, telephone,customerName,ctcType,hiredOn);
//	}
	
	
	protected List<Group> searchGroups(String name) {
		return groupService.groupsByFilters(name);
	}
	
	protected Group groupDetails(long gid) {
		return groupService.groupDetails(gid);
	}


	public Group getContactGroupById(long gid) {
		return groupService.groupDetails(gid);
	}


	public Long deleteContact(long cid) {
		log.info("Deleted contact#{}",cid);
		return cid;
	}


	public Long updateContact(Contact contact) {
		log.info("Updated contact#{}",contact.getId());
		return contact.getId();
	}
}
