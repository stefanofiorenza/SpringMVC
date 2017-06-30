package corso.spring.mvc.demo.clients.callbacks;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.AsyncClientHttpRequest;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.AsyncRequestCallback;
import org.springframework.web.client.RequestCallback;

import com.fasterxml.jackson.databind.ObjectMapper;

import corso.spring.mvc.demo.rest.beans.Employee;

public class AsynchRequestCallbackEmployeeImpl implements AsyncRequestCallback {

	@Override
	public void doWithRequest(AsyncClientHttpRequest request)
			throws IOException {
		request.getHeaders().add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		request.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
					
		Employee postEmp= new Employee("TestPostEmp","TestPostEmp@email.it");
		ObjectMapper jsonObjectMapper= new ObjectMapper();
		jsonObjectMapper.writeValue(request.getBody(), postEmp);
	}

}
