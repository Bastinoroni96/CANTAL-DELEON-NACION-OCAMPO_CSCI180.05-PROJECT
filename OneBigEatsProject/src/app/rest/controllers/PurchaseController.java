package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.PurchaseComponent;

@Component
@Path("/purchase")
public class PurchaseController {
	
	@Autowired
    private PurchaseComponent purchaseComponent;
	
	@POST
    @Path("/additem")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addItemPurchase(PurchaseRequestDto requestDto) {
        return purchaseComponent.addItemToPurchase(requestDto);
    }
	
	//added this -Mica
	@POST
	@Path("/edititem")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String editItemPurchase(PurchaseRequestDto requestDto) {
		return purchaseComponent.editItemPurchase(requestDto);
	}
	
	//added this -Mica
	@POST
	@Path("/removeitem")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String removeItemPurchase(PurchaseRequestDto requestDto) {
		return purchaseComponent.removeItemPurchase(requestDto);
	}
	

    
	@POST
	@Path("/startpurchase")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String startPayment(PurchaseRequestDto requestDto) {
	    return purchaseComponent.startPayment(requestDto);
	}
}
