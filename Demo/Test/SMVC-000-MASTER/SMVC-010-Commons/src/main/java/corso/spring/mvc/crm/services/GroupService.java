package corso.spring.mvc.crm.services;

import java.util.List;

import corso.spring.mvc.crm.dao.filters.FilterGroup;
import corso.spring.mvc.crm.services.beans.Group;

public interface GroupService {

	Group findById(long id);
	
	List<Group> listContacts();
	
	List<Group> findByFilters(FilterGroup filter);
	
	Long delete(Group toDelete);
	
	Long update(Group updatedContact);
	
	Long save(Group newContact);
}
