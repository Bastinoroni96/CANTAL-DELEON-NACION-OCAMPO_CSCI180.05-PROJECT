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
    @Path("/additem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addItemToMenu(MenuDto menuDto) {
        String result = menu.addItemToFoodStall(
            menuDto.getFoodStallName(),
            menuDto.getItem(),
            menuDto.getPrice(),
            menuDto.getStock()
        );
        return result;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String editMenuItem(MenuDto menuDto) {
        String result = menu.editMenuItem(
            menuDto.getItemId(),
            menuDto.getNewItemName(),
            menuDto.getNewPrice(),
            menuDto.getNewStock()
        );
        return result;
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteMenuItem(MenuDto menuDto) {
        String result = menu.deleteMenuItem(menuDto.getItemId());
        return result;
    }
}

