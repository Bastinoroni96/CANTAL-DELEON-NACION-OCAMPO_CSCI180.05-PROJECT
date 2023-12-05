package app.rest.controllers;

public class FoodStallDto {
	
	private String name;
	private String location;
	private String ownerUsername;
	
	//for editing
	private String toEditName;
    private String newName;
    private String newLocation;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOwnerUsername() {
		return ownerUsername;
	}
	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}
	
	//for editing
	public String getToEditName() {
        return toEditName;
    }

    public void setToEditName(String toEditName) {
        this.toEditName = toEditName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewLocation() {
        return newLocation;
    }

    public void setNewLocation(String newLocation) {
        this.newLocation = newLocation;
    }
	
	@Override
	public String toString() {
		return "FoodStallDto [name=" + name + ", location=" + location + ", ownerUsername=" + ownerUsername + "]";
	}
	
	
	
	

}
