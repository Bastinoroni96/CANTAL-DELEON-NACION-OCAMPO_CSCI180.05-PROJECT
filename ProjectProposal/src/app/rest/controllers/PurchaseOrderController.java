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

import app.components.PurchaseOrderComponent;

@Component
@Path("/order")
public class PurchaseOrderController {
	
	@Autowired
    private PurchaseOrderComponent purchaseOrderComponent;
	
    @GET
    @Path("/made")
    @Produces(MediaType.APPLICATION_JSON)
    public String orderMade() {
        return purchaseOrderComponent.orderMade();
    }
}
