package app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Items;
import app.entities.Purchase;
import app.entities.PurchaseQuantity;

public interface PurchaseQuantityRepository extends JpaRepository<PurchaseQuantity, Long>
{

	PurchaseQuantity findByPurchaseAndItems(Purchase purchase, Items items);

}
