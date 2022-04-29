package com.example.model;

import com.example.constants.IConstants;
import com.example.exceptions.InvalidInputException;
import com.example.model_interfaces.ILoan;
import com.example.validators.InputValidator;

public class Loan implements ILoan, IConstants {

	private String bankName;
	private String borrowerName;
	private String principal;
	private String noOfYears;
	private String rateOfInterest;

	public Loan(String input) throws InvalidInputException {
		InputValidator.validateInput(input, LOAN);
		String variables[] = input.split(" ");
		this.bankName = variables[0];
		this.borrowerName = variables[1];
		this.principal = variables[2];
		this.noOfYears = variables[3];
		this.rateOfInterest = variables[4];
	}

	public String getBankName() {
		return bankName;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public String getPrincipal() {
		return principal;
	}

	public String getNoOfYears() {
		return noOfYears;
	}

	public String getRateOfInterest() {
		return rateOfInterest;
	}

}
