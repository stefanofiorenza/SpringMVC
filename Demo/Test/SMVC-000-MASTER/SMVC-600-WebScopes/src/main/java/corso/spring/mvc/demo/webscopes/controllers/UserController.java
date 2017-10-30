package corso.spring.mvc.demo.webscopes.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import corso.spring.mvc.demo.webscopes.beans.User;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

   /*
    * Get user from session attribute
    */
   @GetMapping("/info")
   public String userInfo(@SessionAttribute("user") User user) {

      log.info("Email: " + user.getEmail());
      log.info("First Name: " + user.getFname());

      return "user";
   }
}
