package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class PurchaseQuantity
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseQuantityId;
	
	@ManyToOne
    @JoinColumn(name = "purchase")
    private Purchase purchase;
	
	@ManyToOne
    @JoinColumn(name = "items")
    private Items items;
	
	@NotNull
	@Min(1)
	@Column
    private int quantity;
	
	@Column
	private double amount;

	public PurchaseQuantity() {
        // Default constructor 
    }

	public PurchaseQuantity(Long purchaseQuantityId, Purchase purchase, Items items, @NotNull @Min(1) int quantity,
			double amount) {
		super();
		this.purchaseQuantityId = purchaseQuantityId;
		this.purchase = purchase;
		this.items = items;
		this.quantity = quantity;
		this.amount = amount;
	}

	public Long getPurchaseQuantityId() {
		return purchaseQuantityId;
	}

	public void setPurchaseQuantityId(Long purchaseQuantityId) {
		this.purchaseQuantityId = purchaseQuantityId;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PurchaseQuantity [purchaseQuantityId=" + purchaseQuantityId + ", purchase=" + purchase + ", items="
				+ items + ", quantity=" + quantity + ", amount=" + amount + "]";
	}
	
	
	
	
	
	

}
