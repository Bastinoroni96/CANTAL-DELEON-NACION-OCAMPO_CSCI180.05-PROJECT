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
	@EmbeddedId
    private PurchaseQuantityId id;
	
	@NotNull
	@Column
	private String item;
	
	@NotNull
	@Min(1)
	@Column
	private Integer quantity;

	public PurchaseQuantity() {
        // Default constructor required by JPA
    }
	
	@ManyToOne
    @JoinColumn(name = "purchaseUser", insertable = false, updatable = false)
    private User user;
	
	public PurchaseQuantity(PurchaseQuantityId id, @NotNull String item, @NotNull @Min(1) Integer quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

	public PurchaseQuantityId getId() {
        return id;
    }

	public void setId(PurchaseQuantityId id) {
        this.id = id;
    }

	public String getItem() {
        return item;
    }

	public void setItem(String item) {
        this.item = item;
    }

	public Integer getQuantity() {
        return quantity;
    }

	public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	@Override
	public String toString() {
		return "PurchaseQuantity [id=" + id + ", item=" + item + ", quantity=" + quantity + ", user=" + user + "]";
	}

	

}
