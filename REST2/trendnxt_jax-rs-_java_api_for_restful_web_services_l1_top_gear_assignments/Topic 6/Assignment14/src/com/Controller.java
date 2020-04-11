package com;

import java.math.BigInteger;

public class Controller {
	public boolean validate(Card c) {
		BigInteger n=c.getNumber();
		if(n.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
			return true;
		}
		else
			return false;
	}
}
