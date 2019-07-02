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
import org.springframework.web.bind.support.SessionStatus;

import corso.spring.mvc.demo.webscopes.beans.User;

@Controller()
@RequestMapping("/auth")
@SessionAttributes("userLogged")
public class LoginController {

   @ModelAttribute("userLogged")
   public User setUpUserForm() {
      return new User();
   }
   
   @RequestMapping(value="/dologin", method = RequestMethod.POST)
   public String doLogin(@ModelAttribute("userLogged") User user, Model model) {

      // Implement your business logic
      if (user.getEmail().equals("stefano@email.com") && user.getPassword().equals("123")) {
         // Set user dummy data
         user.setFname("Stefano");
         user.setLname("Fiorenza");
         user.setAge(38);
      } else {
         model.addAttribute("message", "Login failed. Try again.");
         return "login";
      }
      return "main";
   }
   
 
}
