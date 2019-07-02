package corso.spring.mvc.demo.webscopes.controllers;

import java.lang.reflect.Method;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import corso.spring.mvc.demo.webscopes.beans.User;

@Controller()
public class MainController {
  
   @ModelAttribute("userLogged")
   public User setUpUserForm() { //needed for login form
      return new User();
   }
	   
   @GetMapping("/")
   public String index() {
      return "login";
   }

}
