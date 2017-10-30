package corso.spring.mvc.crm.services;

import java.util.List;

import corso.spring.mvc.crm.dao.filters.FilterCustomer;
import corso.spring.mvc.crm.services.beans.Customer;

public interface CustomerService {

	Customer findById(long id);
	
	List<Customer> listContacts();
	
	List<Customer> findByFilters(FilterCustomer filter);
	
	Long delete(Customer toDelete);
	
	Long update(Customer updatedContact);
	
	Long save(Customer newContact);
}
