package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>
{
	Purchase findByPurchaseId(Long purchaseId);

}
