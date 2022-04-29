package com.example.calculators;

import java.util.List;

import com.example.model.Loan;
import com.example.model_interfaces.ILoan;
import com.example.model_interfaces.IPayment;

public class BalanceCaluculaterUtil {

	public static int lumpsumAmountPaidBeforeEmi(List<IPayment> payments, int emiNo, String borrowerName,
			String bankName) {
		return (int) payments.stream()
				.filter(p -> hasBorrowerPaidLumpsumAmount(p, borrowerName, bankName) && p.getEmiNo() <= emiNo)
				.mapToInt(p -> p.getLumpsumAmount()).sum();
	}

	public static boolean hasBorrowerPaidLumpsumAmount(IPayment payment, String borrowerName, String bankName) {
		return payment.getBorrowerName().equals(borrowerName) && payment.getBankName().equals(bankName);
	}

	public static int getRemainingInstallments(Loan loan, int monthlyEmiInstallment, int lumpsumAmountPaid, int emiNo) {
		float montlyInstallMent = monthlyEmiInstallment;
		int lumpsumPaidForMonths = (int) Math.round(lumpsumAmountPaid / montlyInstallMent);
		return (Integer.parseInt(loan.getNoOfYears()) * 12 - emiNo) - lumpsumPaidForMonths;
	}

	public static int getBalance(int monthlyEmiInstallment, int lumpsumAmountPaid, int emiNo) {
		return (monthlyEmiInstallment * emiNo) + lumpsumAmountPaid;
	}

	public static Loan loanOnBorrowerName(List<ILoan> loans, String borrowerName) throws Exception {
		Loan loanOnBorrowerName = null;
		try {
			for (ILoan loan : loans) {
				if (borrowerName.equals(loan.getBorrowerName())) {
					loanOnBorrowerName = (Loan) loan;
					break;
				}
			}

		} catch (Exception e) {
			throw new Exception("No Loan on borrrower");
		}

		return loanOnBorrowerName;
	}
}
