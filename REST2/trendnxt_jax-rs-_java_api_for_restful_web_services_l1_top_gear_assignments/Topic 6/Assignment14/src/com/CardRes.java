package com;

import java.math.BigInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("card")
public class CardRes {
	@POST
	@Path("validate")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean validate(@FormParam("number") BigInteger number) {
		Controller c=new Controller();
		Card c1=new Card();
		c1.setNumber(number);
		return c.validate(c1);
	}
}
