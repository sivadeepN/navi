package com.example.model_interfaces;

import java.util.List;

public interface IBalance {

	public String getBankName();

	public String getBorrowerName();

	public int getEmiNo();

	public String getBalanceWithRemainingInstallments(List<ILoan> loans, List<IPayment> payments) throws Exception;

}
