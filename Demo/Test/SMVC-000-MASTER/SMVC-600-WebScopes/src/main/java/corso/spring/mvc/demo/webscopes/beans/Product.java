package corso.spring.mvc.demo.webscopes.beans;

import lombok.Data;

@Data
public class Product {

	private int id;
	private String name;
	
	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Product(){}
	
	
}
