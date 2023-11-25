package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.entities.FoodStall;
import app.entities.User;
import app.repositories.FoodStallRepository;
import app.repositories.UserRepository;

//import app.repositories.FoodStallRepository;

@Component
public class FoodStallComponent 
{
	@Autowired
	private FoodStallRepository foodStallRepo;
	
	@Autowired
    private UserRepository userRepo;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String createFoodStall(String name, String location, String ownerUsername) 
	{
		// Check if the owner (User) exists
		User owner = userRepo.findByUsername(ownerUsername);
		if (owner == null) {
            return "Failed to create FoodStall. Owner with username " + ownerUsername + " not found.";
        }
		
		// Create a new FoodStall with the provided details and set the owner
        FoodStall foodStall = new FoodStall(name, location, owner);
        
        // Save the FoodStall to the database
        foodStall = foodStallRepo.save(foodStall);
        
        // Return a success message
        return "FoodStall created successfully with name: " + foodStall.getName();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteFoodStall(String name) 
	{
	    FoodStall foodStall = foodStallRepo.findByName(name);
	    if (foodStall != null) 
	    {
	        foodStallRepo.delete(foodStall);
	        return true;
	    } 
	    else 
	    {
	        return false;
	    }
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
    public String editFoodStall(String toEditName, String newName, String newLocation) {
        // Find the existing FoodStall by name
        FoodStall existingFoodStall = foodStallRepo.findByName(toEditName);

        if (existingFoodStall == null) {
            return "Failed to edit FoodStall. FoodStall with name " + toEditName + " not found.";
        }

        // Update the FoodStall properties
        if (newName != null && !newName.isEmpty()) {
            existingFoodStall.setName(newName);
        }

        if (newLocation != null && !newLocation.isEmpty()) {
            existingFoodStall.setLocation(newLocation);
        }

        // Save the changes to the database
        foodStallRepo.save(existingFoodStall);

        // Return a success message
        return "FoodStall edited successfully with name: " + existingFoodStall.getName();
    }
	
	public List<FoodStall> getAllFoodStalls() {
	    List<FoodStall> foodStalls = foodStallRepo.findAll();
	    return foodStalls;
	}
}
