package corso.spring.mvc.demo.rest.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExportWrapper {

	List<Employee> employees= new ArrayList<Employee>();

	public List<Employee> getEmployees() {
		return employees;
	}
	
	
}
