package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.MenuComponent;

@Component
@Path("/foodstall/menu")
public class MenuController {

    @Autowired
    private MenuComponent menu;
    
    @POST
    @Path("/createmenu")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String createMenu(@FormParam("foodStallName") String foodStallName) {
        // Call the method in MenuComponent to create the Menu
        String result = menu.createMenuForFoodStall(foodStallName);

        // Return the result, indicating whether the Menu creation was successful or not
        return result;
    }

    @POST
    @Path("/additem")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String addItemToMenu(
            @FormParam("menuId") String foodStallName,
            @FormParam("item") String item,
            @FormParam("price") Double price,
            @FormParam("stock") Integer stock) {
        // Call the method in MenuComponent to add the item to the specified Menu
        String result = menu.addItemToMenu(foodStallName, item, price, stock);

        // Return the result, indicating whether the item addition was successful or not
        return result;
    }
    
    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String editMenuItem(
            @FormParam("menuId") Long menuId,
            @FormParam("oldItemName") String oldItemName,
            @FormParam("newItemName") String newItemName,
            @FormParam("newPrice") Double newPrice,
            @FormParam("newStock") Integer newStock) {
        String result = menu.editMenuItem(menuId, oldItemName, newItemName, newPrice, newStock);
        return result;
    }
    
    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteMenuItem(
            @FormParam("menuId") Long menuId,
            @FormParam("itemName") String itemName) {
        String result = menu.deleteMenuItem(menuId, itemName);
        return result;
    }
    
}
