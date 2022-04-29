package com.example.geektrust_problems;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.constants.IConstants;
import com.example.exceptions.InvalidInputException;
import com.example.model.Balance;
import com.example.model.Loan;
import com.example.model.Payment;
import com.example.model_interfaces.ILoan;
import com.example.model_interfaces.IPayment;

public class BalanceTest implements IConstants {

	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldReturnCorrectBalanceForSingleLoan() throws Exception {

		Loan loan = new Loan("IDIDI Dale 10000 5 4");
		List<ILoan> loans = new ArrayList<ILoan>();
		List<IPayment> payments = new ArrayList<IPayment>();
		loans.add(loan);
		Balance bal = new Balance("IDIDI Dale 5");

		assertTrue(bal.getBalanceWithRemainingInstallments(loans, payments).equals("IDIDI Dale 1000 55"));
	}

	@Test
	public void shouldReturnCorrectBalanceForSingleLoanAndPayment() throws Exception {

		Loan loan = new Loan("IDIDI Dale 10000 5 4");
		Payment payment = new Payment("IDIDI Dale 1000 5");
		List<ILoan> loans = new ArrayList<ILoan>();
		List<IPayment> payments = new ArrayList<IPayment>();
		loans.add(loan);
		payments.add(payment);
		Balance bal = new Balance("IDIDI Dale 5");

		assertTrue(bal.getBalanceWithRemainingInstallments(loans, payments).equals("IDIDI Dale 2000 50"));
	}

	@Test
	public void shouldReturnCorrectBalanceForSingleLoanAndMultiplePayment() throws Exception {

		Loan loan = new Loan("IDIDI Dale 10000 5 4");
		Payment payment = new Payment("IDIDI Dale 1000 5");
		Payment payment2 = new Payment("IDIDI Dale 2000 6");
		List<ILoan> loans = new ArrayList<ILoan>();
		List<IPayment> payments = new ArrayList<IPayment>();
		loans.add(loan);
		payments.add(payment);
		payments.add(payment2);
		Balance bal = new Balance("IDIDI Dale 5");

		assertTrue(bal.getBalanceWithRemainingInstallments(loans, payments).equals("IDIDI Dale 2000 50"));
	}
}
