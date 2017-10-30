package corso.spring.mvc.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import corso.spring.mvc.demo.basic.config.ViewConsts;

@Controller
@RequestMapping("/views/demo")
public class HelloWorldController {

	
	@RequestMapping(value="/hello/jsp", method = RequestMethod.GET)
	public ModelAndView helloWorldToJsp(@RequestParam(name="page") String page) {
		return createModelAndView(page);
	}
	
	@RequestMapping(value="/hello/xml", method = RequestMethod.GET)
	public ModelAndView helloWorldXmlView(@RequestParam(name="page") String page) {
		return createModelAndView(page);
	}
	
	@RequestMapping(value="/hello/prop", method = RequestMethod.GET)
	public ModelAndView helloWorldPropertyView(@RequestParam(name="page") String page) {
		return createModelAndView(page);
	}
	
	@RequestMapping(value="/hello/view", method = RequestMethod.GET)
	public ModelAndView helloWorldToCustomView() {
		ModelAndView model = new ModelAndView(ViewConsts.CUSTOM_VIEW);
		model.addObject("msg", "hello world");
		return model;
	}
	
	
	private ModelAndView createModelAndView(String pageParam){
		ModelAndView model = new ModelAndView(pageParam+"Page");
		model.addObject("msg", "hello world");
		return model;
	}

}