package app.components;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.FoodStall;
import app.entities.Items;
import app.entities.Purchase;
import app.entities.PurchaseQuantity;
import app.entities.User;
import app.repositories.FoodStallRepository;
import app.repositories.ItemsRepository;
import app.repositories.PurchaseQuantityRepository;
import app.repositories.PurchaseRepository;
import app.repositories.UserRepository;
import app.rest.controllers.PurchaseRequestDto;

//import app.repositories.PurchaseRepository;

@Component
public class PurchaseComponent {

    
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private FoodStallRepository foodStallRepository;
	
	@Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private PurchaseQuantityRepository purchaseQuantityRepository;

    public String addItemPurchase(PurchaseRequestDto requestDto) {
    	// Retrieve details from PurchaseRequestDto
    	String itemName = requestDto.getItemName();
        int quantity = requestDto.getQuantity();
        String modeOfPayment = requestDto.getModeOfPayment();
        String username = requestDto.getUsername();
        String foodStallName = requestDto.getFoodStallName();
        
        User user = userRepository.findByUsername(username);
        FoodStall foodStall = foodStallRepository.findByName(foodStallName);
        
        if (user == null) {
            return "User not found.";
        }

        if (foodStall == null) {
            return "Food stall not found.";
        }
        
        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setFoodStall(foodStall);
        purchase.setModeOfPayment(modeOfPayment);
        // Set other properties in Purchase object based on requestDto
        
        purchase = purchaseRepository.save(purchase);
        
        Items item = itemsRepository.findByItem(itemName);
        
        if (item != null) {
            PurchaseQuantity purchaseQuantity = new PurchaseQuantity();
            purchaseQuantity.setPurchase(purchase);
            purchaseQuantity.setItems(item);
            purchaseQuantity.setQuantity(quantity);
            // Set other properties for PurchaseQuantity as required

            purchaseQuantityRepository.save(purchaseQuantity);

            int updatedStock = item.getStock() - quantity;
            item.setStock(updatedStock);
            itemsRepository.save(item);

            return "Item added to purchase successfully.";
        } else {
            return "Item not found.";
        }
    	
    }
    
    //added this -Mica
    public String editItemPurchase(PurchaseRequestDto requestDto) {
        // Retrieve details from PurchaseRequestDto
        String itemName = requestDto.getItemName();
        int newQuantity = requestDto.getQuantity();
        int purchaseId = requestDto.getPurchaseId();

        // Find purchase
        Purchase purchase = purchaseRepository.findById(purchaseId);
        if (purchase == null) {
            return "Purchase not found.";
        }

        // Find purchase quantity
        PurchaseQuantity purchaseQuantity = purchaseQuantityRepository.findByPurchaseAndItemName(purchase, itemName);
        if (purchaseQuantity == null) {
            return "Item not found in this purchase.";
        }

        // Update quantity and update stock
        int oldQuantity = purchaseQuantity.getQuantity();
        purchaseQuantity.setQuantity(newQuantity);
        purchaseQuantityRepository.save(purchaseQuantity);

        // Update stock in items
        Items item = purchaseQuantity.getItems();
        int updatedStock = item.getStock() - (newQuantity - oldQuantity);
        item.setStock(updatedStock);
        itemsRepository.save(item);

        return "Item quantity updated successfully.";
    }
    
  //added this -Mica
    public String removeItemPurchase(PurchaseRequestDto requestDto) {
        // Retrieve details from PurchaseRequestDto
        String itemName = requestDto.getItemName();
        int purchaseId = requestDto.getPurchaseId();

        // Find purchase
        Purchase purchase = purchaseRepository.findById(purchaseId);
        if (purchase == null) {
            return "Purchase not found.";
        }

        // Find purchase quantity
        PurchaseQuantity purchaseQuantity = purchaseQuantityRepository.findByPurchaseAndItemName(purchase, itemName);
        if (purchaseQuantity == null) {
            return "Item not found in this purchase.";
        }

        // Update stock in items
        Items item = purchaseQuantity.getItems();
        int updatedStock = item.getStock() + purchaseQuantity.getQuantity();
        item.setStock(updatedStock);
        itemsRepository.save(item);

        // Delete purchase quantity and update purchase total cost
        purchaseQuantityRepository.delete(purchaseQuantity);
        purchase.setTotalPrice(purchase.getTotalPrice() - (purchaseQuantity.getQuantity() * item.getPrice()));
        purchaseRepository.save(purchase);

        return "Item removed from purchase successfully.";
    }


}
