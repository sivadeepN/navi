package com.example.loan_operation;

import java.util.ArrayList;
import java.util.List;

import com.example.constants.IConstants;
import com.example.exceptions.InvalidInputException;
import com.example.model.Balance;
import com.example.model.Loan;
import com.example.model.Payment;
import com.example.model_interfaces.IBalance;
import com.example.model_interfaces.ILoan;
import com.example.model_interfaces.IPayment;

public class LoanOperation implements IConstants{

	private List<ILoan> loans;
	private List<IPayment> payments;
	private List<IBalance> balances;
	private List<String> output;

	public LoanOperation() {
		loans = new ArrayList<>();
		this.payments = new ArrayList<>();
		balances = new ArrayList<>();
		this.output = new ArrayList<>();
		
		
	}
	
	 public void performOperation(String input) throws Exception
     {
         switch (input.split(" ")[0])
         {
             case LOAN:
                 PerformLoanOperation(input);
                 break;
             case PAYMENT:
                 PerformPaymentOperation(input);
                 break;
             case BALANCE:
                 PerformBalanceOperation(input);
                 break;
             default:
                 throw new Exception("Invalid line supplied in file");
         }
     }
	 
	 
	 //division of responsibilities
	 private void PerformLoanOperation(String input) throws InvalidInputException
     {
         ILoan loan = new Loan(input.substring(LOAN.length() + 1));
         loans.add(loan);
     }

     private void PerformPaymentOperation(String input) throws InvalidInputException
     {
         IPayment payment = new Payment(input.substring(PAYMENT.length() + 1));
         payments.add(payment);
         
     }

     private void PerformBalanceOperation(String input) throws Exception
     {
         IBalance balance = new Balance(input.substring(BALANCE.length() + 1));
         String balanceWithRemainingInstallments = balance.getBalanceWithRemainingInstallments(loans, payments);
         balances.add(balance);
         output.add(balanceWithRemainingInstallments);
         System.out.println(balanceWithRemainingInstallments);
     }
     
 	public List<String> getOutput() {
		return output;
	}
}
