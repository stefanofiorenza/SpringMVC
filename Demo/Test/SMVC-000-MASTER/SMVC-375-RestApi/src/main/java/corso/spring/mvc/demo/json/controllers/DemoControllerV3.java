package corso.spring.mvc.demo.json.controllers;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.Group;
import corso.spring.mvc.demo.json.services.ContactService;
import corso.spring.mvc.demo.json.services.GroupService;
import static corso.spring.mvc.demo.json.config.Consts.DEFAULT_TIME_FORMAT;
import static corso.spring.mvc.demo.json.config.Consts.EMPTY_STRING;

@RestController
@RequestMapping(value = "/demo/api/v3")
@Slf4j
public class DemoControllerV3 extends AbstractCrmController{

		
	
	@GetMapping(value = "/contacts/search/",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
	public List<Contact> getContactByFilters(
			@RequestParam(value="name", required = false,defaultValue =EMPTY_STRING)String name, 
			@RequestParam(value="telephone", required = false,defaultValue =EMPTY_STRING)String telephone, 
			@RequestParam(value="customerName", required = false,defaultValue =EMPTY_STRING)String customerName, 
			@RequestParam(value="contactType", required = false,defaultValue =EMPTY_STRING)String ctcType, 	
			@RequestParam(value="fields", required = false,defaultValue =EMPTY_STRING)String fields, 		
			@RequestParam("hiredOn") @DateTimeFormat(pattern = "dd-MM-yyyy") Date hiredOn){

		Set<String> filterProperties =ControllerUtils.tokenizeParam(fields);
		return getContactService().contactsByFilters(name, telephone,customerName,ctcType,hiredOn,filterProperties);	
	}
		
	
	@PutMapping(value = "/contacts",			 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)	
	public Long createContact(@RequestBody Contact contact) {
		return super.createContact(contact);
	}
	
	
	@PostMapping(value = "/contacts",			 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)	
	public Long updateContact(@RequestBody Contact contact) {
		return super.updateContact(contact);
	}
	
	
	@DeleteMapping(value = "/contacts/{cid}",			 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)	
	public Long deleteContact(@PathVariable long cid) {
		return super.deleteContact(cid);
	}
	
	
	
	@GetMapping(value = "/contacts/{cid}")
	public Contact getContactDetails(@PathVariable long cid) {
		return super.getContactDetails(cid);
	}
	
	@GetMapping(value = "/groups/search")
	public List<Group> searchGroups(@RequestParam("name")String name) {
		return super.searchGroups(name);
	}
	
	@GetMapping(value = "/groups/{gid}")
	public Group groupDetails(@PathVariable long gid) {
		return super.groupDetails(gid);
	}
	
	
	
	
}
