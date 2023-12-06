package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.PurchaseQuantity;
import app.entities.User;

public interface PurchaseQuantityRepository extends JpaRepository<PurchaseQuantity, Long>
{
	 PurchaseQuantity findById_Username(User username);
}
