package app.components;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.User;
import app.repositories.UserRepository;


//import app.repositories.UserRepository;

@Component
public class UserComponent 
{
	@Autowired
	private UserRepository UserRepo;
	
	public String createNewUser(String username, String password)
	{
		//Add validation stuff like deny creation if username already exist in database
		User u = new User();
		u.setUsername(username);
        u.setPassword(password);
		u = UserRepo.save(u);
		return u.getUsername();
	}
	
	public String loginUser(String username, String password) 
	{
		User user = UserRepo.findByUsernameAndPassword(username, password);
		return (user != null) ? "Login successful" : "Invalid username or password";
	}
	
}
