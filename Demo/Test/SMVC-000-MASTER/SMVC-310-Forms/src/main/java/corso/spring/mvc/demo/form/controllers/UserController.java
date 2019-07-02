package corso.spring.mvc.demo.form.controllers;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import corso.spring.mvc.user.api.beans.User;
import corso.spring.mvc.user.api.services.UserService;



@Controller
@RequestMapping("/users/v1")
@Slf4j
public class UserController {

		
	@Autowired
	private UserService userService;
		

	//TC1 return ModelAndView
	//@RequestMapping(value = "/load", method = RequestMethod.GET)
	public ModelAndView findUserMav() {
		return resultAsModelAndView();
	}

	
	//TC2 display as Model + String outcome
	//@RequestMapping(value = "/load", method = RequestMethod.GET)
	public String findUserModelAndString(Model model) {
		model.addAttribute(ControllerConsts.USER_KEY, defaultUserInModelAndView());
		return ControllerConsts.OUT_DEMO01_RESULT;
	}
	
	//TC3 enable @ModelAttribute method
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public String findUser(Model implicitModel) {
		//defaultUserInModelAndView() is called first and load Model in Request Scope
		((User)implicitModel.asMap().get(ControllerConsts.USER_KEY)).setName("Name set In Handler");
		return ControllerConsts.OUT_DEMO01_RESULT;
	}
	
	//TC4
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView prepareSaveUser() {
		ModelAndView mav = new ModelAndView(ControllerConsts.OUT_DEMO02_INDEX);
		//mav.addObject(ControllerConsts.USER_KEY, new User());
		return mav;	
	}
	
	
	//TC5 @ModelAttribute args level
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute(ControllerConsts.USER_KEY) 
			User user) {

			log.debug("saveOrUpdateUser() : {}", user.toString());		
			ModelAndView mav = new ModelAndView(ControllerConsts.OUT_DEMO02_RESULT);
			mav.addObject(ControllerConsts.USER_KEY, user);
			return mav;		
	}

	
	private ModelAndView resultAsModelAndView(){		
		ModelAndView mav = new ModelAndView(ControllerConsts.OUT_DEMO01_RESULT);
		mav.addObject(ControllerConsts.USER_KEY, userService.findById(1));
		return mav;
	}
	
	
	//TC3, TC5 to enable 
	@ModelAttribute(ControllerConsts.USER_KEY)
	private User defaultUserInModelAndView(){
		User user = new User();
		user.setName("A Default Name");
		user.getSkill().addAll(skills());
		return user;
	}
	

	private List<String> skills(){
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Struts 1");
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("JSF");
		webFrameworkList.add("Apache Wicket");
		return webFrameworkList;
	}
	


}