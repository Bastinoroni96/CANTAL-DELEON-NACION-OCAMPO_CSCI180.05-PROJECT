package app.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.MenuItem;


public interface MenuItemRepository extends JpaRepository<MenuItem, Long>
{

}
