package com.example.geektrust_problems;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.example.model.Loan;

public class LoanTest {
	
	@Test
	public void shouldReturnCorrectBalanceForSingleLoan() throws Exception {

		Loan loan = new Loan("IDIDI Dale 10000 5 4");


		assertTrue(loan.getBankName().equals("IDIDI"));
		assertTrue(loan.getBorrowerName().equals("Dale"));
		assertTrue(loan.getPrincipal().equals("10000"));
		assertTrue(loan.getNoOfYears().equals("5"));
		assertTrue(loan.getRateOfInterest().equals("4"));
	}

}
