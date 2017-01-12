package corso.spring.mvc.demo.json.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.Group;
import corso.spring.mvc.demo.json.services.ContactService;
import corso.spring.mvc.demo.json.services.GroupService;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private GroupService groupService;
	
	
	@RequestMapping(value = "/contacts/details")
	public Contact getContactDetails() {
		return contactService.getContact(1l);
	}
	
	@RequestMapping(value = "/contacts/search")
	public List<Contact> getContactByFilters(String filterA, Date dateB) {
		return contactService.contactsByFilters(filterA, dateB);
	}
	
	@RequestMapping(value = "/groups/all")
	public List<Group> getGroups() {
		return groupService.listGroups();
	}
	
}
