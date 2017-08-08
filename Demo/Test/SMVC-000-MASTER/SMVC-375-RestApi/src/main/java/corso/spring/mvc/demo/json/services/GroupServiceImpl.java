package corso.spring.mvc.demo.json.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import corso.spring.mvc.demo.json.beans.Group;
import corso.spring.mvc.demo.json.dao.Repository;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	private Repository repository;
	
	@Override
	public List<Group> groupsByFilters(String name) {
		return repository.groupsByFilters(name);
	}

	@Override
	public Group groupDetails(Long groupId) {		
		return repository.groupDetails(groupId);
	}

}
