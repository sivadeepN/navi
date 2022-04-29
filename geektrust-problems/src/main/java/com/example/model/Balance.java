package com.example.model;

import java.util.List;

import com.example.calculators.BalanceCaluculaterUtil;
import com.example.constants.IConstants;
import com.example.exceptions.InvalidInputException;
import com.example.model_interfaces.IBalance;
import com.example.model_interfaces.IEMI;
import com.example.model_interfaces.ILoan;
import com.example.model_interfaces.IPayment;
import com.example.validators.InputValidator;

public class Balance implements IBalance, IConstants {

	private String bankName;
	private String borrowerName;
	private int emiNo;

	public Balance(String input) throws InvalidInputException {
		InputValidator.validateInput(input, BALANCE);
		String variables[] = input.split(" ");
		this.bankName = variables[0];
		this.borrowerName = variables[1];
		this.emiNo = Integer.parseInt(variables[2]);
	}

	public String getBankName() {
		return bankName;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public int getEmiNo() {
		return emiNo;
	}

	public String getBalanceWithRemainingInstallments(List<ILoan> loans, List<IPayment> payments) throws Exception {
		Loan loan = BalanceCaluculaterUtil.loanOnBorrowerName(loans, getBorrowerName());
		IEMI emi = new EMI(Integer.parseInt(loan.getPrincipal()), Integer.parseInt(loan.getRateOfInterest()),
				Integer.parseInt(loan.getNoOfYears()));
		int monthlyEmiInstallment = emi.getEmi();
		int lumpsumAmountPaid = BalanceCaluculaterUtil.lumpsumAmountPaidBeforeEmi(payments, this.emiNo,
				this.getBorrowerName(), this.getBankName());
		int calculatedBalance = BalanceCaluculaterUtil.getBalance(monthlyEmiInstallment, lumpsumAmountPaid, this.emiNo);
		int totalAmountToPay = emi.getAmount();
		int totalBalance = calculatedBalance > totalAmountToPay ? totalAmountToPay : calculatedBalance;
		int remainingInstallments = BalanceCaluculaterUtil.getRemainingInstallments(loan, monthlyEmiInstallment,
				lumpsumAmountPaid, this.emiNo);

		if (remainingInstallments * monthlyEmiInstallment + totalBalance < totalAmountToPay) {
			remainingInstallments++;
		}

		return this.bankName + " " + this.borrowerName + " " + totalBalance + " " + remainingInstallments;
	}

}
