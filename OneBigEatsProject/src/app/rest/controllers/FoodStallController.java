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
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createFoodStall(FoodStallDto foodstallDto)
	{		
		return fs.createFoodStall(foodstallDto.getName(), foodstallDto.getLocation(), foodstallDto.getOwnerUsername());
		
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteFoodStall(FoodStallDto foodstallDto)
	{
		boolean deleted = fs.deleteFoodStall(foodstallDto.getName());
		
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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String editFoodStall(FoodStallDto foodstallDto)
	{
		String result = fs.editFoodStall(
				foodstallDto.getToEditName(), 
				foodstallDto.getNewName(), 
				foodstallDto.getNewLocation());
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
