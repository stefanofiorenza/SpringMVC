package corso.spring.mvc.demo.clients.configs;

public class RestConfig {

	private int maxConnPoolSize;	
	private int maxThreadPerRoute;
	private int connectionTimeOutInMillis;	
	private int requestTimeOutInMillis;	
	private String endpointJson;
	private String endpointXml;
	
	
	public int getMaxConnPoolSize() {
		return maxConnPoolSize;
	}
	public void setMaxConnPoolSize(int maxConnPoolSize) {
		this.maxConnPoolSize = maxConnPoolSize;
	}
	public int getMaxThreadPerRoute() {
		return maxThreadPerRoute;
	}
	public void setMaxThreadPerRoute(int maxThreadPerRoute) {
		this.maxThreadPerRoute = maxThreadPerRoute;
	}
	public int getConnectionTimeOutInMillis() {
		return connectionTimeOutInMillis;
	}
	public void setConnectionTimeOutInMillis(int connectionTimeOutInMillis) {
		this.connectionTimeOutInMillis = connectionTimeOutInMillis;
	}
	public int getRequestTimeOutInMillis() {
		return requestTimeOutInMillis;
	}
	public void setRequestTimeOutInMillis(int requestTimeOutInMillis) {
		this.requestTimeOutInMillis = requestTimeOutInMillis;
	}
	public String getEndpointJson() {
		return endpointJson;
	}
	public void setEndpointJson(String endpointJson) {
		this.endpointJson = endpointJson;
	}
	public String getEndpointXml() {
		return endpointXml;
	}
	public void setEndpointXml(String endpointXml) {
		this.endpointXml = endpointXml;
	}
	
	
	
}
