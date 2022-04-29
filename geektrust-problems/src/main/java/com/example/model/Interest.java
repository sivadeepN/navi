package com.example.model;

import com.example.model_interfaces.IInterest;

public class Interest implements IInterest {

	private int rate;
	private int noOfYears;
	private int principleAmount;

	public Interest(int rate, int noOfYears, int principleAmount) {
		this.rate = rate;
		this.noOfYears = noOfYears;
		this.principleAmount = principleAmount;
	}

	public int getRate() {
		return rate;
	}

	public int getNoOfYears() {
		return noOfYears;
	}

	public int getPrincipleAmount() {
		return principleAmount;
	}
	
	public int getInterest()
    {
        return  (int)Math.ceil((double) (((rate * principleAmount) / 100 ) * noOfYears));
    }

}
