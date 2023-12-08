package app.components;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.FoodStall;
import app.entities.Items;
import app.repositories.FoodStallRepository;
import app.repositories.ItemsRepository;

@Component
public class MenuComponent {

    @Autowired
    private ItemsRepository itemsRepo;

    @Autowired
    private FoodStallRepository foodStallRepo;

    @Transactional
    public String addItemToFoodStall(String foodStallName, String item, Double price, Integer stock) {
        FoodStall foodStall = foodStallRepo.findByName(foodStallName);
        if (foodStall != null) {
            Items newItem = new Items();
            newItem.setItem(item);
            newItem.setPrice(price);
            newItem.setStock(stock);
            newItem.setFoodstall(foodStall);

            itemsRepo.save(newItem);

            return "Item added to the FoodStall: " + foodStallName + " with Item ID: " + newItem.getItemID();
        } else {
            return "FoodStall not found with name: " + foodStallName;
        }
    }

    @Transactional
    public String editMenuItem(Long itemId, String newItemName, Double newPrice, Integer newStock) {
        Optional<Items> optionalItem = itemsRepo.findById(itemId);
        if (optionalItem.isPresent()) {
            Items itemToEdit = optionalItem.get();
            itemToEdit.setItem(newItemName);
            itemToEdit.setPrice(newPrice);
            itemToEdit.setStock(newStock);
            itemsRepo.save(itemToEdit);
            return "Menu item updated successfully";
        } else {
            return "Menu item not found";
        }
    }

    @Transactional
    public String deleteMenuItem(Long itemId) {
        Optional<Items> optionalItem = itemsRepo.findById(itemId);
        if (optionalItem.isPresent()) {
            itemsRepo.delete(optionalItem.get());
            return "Menu item deleted successfully";
        } else {
            return "Menu item not found";
        }
    }
}

