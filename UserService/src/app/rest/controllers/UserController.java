package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.UserComponent;
import app.entities.User;

@Component
@Path("/user")
public class UserController
{
	@Autowired
	private UserComponent userComponent;
	
	@POST
	@Path("/newuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createNewUser(UserDto userDto)
	{
		return userComponent.createNewUser(userDto.getUsername(), userDto.getPassword());
		
	}
	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String loginUser(
			@FormParam("username") String username,
			@FormParam("password") String password
			)
	{
		return userComponent.loginUser(username, password);
	}
	
	
	//Not sure how to go about the logout since when we assign a logout button, it should just redirect the user back to login screen
	//@POST
	//@Path("/logout")
	//@Produces(MediaType.TEXT_PLAIN_VALUE)
	//public String logoutUser()
	//{
		//return "logout user";
	//}
}
