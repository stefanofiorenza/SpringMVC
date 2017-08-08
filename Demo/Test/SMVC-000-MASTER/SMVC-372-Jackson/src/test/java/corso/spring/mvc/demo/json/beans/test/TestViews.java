package corso.spring.mvc.demo.json.beans.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import lombok.extern.slf4j.Slf4j;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.JsonViews;
import corso.spring.mvc.demo.json.mocks.ContactMocks;


//@Ignore
@Slf4j
public class TestViews {

	private static final ObjectMapper OM=new ObjectMapper();
	
	@Test
	public void test_views() throws JsonProcessingException{
		
		//mock data
		Contact contact=ContactMocks.createMockContact(1L, "Stefano");
	
		testTemplate(JsonViews.EntityData.class, contact, true, false,false);						
		testTemplate(JsonViews.ContactDetails.class, contact, true, true,false);		
		testTemplate(JsonViews.CustomerDetails.class, contact, true, false,true);
	}
	
	
	private void testTemplate(Class viewClass,Contact contact, boolean customerSerialized, boolean groupsSerialized, boolean nestedCtcSerialized) throws JsonProcessingException{
		
		String result = OM.writerWithView(viewClass).writeValueAsString(contact);
		log.info(result);
		assertEquals(customerSerialized,result.contains("customer"));
		assertEquals(groupsSerialized,result.contains("groups"));
		assertEquals(nestedCtcSerialized,result.contains("contacts"));
		
	}
	
	
}
