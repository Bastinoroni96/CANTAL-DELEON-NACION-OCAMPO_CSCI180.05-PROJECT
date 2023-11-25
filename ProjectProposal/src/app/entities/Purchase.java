package app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Purchase
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	@Size(max = 6)
	@Column
	private Long purchaseId;
	
//	fk purchaseUser
	@OneToOne
	@JoinColumn(name = "username")
	private User username;
	
//	fk foodStallName
	@OneToOne
	@JoinColumn(name = "foodStallID", referencedColumnName = "name")
	private FoodStall name;
	
	@NotNull
	@Pattern(regexp = "(?i)(\\W|^)(cash|gcash|maya|)(\\W|$)",  message = "must be cat or dog")
	@Column
	private String modeOfPayment;
	
	@NotNull
	@Column
	private Double totalPrice;
	
	@NotNull
	@Column
	private LocalDate purchaseDate;

	public Purchase(@NotNull @Size(max = 6) Long purchaseId, User username, FoodStall name,
			@NotNull @Pattern(regexp = "(?i)(\\W|^)(cash|gcash|maya|)(\\W|$)", message = "must be cat or dog") String modeOfPayment,
			@NotNull Double totalPrice, @NotNull LocalDate purchaseDate) {
		super();
		this.purchaseId = purchaseId;
		this.username = username;
		this.name = name;
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

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	public FoodStall getName() {
		return name;
	}

	public void setName(FoodStall name) {
		this.name = name;
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
		return "Purchase [purchaseId=" + purchaseId + ", username=" + username + ", name=" + name + ", modeOfPayment="
				+ modeOfPayment + ", totalPrice=" + totalPrice + ", purchaseDate=" + purchaseDate + "]";
	}
}
