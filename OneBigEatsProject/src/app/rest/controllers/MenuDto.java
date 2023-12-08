package app.rest.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuDto {
    private String foodStallName;
    private String item;
    private Double price;
    private Integer stock;
    private Long itemId; // Change menuId to itemId for consistency
    private String newItemName; // Replace oldItemName with newItemName for editing item
    private Double newPrice; // Rename newPrice for consistency
    private Integer newStock; // Rename newStock for consistency
    
   
    public Long getItemId() {
        return itemId;
    }

    public String getFoodStallName() {
		return foodStallName;
	}

	public void setFoodStallName(String foodStallName) {
		this.foodStallName = foodStallName;
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

	public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getNewItemName() {
        return newItemName;
    }

    public void setNewItemName(String newItemName) {
        this.newItemName = newItemName;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public Integer getNewStock() {
        return newStock;
    }

    public void setNewStock(Integer newStock) {
        this.newStock = newStock;
    }
}
