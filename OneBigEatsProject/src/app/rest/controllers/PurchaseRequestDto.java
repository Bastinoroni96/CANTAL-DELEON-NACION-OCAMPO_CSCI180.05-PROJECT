package app.rest.controllers;

public class PurchaseRequestDto {
	private String itemName;
    private int quantity;
    private String modeOfPayment;
    private String username;
    private String foodStallName;
    private Long purchaseId;
    
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
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	// Default constructor
    public PurchaseRequestDto() {
    }
	
	public PurchaseRequestDto(String itemName, int quantity, String modeOfPayment, String username,
			String foodStallName, Long purchaseId) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.modeOfPayment = modeOfPayment;
		this.username = username;
		this.foodStallName = foodStallName;
		this.purchaseId = purchaseId;
	}
	@Override
	public String toString() {
		return "PurchaseRequestDto [itemName=" + itemName + ", quantity=" + quantity + ", modeOfPayment="
				+ modeOfPayment + ", username=" + username + ", foodStallName=" + foodStallName + ", purchaseId="
				+ purchaseId + "]";
	}
    
    

}
