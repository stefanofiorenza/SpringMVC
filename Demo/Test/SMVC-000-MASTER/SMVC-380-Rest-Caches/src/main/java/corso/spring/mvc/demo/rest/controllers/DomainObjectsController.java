package corso.spring.mvc.demo.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import corso.spring.mvc.demo.rest.beans.Employee;


@Controller
@RequestMapping("/domain")
public class DomainObjectsController {

	
	
	@RequestMapping(value ="/demo/employee/echo/json", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Employee echoEmployeeAsJson(@RequestBody Employee inserted){
		return inserted;
	}
	
	
	
	@RequestMapping(value ="/demo/employee/echo/entity/json", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody  ResponseEntity<Employee> echoEmployeeAsHttpEntity(@RequestBody Employee inserted){
		 return new ResponseEntity<Employee>(inserted,HttpStatus.OK);
		 
	}
	

	

}
