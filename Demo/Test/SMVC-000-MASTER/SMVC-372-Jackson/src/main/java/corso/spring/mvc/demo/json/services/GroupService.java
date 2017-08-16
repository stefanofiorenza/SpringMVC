package corso.spring.mvc.demo.json.services;

import java.util.List;

import corso.spring.mvc.demo.json.beans.Group;

public interface GroupService {

	List<Group> groupsByFilters(String name);
	
	Group groupDetails(Long groupId);
}
