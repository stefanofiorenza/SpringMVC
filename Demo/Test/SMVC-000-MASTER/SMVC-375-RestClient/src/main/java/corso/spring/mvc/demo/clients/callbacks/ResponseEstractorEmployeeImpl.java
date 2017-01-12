package corso.spring.mvc.demo.clients.callbacks;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;

import com.fasterxml.jackson.databind.ObjectMapper;

import corso.spring.mvc.demo.rest.beans.Employee;

public class ResponseEstractorEmployeeImpl implements ResponseExtractor<Employee>{

	@Override
	public Employee extractData(ClientHttpResponse response) throws IOException {
		
		 ObjectMapper jsonObjectMapper= new ObjectMapper();
		 byte [] responseAsBytes= IOUtils.toByteArray(response.getBody());
		 Employee emp=jsonObjectMapper.readValue(responseAsBytes,Employee.class);
		 System.out.println("Response as Employee: "+emp);
		 return emp;
	}

}
