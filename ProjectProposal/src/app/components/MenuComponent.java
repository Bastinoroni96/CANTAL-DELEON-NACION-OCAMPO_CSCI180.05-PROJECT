package app.components;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.FoodStall;
import app.entities.Menu;
import app.entities.MenuItem;
import app.repositories.FoodStallRepository;
import app.repositories.MenuRepository;

@Component
public class MenuComponent {

    @Autowired
    private MenuRepository menuRepo;

    @Autowired
    private FoodStallRepository foodStallRepo;

    @Transactional
    public String createMenuForFoodStall(String foodStallName) {
        FoodStall foodStall = foodStallRepo.findByName(foodStallName);

        if (foodStall != null) {
            Menu newMenu = new Menu(foodStall);
            menuRepo.save(newMenu);
            return "Menu created for FoodStall: " + foodStall.getName();
        } else {
            return "FoodStall not found with name: " + foodStallName;
        }
    }

    @Transactional
    public String addItemToMenu(String foodStallName, String item, Double price, Integer stock) {
        FoodStall foodStall = foodStallRepo.findByName(foodStallName);
        if (foodStall != null) {
            List<Menu> menus = foodStall.getMenus(); // Get the list of menus associated with the FoodStall
            
            if (menus != null && !menus.isEmpty()) {
                // For simplicity, assuming we're adding the item to the first menu associated with the food stall
                Menu menu = menus.get(0); // Get the first Menu associated with the FoodStall
                
                MenuItem menuItem = new MenuItem();
                menuItem.setItem(item);
                menuItem.setPrice(price);
                menuItem.setStock(stock);
                menuItem.setMenu(menu); // Associate the MenuItem with the Menu

                menu.getMenuItems().add(menuItem); // Add MenuItem to the Menu's list of items
                menuRepo.save(menu);

                return "Item added to the first Menu of FoodStall: " + foodStallName + " with Item ID: " + menuItem.getItemID();
            } else {
                return "No menus found for FoodStall: " + foodStallName;
            }
        } else {
            return "FoodStall not found with name: " + foodStallName;
        }
    }

    @Transactional
    public String editMenuItem(Long menuId, String oldItemName, String newItemName, Double newPrice, Integer newStock) {
        Optional<Menu> optionalMenu = menuRepo.findById(menuId);
        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            MenuItem itemToEdit = menu.getMenuItems().stream()
                    .filter(item -> item.getItem().equals(oldItemName))
                    .findFirst()
                    .orElse(null);
            if (itemToEdit != null) {
                itemToEdit.setItem(newItemName);
                itemToEdit.setPrice(newPrice);
                itemToEdit.setStock(newStock);
                menuRepo.save(menu);
                return "Menu item updated successfully";
            } else {
                return "Menu item not found";
            }
        } else {
            return "Menu not found";
        }
    }

    @Transactional
    public String deleteMenuItem(Long menuId, String itemName) {
        Optional<Menu> optionalMenu = menuRepo.findById(menuId);
        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            MenuItem itemToDelete = menu.getMenuItems().stream()
                    .filter(item -> item.getItem().equals(itemName))
                    .findFirst()
                    .orElse(null);
            if (itemToDelete != null) {
                menu.getMenuItems().remove(itemToDelete);
                menuRepo.save(menu);
                return "Menu item deleted successfully";
            } else {
                return "Menu item not found";
            }
        } else {
            return "Menu not found";
        }
    }
}
