package corso.spring.mvc.demo.rest.controllers.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.spring.mvc.crm.services.ContactService;
import corso.spring.mvc.crm.services.beans.Contact;

@RestController
@RequestMapping("contactsController")
public class ContactsController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping("load")
	public Contact findContact(){
		return contactService.findById(1L);
	}
}
