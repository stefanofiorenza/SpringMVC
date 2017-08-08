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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.Group;
import corso.spring.mvc.demo.json.beans.JsonViews;
import corso.spring.mvc.demo.json.services.ContactService;
import corso.spring.mvc.demo.json.services.GroupService;
import static corso.spring.mvc.demo.json.config.Consts.DEFAULT_TIME_FORMAT;
import static corso.spring.mvc.demo.json.config.Consts.EMPTY_STRING;

@RestController
@RequestMapping(value = "/demo/api/v1")
@Slf4j
//@CrossOrigin(origins="http://client.cors-api.appspot.com",methods={RequestMethod.POST,RequestMethod.GET},allowedHeaders="X-header1")
public class DemoControllerV1 extends AbstractCrmController{

		
	@RequestMapping(value = "/contacts/create",
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)	
	public Long createContact(@RequestBody Contact contact) {
		return super.createContact(contact);
	}
	
	
	@JsonView(JsonViews.ContactDetails.class)
	@RequestMapping(value = "/contacts/{cid}")
	public Contact getContactDetails(@PathVariable long cid) {
		return super.getContactDetails(cid);
	}
	
	@CrossOrigin(origins="http://client.cors-api.appspot.com",methods={RequestMethod.POST,RequestMethod.GET},allowedHeaders="X-header1")
	@JsonView(JsonViews.ContactDetails.class)
	@RequestMapping(value = "/contacts/search/")
	public List<Contact> getContactByFilters(
			@RequestParam(value="name", required = false,defaultValue =EMPTY_STRING)String name, 
			@RequestParam(value="telephone", required = false,defaultValue =EMPTY_STRING)String telephone, 
			@RequestParam(value="customerName", required = false,defaultValue =EMPTY_STRING)String customerName, 
			@RequestParam(value="contactType", required = false,defaultValue =EMPTY_STRING)String ctcType, 			
			@RequestParam(value="hiredOn", required = false,defaultValue =EMPTY_STRING) @DateTimeFormat(pattern = "dd-MM-yyyy") Date hiredOn){
			//@RequestParam(value="serializedDateFormat", required = false,defaultValue =DEFAULT_TIME_FORMAT) String dateFormat) {
		
		return getContactService().contactsByFilters(name, telephone,customerName,ctcType,hiredOn);
	}
	
	
	@JsonView(JsonViews.GroupDetails.class)
	@CrossOrigin(origins = "http://test.domain", maxAge = 3600)
	@RequestMapping(value = "/contacts/{cid}/groups/{gid}")
	public Group getContactGroupById(@PathVariable long cid,@PathVariable long gid) {
		return super.getContactGroupById(gid);
	}
	
	
	@JsonView(JsonViews.EntityData.class)
	@RequestMapping(value = "/groups/search/")
	public List<Group> searchGroups(@RequestParam("name")String name) {
		return super.searchGroups(name);
	}
	
	@JsonView(JsonViews.GroupDetails.class)
	@RequestMapping(value = "/groups/{gid}")
	public Group groupDetails(@PathVariable long gid) {
		return super.groupDetails(gid);
	}
	
}
