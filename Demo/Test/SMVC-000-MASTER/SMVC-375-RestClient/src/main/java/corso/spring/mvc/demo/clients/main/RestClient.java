package corso.spring.mvc.demo.clients.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRequestCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import corso.spring.mvc.demo.clients.RestClientComponent;
import corso.spring.mvc.demo.clients.callbacks.AsynchRequestCallbackEmployeeImpl;
import corso.spring.mvc.demo.clients.callbacks.EmployeeFutureParsingThread;
import corso.spring.mvc.demo.clients.callbacks.RequestCallbackEmployeeImpl;
import corso.spring.mvc.demo.clients.callbacks.ResponseEstractorEmployeeImpl;
import corso.spring.mvc.demo.rest.beans.Employee;

public class RestClient {
	
	private static final String ENDPOINT_GET_URI="http://localhost:8080/SMVC-370-REST/rest/domain/demo/employee/get/json";
	private static final String ENDPOINT_POST_URI="http://localhost:8080/SMVC-370-REST/rest/domain/demo/employee/echo/xml";
	
	private static final String ENDPOINT_POST_ENTITY_URI="http://localhost:8080/SMVC-370-REST/rest/domain/demo/employee/echo/entity/json";
	private static final String ENDPOINT_POST_SLOW_ENTITY_URI="http://localhost:8080/SMVC-370-REST/rest/domain/demo/employee/echo/entity/slow/json";
	
	private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

	
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("rest-context.xml");
		RestClientComponent restComponent= context.getBean(RestClientComponent.class);		
		
		//testRestGetResponseEntity(restComponent.getRestTemplate());
		//testRestGetEntity(restComponent.getRestTemplate());
		//testRestPostEntity(restComponent.getRestTemplate());
		//testRestPostEntity(restComponent.getRestTemplate());
		
		//testRestExchangeApi(restComponent.getRestTemplate());
		
		//testRestExchangeApiWithCallback(restComponent.getRestTemplate());
		testRestExchangeApiWithAsynchCallback();
	}
	
	
	private static void testRestGetResponseEntity(RestTemplate restTemplate){
		
		ResponseEntity<Employee> response = 
				  restTemplate.getForEntity(ENDPOINT_GET_URI,Employee.class);
		System.out.println(response);
		System.out.println("ResponseBody: "+response.getBody());		
	}
	
	private static void testRestGetEntity(RestTemplate restTemplate){
		Employee emp = 
				  restTemplate.getForObject(ENDPOINT_GET_URI,Employee.class);
		System.out.println("Response: "+emp);	
	}
	
	private static void testRestPostEntity(RestTemplate restTemplate){
		Employee postEmp= new Employee("TestPostEmp","TestPostEmp@email.it");
		HttpEntity<Employee> request= new HttpEntity<Employee>(postEmp);
		
		ResponseEntity<Employee> response = restTemplate.postForEntity(ENDPOINT_POST_URI,request,Employee.class);
		System.out.println(response);
		System.out.println("ResponseBody: "+response.getBody());		
	}
	
	
	private static void testRestPostObject(RestTemplate restTemplate){
		Employee postEmp= new Employee("TestPostEmp","TestPostEmp@email.it");
		Employee empResponse =restTemplate.postForObject(ENDPOINT_POST_URI,postEmp,Employee.class);
		System.out.println("Echo Response: "+empResponse);			
	}

	
	private static void testRestExchangeApi(RestTemplate restTemplate){
		
		
		//headers
		HttpHeaders httpHeaders =new HttpHeaders();
		httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		System.out.println("Headers for "+ENDPOINT_POST_ENTITY_URI);
		
		//body
		Employee postEmp= new Employee("TestPostEmp","TestPostEmp@email.it");
		
		HttpEntity<Employee> request= new HttpEntity<Employee>(postEmp,httpHeaders);
		ResponseEntity<Employee> response =restTemplate.exchange(ENDPOINT_POST_ENTITY_URI,
				HttpMethod.POST,request,Employee.class);
				
		System.out.println(response);
		System.out.println("ResponseBody: "+response.getBody());			
	}
	
	
	private static void testRestExchangeApiWithCallback(RestTemplate restTemplate){
						
		System.out.println("Before send");
		restTemplate.execute(ENDPOINT_POST_ENTITY_URI, 
				HttpMethod.POST,requestCallback, responseExtractor);
		System.out.println("After send");		
	}
	
	private static void testRestExchangeApiWithAsynchCallback(){
		System.out.println("Before send");
		AsyncRestTemplate asycTemp = new AsyncRestTemplate();
		Map<String,String> urlVariable = new HashMap<String, String>();
		ListenableFuture<Employee> future = asycTemp.execute(ENDPOINT_POST_SLOW_ENTITY_URI, HttpMethod.POST, 
				asynchRequestCallback, responseExtractor,urlVariable);
		Runnable separateThread= new EmployeeFutureParsingThread(future);
		executorService.submit(separateThread);
		System.out.println("do some work");
		System.out.println("End");
		
	}
	
	
	private static final AsyncRequestCallback asynchRequestCallback = new AsynchRequestCallbackEmployeeImpl();	
	private static final RequestCallback requestCallback = new RequestCallbackEmployeeImpl();	
	private static final ResponseExtractor<Employee> responseExtractor = new ResponseEstractorEmployeeImpl();

}
