package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ItemID;

    @NotNull
    @Column
    private String item;

    @NotNull
    @Column
    private Double price;

    @NotNull
    @Column
    private Integer stock;
    
    @ManyToOne
    private Menu menu;

    

	public Long getItemID() {
		return ItemID;
	}



	public void setItemID(Long itemID) {
		ItemID = itemID;
	}



	public String getItem() {
		return item;
	}



	public void setItem(String item) {
		this.item = item;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public Integer getStock() {
		return stock;
	}



	public void setStock(Integer stock) {
		this.stock = stock;
	}



	public Menu getMenu() {
		return menu;
	}



	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	@Override
	public String toString() {
		return "MenuItem [ItemID=" + ItemID + ", item=" + item + ", price=" + price + ", stock=" + stock + ", menu="
				+ menu + "]";
	}



	

    
}