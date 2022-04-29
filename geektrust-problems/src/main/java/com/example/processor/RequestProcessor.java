package com.example.processor;

import com.example.loan_operation.LoanOperation;

public class RequestProcessor implements AbstractProcessor {

	// making this class singleton to restrict to same instacne
	private static LoanOperation loanOperation;

	@Override
	public void execute(String input) throws Exception {
		LoanOperation loanOperation = getLoanOperations();
		loanOperation.performOperation(input);

	}

	public LoanOperation getLoanOperations() {
		if (loanOperation == null)
			loanOperation = new LoanOperation();

		return loanOperation;
	}
	
}
