package app.components;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import app.repositories.PurchaseRepository;

@Component
public class PurchaseOrderComponent {
	
    public String orderMade() {
        return "Purchase order made";
    }
}