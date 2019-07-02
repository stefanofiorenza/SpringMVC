package corso.spring.mvc.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {

	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String toIndex() {
		//return "views/main/index";
		return "views/auth/login";
		
	}
	
	

}