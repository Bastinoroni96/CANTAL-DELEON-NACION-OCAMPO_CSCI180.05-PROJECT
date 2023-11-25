package app.rest.controllers;

import java.util.List;

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

import app.components.FoodStallComponent;
import app.entities.FoodStall;

@Component
@Path("/foodstall")
public class FoodStallController
{
	@Autowired
	private FoodStallComponent fs;
	
	@POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String createFoodStall(
			@FormParam("name") String name,
			@FormParam("location") String location,
			@FormParam("ownerUsername") String ownerUsername)
	{
		String result = fs.createFoodStall(name, location, ownerUsername);
		
		return result;
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteFoodStall(@FormParam("name") String name)
	{
		boolean deleted = fs.deleteFoodStall(name);
		
		if (deleted) 
		{
            return "Food stall deleted successfully";
        } 
		else 
		{
            return "Failed to delete food stall";
        }
	}
	
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String editFoodStall(
			@FormParam("toEditName") String toEditName,
			@FormParam("newName") String newName,
			@FormParam("newLocation") String newLocation)
	{
		String result = fs.editFoodStall(toEditName, newName, newLocation);
        return result;
	}

	@POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FoodStall> listFoodStalls()
	{
		List<FoodStall> foodStalls = fs.getAllFoodStalls();
	    return foodStalls;
	}
}
