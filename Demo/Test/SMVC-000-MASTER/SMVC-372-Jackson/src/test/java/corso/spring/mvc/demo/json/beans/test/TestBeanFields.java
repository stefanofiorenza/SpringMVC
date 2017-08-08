package corso.spring.mvc.demo.json.beans.test;


import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.junit.Ignore;
import org.junit.Test;
















import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import corso.spring.mvc.demo.json.beans.BusinessContact;
import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.ContactCustomFields;
import corso.spring.mvc.demo.json.mocks.ContactMocks;

//@Ignore
@Slf4j
public class TestBeanFields {

	private static final ObjectMapper OM=new ObjectMapper();
	
	//@Test
	public void test_SerDeserialization_Bean() throws IOException{
		
		//mock data
		Contact contact=ContactMocks.createMockContact(1L, "Stefano");	
		
		String result =OM.writeValueAsString(contact);		
		assertionsOnContactAsString(result);
				
		Contact deserializedContact=OM.readerFor(Contact.class).readValue(result);	
		assertionsOnContactAsString(deserializedContact.toString());
		
	}
	
		//@Test
		public void test_SerDeserialization_Maps() throws IOException{
			
			//mock data
			Map<String,Contact> contactMaps=ContactMocks.createContactMap();
			log.info("Original Map of Contacts");
			contactMaps.forEach((k,v)-> log.info(k+":"+v.toString()+","));
			
			String result =OM.writeValueAsString(contactMaps);		
			log.info(result);
			
			TypeReference<HashMap<String,Contact>> typeRefMapOfContacts 
			  = new TypeReference<HashMap<String,Contact>>() {};
			  
			Map<String,Contact> deserializedContactMaps=OM.readValue(result,typeRefMapOfContacts);	
			assertTrue(contactMaps.size()==deserializedContactMaps.size());
			
			log.info("Deserialized Map of Contacts");
			deserializedContactMaps.forEach((k,v)-> log.info(k+":"+v.toString()+","));
			
		}
	
	@Test
	public void test_SerDeserialization_Sets() throws IOException{
		
		Set<Contact> contactSet=new HashSet<Contact>(ContactMocks.createContactList());
		log.info("Original Set of Contacts");
		contactSet.forEach(c-> log.info(c.toString()+","));
		
		String result =OM.writeValueAsString(contactSet);		
		log.info(result);
		
		TypeReference<Set<Contact>> typeRefMapOfContacts 
		  = new TypeReference<Set<Contact>>() {};
		  
		  Set<Contact> deserializedContactSet=OM.readValue(result,typeRefMapOfContacts);	
		assertTrue(contactSet.size()==deserializedContactSet.size());
		
		log.info("Deserialized Set of Contacts");
		deserializedContactSet.forEach(c-> log.info(c.toString()+","));
		
	}
	
		
	
	
	//@Test
	public void test_jsonPropertiesOnBean() throws JsonProcessingException{
		
		Contact contact=ContactMocks.createMockContact(1L, "Stefano");
		String result =OM.writeValueAsString(contact);	
		log.info(result);
		assertTrue(result.contains("NOME"));
	}
	
	//@Test
	public void test_jsonPropertiesOrders() throws JsonProcessingException{
		Contact contact=ContactMocks.createMockContact(1L, "Stefano");
		String result =OM.writeValueAsString(contact);	
		log.info(result);
	}
	
	@Test
	public void test_jsonGetterAndSetter(){
		
	}
	
	
	//@Test
	public void test_jsonFormatDate() throws JsonProcessingException{
		//to test with annotations in Contact:
		//0) Default
		//1) @JsonFormat
		//2) @JsonSerialize 
		Contact contact=ContactMocks.createMockContact(1L, "Stefano");
		String result =OM.writeValueAsString(contact);	
		log.info(result);
	}
	
	
	
	
	private void assertionsOnContactAsString(String result){
		
		log.info(result);
		assertTrue(result.contains("name"));
		assertTrue(result.contains("telephone"));
		assertTrue(result.contains("groups"));
	}
}
