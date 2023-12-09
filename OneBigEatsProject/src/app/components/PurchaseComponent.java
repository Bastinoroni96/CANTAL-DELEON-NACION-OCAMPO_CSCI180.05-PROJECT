package app.components;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    
    @Transactional
    public String startPayment(PurchaseRequestDto requestDto) {
        // Retrieve details from PurchaseRequestDto
        String modeOfPayment = requestDto.getModeOfPayment();
        String username = requestDto.getUsername();
        String foodStallName = requestDto.getFoodStallName();

        // Validate inputs or handle null cases here
        if (username == null || foodStallName == null || modeOfPayment == null) {
            return "Invalid request. Please provide all necessary details.";
        }

        User user = userRepository.findByUsername(username);
        FoodStall foodStall = foodStallRepository.findByName(foodStallName);

        if (user == null) {
            return "User not found.";
        }

        if (foodStall == null) {
            return "Food stall not found.";
        }

        // Create a transaction boundary here if these operations are related
        try {
            Purchase purchase = new Purchase();
            purchase.setUser(user);
            purchase.setFoodStall(foodStall);
            purchase.setModeOfPayment(modeOfPayment);
            // Set other properties in Purchase object based on requestDto
            // For example, purchase date, any other relevant details

            purchase = purchaseRepository.save(purchase);

            return "Purchase created successfully.";
        } catch (Exception e) {
            // Handle any exceptions that might occur during the transaction
            return "Failed to create purchase.";
        }
    }

    @Transactional
    public String addItemToPurchase(PurchaseRequestDto requestDto) {
        String itemName = requestDto.getItemName();
        int quantity = requestDto.getQuantity();
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

        // Retrieve the existing purchase for the user and food stall
        Purchase existingPurchase = purchaseRepository.findByUserAndFoodStallAndModeOfPayment(user, foodStall, null);

        if (existingPurchase == null) {
            return "No existing purchase found.";
        }

        Items item = itemsRepository.findByItem(itemName);

        if (item != null) {
            double itemPrice = item.getPrice();
            
            PurchaseQuantity purchaseQuantity = new PurchaseQuantity();
            purchaseQuantity.setPurchase(existingPurchase);
            purchaseQuantity.setItems(item);
            purchaseQuantity.setQuantity(quantity);
            purchaseQuantity.calculateAndSetAmount(itemPrice); // Calculate and set the amount

            purchaseQuantityRepository.save(purchaseQuantity);

            int updatedStock = item.getStock() - quantity;
            item.setStock(updatedStock);
            itemsRepository.save(item);
            
            // Update total price in Purchase entity
            List<PurchaseQuantity> purchaseQuantities = existingPurchase.getPurchaseQuantities();
            existingPurchase.updateTotalPrice(purchaseQuantities);
            purchaseRepository.save(existingPurchase);

            return "Item added to purchase successfully.";
        } else {
            return "Item not found.";
        }
    }

    
    //added this -Mica
    @Transactional
    public String editItemPurchase(PurchaseRequestDto requestDto) {
        String itemName = requestDto.getItemName();
        int newQuantity = requestDto.getQuantity();
        Long purchaseId = requestDto.getPurchaseId();

        Optional<Purchase> optionalPurchase = purchaseRepository.findById(purchaseId);
        if (!optionalPurchase.isPresent()) {
            return "Purchase not found.";
        }

        Purchase purchase = optionalPurchase.get();
        Items item = itemsRepository.findByItem(itemName);

        if (item == null) {
            return "Item not found.";
        }

        PurchaseQuantity purchaseQuantity = purchaseQuantityRepository.findByPurchaseAndItems(purchase, item);

        if (purchaseQuantity == null) {
            return "Item not found in this purchase.";
        }

        int oldQuantity = purchaseQuantity.getQuantity();
        purchaseQuantity.setQuantity(newQuantity);
        purchaseQuantityRepository.save(purchaseQuantity);

        int updatedStock = item.getStock() - (newQuantity - oldQuantity);
        item.setStock(updatedStock);
        itemsRepository.save(item);
        
        // Update total price in Purchase entity
        List<PurchaseQuantity> purchaseQuantities = purchase.getPurchaseQuantities();
        purchase.updateTotalPrice(purchaseQuantities);
        purchaseRepository.save(purchase);

        return "Item quantity updated successfully.";
    }



    
  //added this -Mica
    @Transactional
    public String removeItemPurchase(PurchaseRequestDto requestDto) {
        String itemName = requestDto.getItemName();
        Long purchaseId = requestDto.getPurchaseId();

        Optional<Purchase> optionalPurchase = purchaseRepository.findById(purchaseId);
        if (!optionalPurchase.isPresent()) {
            return "Purchase not found.";
        }

        Purchase purchase = optionalPurchase.get();
        Items item = itemsRepository.findByItem(itemName);

        if (item == null) {
            return "Item not found.";
        }

        PurchaseQuantity purchaseQuantity = purchaseQuantityRepository.findByPurchaseAndItems(purchase, item);

        if (purchaseQuantity == null) {
            return "Item not found in this purchase.";
        }

        int updatedStock = item.getStock() + purchaseQuantity.getQuantity();
        item.setStock(updatedStock);
        itemsRepository.save(item);

        double itemPrice = item.getPrice();
        double totalPrice = purchase.getTotalPrice() - (purchaseQuantity.getQuantity() * itemPrice);
        purchase.setTotalPrice(totalPrice);
        purchaseRepository.save(purchase);

        purchaseQuantityRepository.delete(purchaseQuantity);

        return "Item removed from purchase successfully.";
    }




}
