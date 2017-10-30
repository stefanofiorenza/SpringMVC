package corso.spring.mvc.demo.webscopes.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class ShoppingCart implements Serializable{
	
	Set<Integer> productIds = new HashSet<Integer>();
	
	
	public boolean addProduct (Integer prodId){
		return productIds.add(prodId);
	}


	public boolean removeProduct(int prodId) {
		return productIds.remove(prodId);		
	}
	
	public Set<Integer> listProducts(){
		return productIds;
	}
	
		
}
