package app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class User
{
	@Id
	@Column(nullable = false, unique = true)
	private String username;
	
	@NotNull
	@Column
	private String password;
	
	@Column(nullable = true) // Set nullable to true for the name field
	private String name;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodStall> foodStalls;
	

	// Default constructor
    public User() {
        // Default constructor is needed by Hibernate
    }
    
	
	// Constructor without name and foodStall
    public User(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.password = password;
    }
	
    public User(@NotNull String username, @NotNull String password, String name) {
        super();
        this.username = username;
        this.password = password;
        this.name = name;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<FoodStall> getFoodStalls() {
        return foodStalls;
    }
	
	public void setFoodStalls(List<FoodStall> foodStalls) {
        this.foodStalls = foodStalls;
    }

	
    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", name=" + name + "]";
    }

}
