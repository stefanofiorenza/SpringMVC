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
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/demo/api/v2")
@Slf4j
public class DemoControllerV2 extends AbstractCrmController{

	
	
	
	
	@RequestMapping(value = "/contacts/search/map/")
	public List<Map<String, Object>> getContactByFiltersAsMap(
			@RequestParam(value="name", required = false,defaultValue =EMPTY_STRING)String name, 
			@RequestParam(value="telephone", required = false,defaultValue =EMPTY_STRING)String telephone, 
			@RequestParam(value="customerName", required = false,defaultValue =EMPTY_STRING)String customerName, 
			@RequestParam(value="contactType", required = false,defaultValue =EMPTY_STRING)String ctcType, 	
			@RequestParam(value="fields", required = false,defaultValue =EMPTY_STRING)String fields, 		
			@RequestParam("hiredOn") @DateTimeFormat(pattern = "dd-MM-yyyy") Date hiredOn){		
		
		return getContactService().contactsAsMapByFilters(name, telephone,customerName,ctcType,hiredOn,fields);
	}
	
	
	@RequestMapping(value = "/contacts/search/jsonFilters/")
	public String getContactByFiltersObjectMapperAndFilters(
			@RequestParam(value="name", required = false,defaultValue =EMPTY_STRING)String name, 
			@RequestParam(value="telephone", required = false,defaultValue =EMPTY_STRING)String telephone, 
			@RequestParam(value="customerName", required = false,defaultValue =EMPTY_STRING)String customerName, 
			@RequestParam(value="contactType", required = false,defaultValue =EMPTY_STRING)String ctcType, 	
			@RequestParam(value="fields", required = false,defaultValue =EMPTY_STRING)String fields, 		
			@RequestParam("hiredOn") @DateTimeFormat(pattern = "dd-MM-yyyy") Date hiredOn){
			//@RequestParam(value="serializedDateFormat", required = false,defaultValue =DEFAULT_TIME_FORMAT) String dateFormat) {
		
		List<Contact> contacts= getContactService().contactsByFilters(name, telephone,customerName,ctcType,hiredOn);
		
		Set<String> filterProperties =ControllerUtils.tokenizeParam(fields);
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("filteredResponse",
                SimpleBeanPropertyFilter.filterOutAllExcept(filterProperties));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setFilterProvider(filters);
		String responseAsJson="";
		
		try {
			responseAsJson=mapper.writeValueAsString(contacts); 
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(),e);
		}

		return responseAsJson;
	}
	
	
	@RequestMapping(value = "/contacts/search/query/")
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
		
	
	@RequestMapping(value = "/contacts/create",
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes= MediaType.APPLICATION_JSON_VALUE)	
	public Long createContact(@RequestBody Contact contact) {
		return super.createContact(contact);
	}
	
	
	@RequestMapping(value = "/contacts/{cid}")
	public Contact getContactDetails(@PathVariable long cid) {
		return super.getContactDetails(cid);
	}
	
	@RequestMapping(value = "/groups/search")
	public List<Group> searchGroups(@RequestParam("name")String name) {
		return super.searchGroups(name);
	}
	
	@RequestMapping(value = "/groups/{gid}")
	public Group groupDetails(@PathVariable long gid) {
		return super.groupDetails(gid);
	}
	
	
	
	
}
