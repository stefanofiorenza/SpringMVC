package corso.spring.mvc.demo.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import corso.spring.mvc.crm.dao.MockUtils;
import corso.spring.mvc.crm.services.ContactService;
import corso.spring.mvc.crm.services.beans.Contact;
import corso.spring.mvc.crm.services.beans.TechnicalContact;

@Controller
@RequestMapping("/contacts")
@Slf4j
public class ContactController {

	
	public static final String OUTPUT_PAGE_VIEW="pageContactView";
	public static final String OUTPUT_TABLE_VIEW="tabContactView";
	public static final String IO_FRM_VIEW="frmContactView";
	
	public static final String COMMAND_OBJ_NAME="cmdCommand";	
	public static final String CONTACTS_KEY="contactsFound";
	public static final String GROUPS_KEY="groups";	
	public static final String CUSTOMERS_KEY="customers";	
	
	@Autowired
	private ContactService contactService;

	@ModelAttribute(COMMAND_OBJ_NAME)
	public Contact createCommandBean(){
		Contact defaultContact = new TechnicalContact();	
		defaultContact.setName("Please insert Name..");
		defaultContact.setTelephone("Telephone number..");
		return defaultContact;
	}
	
	@RequestMapping(value = "/newContactPage", method = RequestMethod.GET)
	public String formContactView() {		
		return "frmContactView";
	}
	
	@ModelAttribute(GROUPS_KEY)
	public String[] groups(){		
		return MockUtils.groups;
	}
	
	@ModelAttribute(CUSTOMERS_KEY)
	public String[] customers(){		
		return MockUtils.customers;
	}

	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public ModelAndView findUser(@RequestParam("cid") long id) {
		ModelAndView mav = new ModelAndView(OUTPUT_PAGE_VIEW);	
		mav.addObject(COMMAND_OBJ_NAME,contactService.findById(id));
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute(COMMAND_OBJ_NAME) Contact contact) {
		log.info("Reveived contact: "+contact.toString());
		ModelAndView mav = new ModelAndView(IO_FRM_VIEW);	
		contactService.save(contact);
		mav.addObject(COMMAND_OBJ_NAME,contact);
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listUsers() {	
		ModelAndView mav = new ModelAndView(OUTPUT_TABLE_VIEW);	
		mav.addObject(CONTACTS_KEY,contactService.listContacts());
		return mav;
	}
}
