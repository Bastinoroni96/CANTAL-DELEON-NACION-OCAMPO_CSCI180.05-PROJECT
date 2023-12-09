package app.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class FoodStall implements Serializable  
{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodStallID; // Generated ID as the primary key
	
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@NotNull
	@Column
	private String location;
	
	@NotNull
	@Column
	private Double averageReview = 0.00;
	
	@ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
	
	@OneToMany(mappedBy = "foodStall", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Items> items;
	
	@OneToMany(mappedBy = "foodStall", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchase> purchases;
	
	// Default constructor
    public FoodStall() {
        // Default constructor is needed by Hibernate
    }
	
	public FoodStall(@NotNull String name, @NotNull String location, User username) {
		super();
		this.name = name;
		this.location = location;
		this.user = username;
	}
	
	public FoodStall(@NotNull String name, @NotNull String location, @NotNull Double averageReview, User username) {
		super();
		this.name = name;
		this.location = location;
		this.averageReview = averageReview;
		this.user = username;
	}

	
	

	public Long getFoodStallID() {
		return foodStallID;
	}

	public void setFoodStallID(Long foodStallID) {
		this.foodStallID = foodStallID;
	}

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

	public Double getAverageReview() {
		return averageReview;
	}

	public void setAverageReview(Double averageReview) {
		this.averageReview = averageReview;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "FoodStall [foodStallID=" + foodStallID + ", name=" + name + ", location=" + location
				+ ", averageReview=" + averageReview + ", user=" + user + ", items=" + items + ", purchases="
				+ purchases + "]";
	}

	
	

}
