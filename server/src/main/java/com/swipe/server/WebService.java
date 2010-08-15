package com.swipe.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

@Path("/soa")
@Service
public class WebService {
	
	@GET
	@Path("/processTransaction.xml")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public SwipeResponse processTransaction(@QueryParam("amount") Double amount,
			                                @QueryParam("customerId") Integer customerId) {
		
		Swipe.processTransaction(this.getMockTransaction(amount, customerId));
		
		SwipeResponse response = new SwipeResponse();
		response.setResponseCode("100");
		
		return response;
	}
	
	private Transaction getMockTransaction(Double amount, Integer customerId) {
		Customer customer = new Customer(customerId, (customerId % 2 == 0) ? Notification.Email() : Notification.Text());
		Transaction transaction = new Transaction(1, amount, customer);
		
		return transaction;
	}

}
