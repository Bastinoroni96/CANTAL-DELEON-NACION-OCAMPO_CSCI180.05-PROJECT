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
	private static final long serialVersionUID = 1L; // Serial version UID
	
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username") // Reference the username column in the User table
	private User owner;
	
	@OneToMany(mappedBy = "foodStall", cascade = CascadeType.ALL)
    private List<Menu> menus;

    // Constructors, getters, setters, and other methods...

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

	// Default constructor
    public FoodStall() {
        // Default constructor is needed by Hibernate
    }
	
	public FoodStall(@NotNull String name, @NotNull String location, User username) {
		super();
		this.name = name;
		this.location = location;
		this.owner = username;
	}
	
	public FoodStall(@NotNull String name, @NotNull String location, @NotNull Double averageReview, User username) {
		super();
		this.name = name;
		this.location = location;
		this.averageReview = averageReview;
		this.owner = username;
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

	public User getUsername() {
		return owner;
	}

	public void setUsername(User username) {
		this.owner = username;
	}

	@Override
	public String toString() {
		return "FoodStall [name=" + name + ", location=" + location + ", averageReview=" + averageReview + ", username="
				+ owner + "]";
	}

}
