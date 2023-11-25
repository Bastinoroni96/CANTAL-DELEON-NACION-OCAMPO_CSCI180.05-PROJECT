package app.entities;

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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    @Column
    private Long menuId;

    @OneToOne
    @JoinColumn(name = "foodStallID", referencedColumnName = "name")
    private FoodStall foodStall;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;
    
    

    // Default constructor
    public Menu() {
    
    }

    // Constructor without menuId
    public Menu(FoodStall foodStall) {
        this.foodStall = foodStall;
    }
    
    // Constructor without menuId
    public Menu(FoodStall foodStall, List<MenuItem> menuItems) {
        this.foodStall = foodStall;
        this.menuItems = menuItems;
    }
	

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public FoodStall getFoodStall() {
		return foodStall;
	}

	public void setFoodStall(FoodStall foodStall) {
		this.foodStall = foodStall;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", foodStall=" + foodStall + ", menuItems=" + menuItems + "]";
	}

	
}