package com.example.model;

import com.example.constants.IConstants;
import com.example.exceptions.InvalidInputException;
import com.example.model_interfaces.IPayment;
import com.example.validators.InputValidator;

public class Payment implements IPayment, IConstants {
	private String bankName;
	private String borrowerName;
	private int lumpsumAmount;
	private int emiNo;

	public Payment(String input) throws InvalidInputException {
		InputValidator.validateInput(input, PAYMENT);
		String variables[] = input.split(" ");
		this.bankName = variables[0];
		this.borrowerName = variables[1];
		this.lumpsumAmount = Integer.parseInt(variables[2]);
		this.emiNo = Integer.parseInt(variables[3]);
	}
	
	public String getBankName() {
		return bankName;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public int getLumpsumAmount() {
		return lumpsumAmount;
	}

	public int getEmiNo() {
		return emiNo;
	}
	
}
