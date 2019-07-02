package corso.spring.mvc.user.api.services;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import corso.spring.mvc.user.api.beans.User;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Override
	public User findById(Integer id) {
		User user = new User();
		user.setName("Stefano Fiorenza");
		user.setAddress("someMockAddress");
		user.setEmail("someEmail@SomeDomain.com");
		user.setGender("M");		
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
