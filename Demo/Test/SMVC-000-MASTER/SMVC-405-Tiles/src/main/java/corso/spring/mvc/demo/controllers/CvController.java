package corso.spring.mvc.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users/cv")
public class CvController {

	
	
	@RequestMapping(value="/registrazione", method = RequestMethod.GET)
	public String prepareRegistration() {
		return "views/main/registrazione";
	}
	
	
}
