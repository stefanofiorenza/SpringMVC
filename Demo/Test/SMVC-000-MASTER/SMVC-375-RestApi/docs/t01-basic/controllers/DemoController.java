package corso.spring.mvc.demo.json.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.Group;
import corso.spring.mvc.demo.json.services.ContactService;
import corso.spring.mvc.demo.json.services.GroupService;
import static corso.spring.mvc.demo.json.config.Consts.DEFAULT_TIME_FORMAT;
import static corso.spring.mvc.demo.json.config.Consts.EMPTY_STRING;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private GroupService groupService;
	
	
	
	
	@RequestMapping(value = "/contacts/create",
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)	
	public Long createContact(@RequestBody Contact contact) {
		return contactService.saveContact(contact);
	}
	
	
	@RequestMapping(value = "/contacts/details/{cid}")
	public Contact getContactDetails(@PathVariable long cid) {
		return contactService.getContact(cid);
	}
	
	@RequestMapping(value = "/contacts/search")
	public List<Contact> getContactByFilters(
			@RequestParam(value="name", required = false,defaultValue =EMPTY_STRING)String name, 
			@RequestParam(value="telephone", required = false,defaultValue =EMPTY_STRING)String telephone, 
			@RequestParam(value="customerName", required = false,defaultValue =EMPTY_STRING)String customerName, 
			@RequestParam(value="contactType", required = false,defaultValue =EMPTY_STRING)String ctcType, 
			@RequestParam(value="fields", required = false,defaultValue =EMPTY_STRING)String fields, 
			@RequestParam("hiredOn") @DateTimeFormat(pattern = "dd-MM-yyyy") Date hiredOn){
			//@RequestParam(value="serializedDateFormat", required = false,defaultValue =DEFAULT_TIME_FORMAT) String dateFormat) {
		
		return contactService.contactsByFilters(name, hiredOn);
	}
	
	@RequestMapping(value = "/groups/search")
	public List<Group> searchGroups(@RequestParam("filterA")String filterA, @RequestParam("hiredOn")Date hiredOn) {
		return groupService.groupsByFilters(filterA, hiredOn);
	}
	
	@RequestMapping(value = "/groups/details/{gid}")
	public Group groupDetails(@PathVariable long gid) {
		return groupService.groupDetails(gid);
	}
	
}
