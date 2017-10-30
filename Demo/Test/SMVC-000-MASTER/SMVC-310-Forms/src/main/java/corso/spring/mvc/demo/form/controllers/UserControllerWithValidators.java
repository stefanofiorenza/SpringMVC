package corso.spring.mvc.demo.form.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import corso.spring.mvc.demo.form.validator.UserFormValidator;
import corso.spring.mvc.user.api.beans.User;



@Controller
@RequestMapping("/users/v2")
@Slf4j
public class UserControllerWithValidators {


	@Autowired
	private UserFormValidator userFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView saveOrUpdateUserPage() {
		ModelAndView mav = new ModelAndView(ControllerConsts.OUT_DEMO03_INDEX);
		mav.addObject(ControllerConsts.USER_KEY, new User());
		return mav;	
	}
	
	//TC6: Validation  
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateUser(@ModelAttribute(ControllerConsts.USER_KEY) @Validated User user,BindingResult result) {

			if (result.hasErrors()) {
				ModelAndView mav = new ModelAndView(ControllerConsts.OUT_DEMO03_INDEX);
				User defaultUser = new User();
				defaultUser.setName("A_Default_Name");
				mav.addObject(ControllerConsts.USER_KEY, defaultUser);
				return mav;
				
			}else{
				log.debug("saveOrUpdateUser() : {}", user.toString());		
				ModelAndView mav = new ModelAndView(ControllerConsts.OUT_DEMO03_RESULT);
				mav.addObject(ControllerConsts.USER_KEY, user);
				return mav;		
			}
		
			
	}

	

	


}