package app.entities;

import java.time.LocalDate;
import java.util.List;

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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Purchase
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long purchaseId;
	
//	fk purchaseUser
	@ManyToOne
    @JoinColumn(name = "username")
    private User user;
	
//	fk foodStallName
	@ManyToOne
    @JoinColumn(name = "foodStallID", referencedColumnName = "name")
    private FoodStall foodStall;
	
	@NotNull
	@Pattern(regexp = "(?i)(\\W|^)(cash|gcash|maya|)(\\W|$)",  message = "Must be Cash, Gcash, Maya")
	@Column
	private String modeOfPayment;
	
	@NotNull
	@Column
	private Double totalPrice;
	
	@NotNull
	@Column
	private LocalDate purchaseDate;
	
	@OneToMany(mappedBy = "purchase")
    private List<PurchaseQuantity> purchaseQuantities;
	
	public Purchase() {
        // Default constructor
    }

	public Purchase(@NotNull @Size(max = 6) Long purchaseId, User user, FoodStall foodStall,
            @NotNull @Pattern(regexp = "(?i)(\\W|^)(cash|gcash|maya|)(\\W|$)", message = "must be cat or dog") String modeOfPayment,
            @NotNull Double totalPrice, @NotNull LocalDate purchaseDate) {
		this.purchaseId = purchaseId;
		this.user = user;
		this.foodStall = foodStall;
		this.modeOfPayment = modeOfPayment;
		this.totalPrice = totalPrice;
		this.purchaseDate = purchaseDate;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FoodStall getFoodStall() {
		return foodStall;
	}

	public void setFoodStall(FoodStall foodStall) {
		this.foodStall = foodStall;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", user=" + user + ", foodStall=" + foodStall + ", modeOfPayment="
				+ modeOfPayment + ", totalPrice=" + totalPrice + ", purchaseDate=" + purchaseDate + "]";
	}

	
}
