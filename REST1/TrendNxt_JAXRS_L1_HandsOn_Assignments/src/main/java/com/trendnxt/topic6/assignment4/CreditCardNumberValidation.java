package com.trendnxt.topic6.assignment4;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CreditCardNumberValidation {

	@GET
	@Path("/isValidCreditCardNumber/{creditCardNumber}")
	public String isValid(@PathParam("creditCardNumber") String creditCardNumber) {
		try {
			if (creditCardNumber != null && Long.valueOf(creditCardNumber) != null) {
				return String.valueOf(Long.valueOf(creditCardNumber) % 2 == 0);
			}
		} catch (NumberFormatException e) {
		}
		return String.valueOf(false);
	}

}
