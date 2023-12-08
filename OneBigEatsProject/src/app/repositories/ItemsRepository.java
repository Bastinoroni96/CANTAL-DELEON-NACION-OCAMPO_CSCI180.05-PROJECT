package app.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Items;


public interface ItemsRepository extends JpaRepository<Items, Long>
{
	Items findByItem(String item);
}
