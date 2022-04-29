package com.example.geektrust_problems;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.calculators.BalanceCaluculaterUtil;
import com.example.model.Loan;
import com.example.model.Payment;
import com.example.model_interfaces.IPayment;

public class CalculatorUtilTest {

	@Test
	public void shouldCalculateCorrectBalanceWithEMIandLumpsome() throws Exception {
		int balance = BalanceCaluculaterUtil.getBalance(1000, 500, 5);

		assertTrue(balance == 5500);
	}

	@Test
	public void shouldgetRemainingInstallments() throws Exception {

		Loan loan = new Loan("IDIDI Dale 10000 5 4");
		int installmentsleft = BalanceCaluculaterUtil.getRemainingInstallments(loan, 1000, 500, 5);

		assertTrue(installmentsleft == 54);
	}

	@Test
	public void shouldgetumpsomeAmountBeforeEmi() throws Exception {
		List<IPayment> payments = new ArrayList<IPayment>();
		Payment payment1 = new Payment("IDIDI Dale 1000 5");
		Payment payment2 = new Payment("IDIDI Dale 1000 6");

		int lumpsum = BalanceCaluculaterUtil.lumpsumAmountPaidBeforeEmi(payments, 5, "DALE", "IDIDI");

		assertTrue(lumpsum == 0);
	}

	@Test
	public void hasBorrowerPaidLumpsumAmount() throws Exception {
		List<IPayment> payments = new ArrayList<IPayment>();
		Payment payment1 = new Payment("IDIDI Dale 1000 5");
		Payment payment2 = new Payment("IDIDI Dale 1000 6");

		boolean paidLumpsum = BalanceCaluculaterUtil.hasBorrowerPaidLumpsumAmount(payment1, "DALE", "IDIDI");
		assertTrue(!paidLumpsum);
	}

}
