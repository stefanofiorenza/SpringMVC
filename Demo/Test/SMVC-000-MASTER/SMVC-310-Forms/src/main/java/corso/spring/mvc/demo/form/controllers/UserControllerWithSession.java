package corso.spring.mvc.demo.form.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.ListView;

import lombok.extern.slf4j.Slf4j;

import org.mockito.internal.util.collections.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import corso.spring.mvc.demo.form.validator.UserFormValidator;
import corso.spring.mvc.user.api.beans.User;



@Controller
@RequestMapping("/users/v3")
//@SessionAttributes({ ControllerConsts.USER_S_KEY, ControllerConsts.SESSION_LVL_SKILLS,ControllerConsts.SESSION_LVL_KEY_B })
@Slf4j
public class UserControllerWithSession {

	
	
	@ModelAttribute(ControllerConsts.SESSION_LVL_SKILLS)
	public List<String> initViewData(){
		List<String> listOfSkills = new ArrayList<String>();
		listOfSkills.add("Java");
		listOfSkills.add("Scala");
		listOfSkills.add("Ruby");
		listOfSkills.add("C#");
		return listOfSkills;
	}
	
	
	
	@ModelAttribute(ControllerConsts.USER_S_KEY)
	public User initCommandObject(){
		User user = new User();
		user.setName("Please enter name ..");
		user.setEmail("Please enter Email ..");
		return user;
	}
	
	
	//TC8: CommandObj init in handler (ModelAndView)
	@RequestMapping(value = "/step1", method = RequestMethod.GET)
	public ModelAndView saveUserStep1() {
		log.debug("Step1 : Create empty User command Object");
		ModelAndView mav = new ModelAndView(ControllerConsts.OUT_DEMO04_INDEX);
		mav.addObject(ControllerConsts.USER_S_KEY, new User());
		return mav;	
	}
	
	
	//TC9: @ModelAttribute recupera CommandObject inizializzato in metodo @ModelAttribute (abilitare @SessionAttribute)
//	@RequestMapping(value = "/step1", method = RequestMethod.GET)
//	public ModelAndView saveUserStep1(@ModelAttribute(ControllerConsts.USER_S_KEY) User user) {
//		log.debug("Step1 : Create empty User command Object");
//		ModelAndView mav = new ModelAndView(ControllerConsts.OUT_DEMO04_INDEX);
//		return mav;		
//	}
	

	@RequestMapping(value = "/step2", method = RequestMethod.POST)
	public ModelAndView saveUserStep2(@ModelAttribute(ControllerConsts.USER_S_KEY) User user) {
		
			log.info("Step2 User: {}", user.toString());		
			ModelAndView mav = new ModelAndView(ControllerConsts.OUT_DEMO04_STEP1);
			//mav.addObject(ControllerConsts.USER_KEY, user);
			return mav;				
	}


	
	@RequestMapping(value = "/step3", method = RequestMethod.POST)
	public ModelAndView saveUserStep3(@ModelAttribute(ControllerConsts.USER_S_KEY) User user) {
		
			log.info("Step3 User: {}", user.toString());		
			ModelAndView mav = new ModelAndView(ControllerConsts.OUT_DEMO04_RESULT);
			//mav.addObject(ControllerConsts.USER_KEY, user);
			return mav;				
	}
	

	//TC7: HttpSessionRequiredException 
	@RequestMapping(value = "/stepNotInSessionException", method = RequestMethod.GET)
	public ModelAndView stepNotInSessionException(@ModelAttribute("UnexistingKey") User user) {
		log.debug("Will trigger Exception");
		ModelAndView mav = new ModelAndView("demo04SessionIndex");
		//mav.addObject(ControllerConsts.USER_KEY, new User());
		return mav;	
	}


}