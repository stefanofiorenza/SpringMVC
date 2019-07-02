package corso.spring.mvc.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import corso.spring.mvc.crm.services.ContactService;
import corso.spring.mvc.demo.rest.beans.ExportWrapper;
import corso.spring.mvc.demo.rest.service.EmployeeService;
import corso.spring.mvc.demo.views.FileFormatConsts;

@Controller
@RequestMapping("/export")
public class ExportController {

	@Autowired
	private ContactService contactService; 
	
	@RequestMapping("/csv")
	public ModelAndView exportEmployeesAsCsv(){
		
		ModelAndView mav= new ModelAndView(FileFormatConsts.EXPORT_CSV);
		mav.addObject(FileFormatConsts.EXPORT_DATA, contactService.listContacts());
		return mav;
	}
	
	@RequestMapping("/excel")
	public ModelAndView exportEmployeesAsExcel(){		
		ModelAndView mav= new ModelAndView(FileFormatConsts.EXPORT_EXCEL);
		mav.addObject(FileFormatConsts.EXPORT_DATA, contactService.listContacts());
		return mav;
	}
	

}
