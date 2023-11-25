package app.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> 
{
    List<Menu> findByMenuItems_Item(String item);
}