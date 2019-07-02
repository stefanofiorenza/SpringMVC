package corso.spring.mvc.demo.webscopes.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import corso.spring.mvc.demo.webscopes.beans.Product;

@Component
public class ProductDao {

	private static final Map<Integer, Product> inMemoryTable= productTable();
	
	
	public Product findById(int id){
		return inMemoryTable.get(id);
	}
	
	private static Map<Integer, Product> productTable(){
		Map<Integer, Product> prodTable= new HashMap<Integer, Product>();
		prodTable.put(1, new Product(1,"Morellino Scansano"));
		prodTable.put(2, new Product(2,"Montepulciano"));
		prodTable.put(3, new Product(3,"Barbera"));
		prodTable.put(4, new Product(4,"Rosso Montalcino"));
		prodTable.put(5, new Product(5,"Negroamaro"));
		prodTable.put(6, new Product(6,"Amarone Valpolicella"));
		return prodTable;
	}
}
