package corso.spring.mvc.user.api.services;

import java.util.List;

import corso.spring.mvc.user.api.beans.User;

public interface UserService {

	User findById(Integer id);
	
	List<User> findAll();

	void saveOrUpdate(User user);
	
	void delete(int id);
	
}