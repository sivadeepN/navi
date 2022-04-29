package com.example.geektrust_problems;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.loan_operation.LoanOperation;
import com.example.processor.RequestProcessor;

public class RequestProcessorTest {
	@Test
	public void processorShouldBeSingleTon() {

		RequestProcessor processor = new RequestProcessor();
		LoanOperation loanOperations = processor.getLoanOperations();
		LoanOperation newLoanOperations = processor.getLoanOperations();
		assertTrue(loanOperations.equals(newLoanOperations));
	}
}
