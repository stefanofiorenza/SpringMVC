package corso.spring.mvc.demo.clients;

import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import corso.spring.mvc.demo.clients.configs.RestConfig;

public class RestClientComponent {

	private RestTemplate restTemplate;
	
	private CloseableHttpClient httpclient;  
	
	
		
	public RestClientComponent(RestConfig httpConfig){
		this.httpclient= createHttpClient(httpConfig);		
		this.restTemplate=new RestTemplate(new HttpComponentsClientHttpRequestFactory(this.httpclient));
	}
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	private CloseableHttpClient createHttpClient(RestConfig httpConfig ) {

	    RequestConfig.Builder requestBuilder = RequestConfig.custom();
	    requestBuilder.setConnectTimeout(httpConfig.getConnectionTimeOutInMillis())
	    	.setSocketTimeout(httpConfig.getConnectionTimeOutInMillis())
	    	.setConnectionRequestTimeout(httpConfig.getRequestTimeOutInMillis());
	    
	    HttpClientBuilder builder = HttpClientBuilder.create();
	    builder.setDefaultRequestConfig(requestBuilder.build());
	    
	    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setDefaultMaxPerRoute(httpConfig.getMaxThreadPerRoute());
		cm.setMaxTotal(httpConfig.getMaxConnPoolSize());
			
	    return builder.setConnectionManager(cm).build();
	    
	  }
	

}
