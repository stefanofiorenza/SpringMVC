package corso.spring.mvc.demo.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import corso.spring.mvc.user.api.beans.User;
import corso.spring.mvc.user.api.services.UserService;

@Controller
@RequestMapping("/form")
@Slf4j
public class UserFormController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public ModelAndView findUser() {
		ModelAndView mav = new ModelAndView("frmUserView");
		mav.addObject("msg", "Message From Controller");
		mav.addObject("userForm", new User());
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(User user) {
		log.info("Reveived User: "+user.toString());
		ModelAndView mav = new ModelAndView("frmUserView");
		mav.addObject("msg", "User Saved");
		mav.addObject("userForm",user);
		return mav;
	}
}
