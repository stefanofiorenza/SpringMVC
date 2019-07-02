package corso.spring.mvc.demo.json.beans.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import corso.spring.mvc.demo.json.beans.BusinessContact;
import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.ContactCustomFields;
import corso.spring.mvc.demo.json.mocks.ContactMocks;

@Slf4j
public class TestFilteredFields {

	
	private static final ObjectMapper OM=new ObjectMapper();
	
	
	//@Test
	public void testNullFieldNotIncluded() throws JsonProcessingException {
				
		//mock data
		List<Contact> contacts =ContactMocks.createContactList();
		contacts.forEach(c -> c.setTelephone(null));
		
		//serialization
		String result =OM.writeValueAsString(contacts);
				
		//assertions
		assertFieldsFiltered(result);
	}
	
	
	@Test
	public void testBeanWithFilters() throws JsonProcessingException{
				
		//mock data
		Contact contact=ContactMocks.createMockContact(1L, "Stefano");
		
		//filters added dynamically
		FilterProvider filterProvider = mapFieldsToSkipIntoFilters(new String[]{"customer","telephone","groups"});

		//writer e config di OM immutable!!! It needs to create a new one with filters.
		String result =OM.writer(filterProvider).writeValueAsString(contact);;
				
		//assertions
		assertFieldsFiltered(result);		
	}
	
	
	//@Test
	public void testAnyGetter() throws IOException{
		
		String contactCustomFieldsAsJson=""+
			"{\"name\":\"aName\","+
			"\"prop1\":\"aValue\","+
			"\"prop2\":34"+
			"}";
		
		
		ContactCustomFields contact=OM.
				configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).
				readerFor(ContactCustomFields.class).
				readValue(contactCustomFieldsAsJson);		
			
		assertionsOnAnyGetterAndSetter(contact.toString());
		
		
		String result = OM.writeValueAsString(contact);		
		assertionsOnAnyGetterAndSetter(result);
		
	}
	
	
	
	
	
	private void assertionsOnAnyGetterAndSetter(String result){
		
		log.info(result);
		assertTrue(result.contains("aName"));
		assertTrue(result.contains("aValue"));
		assertTrue(result.contains("34"));
	}
	

	private FilterProvider mapFieldsToSkipIntoFilters(String [] fieldNames){		
		return new SimpleFilterProvider().addFilter("FilterNameInBean",SimpleBeanPropertyFilter.serializeAllExcept(fieldNames));			
	}

	private void assertFieldsFiltered(String actualResult){	
		log.info("json Serialized: {} ",actualResult);
		assertTrue(actualResult.contains("name"));
		assertFalse(actualResult.contains("telephone"));		
	}
	
}
