package corso.spring.mvc.demo.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import corso.spring.mvc.demo.rest.beans.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> listAll() {
		List<Employee> employees = new ArrayList<>();
		for (int i=0; i<100; i++){
			employees.add(new Employee("Name"+i,"Email"+i));
		}
		
		return employees;
	}

}
