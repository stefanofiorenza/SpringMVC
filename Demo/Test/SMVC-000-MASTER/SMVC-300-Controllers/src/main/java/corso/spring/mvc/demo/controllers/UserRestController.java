package corso.spring.mvc.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import corso.spring.mvc.user.api.beans.User;
import corso.spring.mvc.user.api.services.UserService;

@Controller
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/load", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public User load(){
		return userService.findById(1);
	}
}
