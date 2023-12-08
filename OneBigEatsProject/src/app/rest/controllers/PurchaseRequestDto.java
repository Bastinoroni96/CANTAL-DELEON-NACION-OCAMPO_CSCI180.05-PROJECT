package app.rest.controllers;

public class PurchaseRequestDto {
	private String itemName;
    private int quantity;
    private String modeOfPayment;
    private String username;
    private String foodStallName;
    
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFoodStallName() {
		return foodStallName;
	}
	public void setFoodStallName(String foodStallName) {
		this.foodStallName = foodStallName;
	}
	public PurchaseRequestDto(String itemName, int quantity, String modeOfPayment, String username,
			String foodStallName) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.modeOfPayment = modeOfPayment;
		this.username = username;
		this.foodStallName = foodStallName;
	}
	@Override
	public String toString() {
		return "PurchaseRequestDto [itemName=" + itemName + ", quantity=" + quantity + ", modeOfPayment="
				+ modeOfPayment + ", username=" + username + ", foodStallName=" + foodStallName + "]";
	}
    
	

	
    
    

}
