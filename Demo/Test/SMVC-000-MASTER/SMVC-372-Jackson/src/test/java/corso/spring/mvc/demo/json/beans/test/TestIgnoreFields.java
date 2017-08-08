package corso.spring.mvc.demo.json.beans.test;

import static org.junit.Assert.assertFalse;
import lombok.extern.slf4j.Slf4j;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.mocks.ContactMocks;

@Ignore
@Slf4j
public class TestIgnoreFields {

	private static final ObjectMapper OM=new ObjectMapper();
	
	@Test
	public void testIgnoreFields() throws JsonProcessingException{
		
		Contact contact=ContactMocks.createMockContact(1L, "Stefano");
		String result =OM.writeValueAsString(contact);	
		log.info(result);
		assertFalse(result.contains("telephone")); //@JsonIgnore on telephone
		assertFalse(result.contains("joinDate")); //@JsonIgnoreProperties contains joinDate
		
	}
}
