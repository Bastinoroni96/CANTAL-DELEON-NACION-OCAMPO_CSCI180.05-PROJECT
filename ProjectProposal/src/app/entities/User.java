package app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FoodStall> ownedFoodStalls;
	
	@OneToMany(mappedBy = "id.username", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseQuantity> purchaseQuantities;
	
	
	

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

	public List<FoodStall> getOwnedFoodStalls() {
        return ownedFoodStalls;
    }
	
	public void setOwnedFoodStalls(List<FoodStall> ownedFoodStalls) {
        this.ownedFoodStalls = ownedFoodStalls;
    }
	
	public List<PurchaseQuantity> getPurchaseQuantities() {
        return purchaseQuantities;
    }

    public void setPurchaseQuantities(List<PurchaseQuantity> purchaseQuantities) {
        this.purchaseQuantities = purchaseQuantities;
    }
	
	
    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", name=" + name + "]";
    }

}
