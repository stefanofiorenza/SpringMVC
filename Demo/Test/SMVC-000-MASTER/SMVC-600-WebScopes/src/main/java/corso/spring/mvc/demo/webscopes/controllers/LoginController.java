package corso.spring.mvc.demo.webscopes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import corso.spring.mvc.demo.webscopes.beans.User;

@Controller
@SessionAttributes("user")
public class LoginController {
   /*
    * Add user in model attribute
    */
   @ModelAttribute("user")
   public User setUpUserForm() {
      return new User();
   }

   @GetMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/dologin")
   public String doLogin(@ModelAttribute("user") User user, Model model) {

      // Implement your business logic
      if (user.getEmail().equals("stefano@email.com") && user.getPassword().equals("123")) {
         // Set user dummy data
         user.setFname("Stefano");
         user.setLname("Fiorenza");
         user.setAge(38);
      } else {
         model.addAttribute("message", "Login failed. Try again.");
         return "index";
      }
      return "success";
   }
}
