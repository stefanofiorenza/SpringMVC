package corso.spring.mvc.demo.webscopes.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import corso.spring.mvc.demo.webscopes.beans.User;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

   /*
    * Get user from session attribute
    */
   @RequestMapping(value="/info", method = RequestMethod.GET)
   public String userInfo(@SessionAttribute("userLogged") User user) {

      log.info("Email: " + user.getEmail());
      log.info("First Name: " + user.getFname());
      return "userDetails";
   }
   
   @GetMapping("/logout")
   public String removeUser(SessionStatus status) {
	   status.setComplete(); //remove object in session
	   return "logout";
   }
   
   @GetMapping("/main")
   public String backToMain() {
      return "main";
   }
}
