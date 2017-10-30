package corso.spring.mvc.demo.json.controllers.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.config.MySmvcInitializer;
import corso.spring.mvc.demo.json.controllers.DemoControllerV1;
import corso.spring.mvc.demo.json.mocks.ContactMocks;
import corso.spring.mvc.demo.json.services.ContactService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MySmvcInitializer.class})
public class DemoControllerV1Test {
	

	 private MockMvc mockMvc;

	 @Mock
	 private ContactService contactService;

	 @InjectMocks
	 private DemoControllerV1 controller;
	 	 
	 
	 @Before
	 public void setupTest() throws Exception {
		 MockitoAnnotations.initMocks(this);
	     mockMvc = MockMvcBuilders
	                .standaloneSetup(controller).build();
	        
		 Contact mockContact=ContactMocks.createMockContact(1L, "stefano");
		 Mockito.when(this.contactService.getContact(1L)).thenReturn(mockContact);
	 }
	 	 

	 @Test
	 public void testContactDetailsMethod() throws Exception {
		 
		
		    mockMvc.perform(get("/demo/api/v1/contacts/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.name", equalTo("stefano")));
		    
  		    verify(contactService, times(1)).getContact(1L);
	 
			 //for mav controllers:
			 //.andExpect(request().sessionAttribute("someKey", someMockObject))
			 //.andExpect(redirectedUrl("/index.htm"));
	 
	 }
}
