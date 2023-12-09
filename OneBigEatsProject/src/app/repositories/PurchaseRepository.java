package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.FoodStall;
import app.entities.Purchase;
import app.entities.User;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>
{
	Purchase findByPurchaseId(Long purchaseId);

	Purchase findByUserAndFoodStall(User user, FoodStall foodStall);

}
