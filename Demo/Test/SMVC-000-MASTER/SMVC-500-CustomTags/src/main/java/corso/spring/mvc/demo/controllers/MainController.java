package corso.spring.mvc.demo.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
@Slf4j
public class MainController {
		
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {		
		return "menuView";
	}
	

	
}
