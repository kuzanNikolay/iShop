package edu.java.ishop.utils;

import java.math.RoundingMode;

public class MyRound {

	public MyRound() {
		// TODO Auto-generated constructor stub
	}
	
	public static double round(double value, int fractionDigitCount) {
		RoundingMode roundingMode = RoundingMode.HALF_UP;
	    return new java.math.BigDecimal(value).setScale(fractionDigitCount, roundingMode).doubleValue();
	}

}
