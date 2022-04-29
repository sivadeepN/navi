package com.example.model;

import com.example.model_interfaces.IEMI;

public class EMI implements IEMI {
	private int amount;
	private int years;
	private Interest interest;

	public EMI(int amount, int rate, int years) {
		this.amount = amount;
		this.years = years;
		this.interest = new Interest(rate, years, amount);
	}

	public int getEmi() {
		int calculatedInterest = interest.getInterest();
		float noOfMonths = years * 12;
		return (int) Math.ceil((amount + calculatedInterest) / noOfMonths);
	}

	public int getAmount() {
		return interest.getInterest() + amount;
	}
}
