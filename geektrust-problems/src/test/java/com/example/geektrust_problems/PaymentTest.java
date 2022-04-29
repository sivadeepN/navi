package com.example.geektrust_problems;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.model.Payment;

public class PaymentTest {

	@Test
	public void shouldCreateCorrectPayment() throws Exception {

		Payment payment = new Payment("IDIDI Dale 5000 5");

		assertTrue(payment.getBankName().equals("IDIDI"));
		assertTrue(payment.getBorrowerName().equals("Dale"));
		assertTrue(payment.getEmiNo() == 5);
		assertTrue(payment.getLumpsumAmount() == 5000);
	}

}
