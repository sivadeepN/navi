package com.example.geektrust_problems;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.model.Interest;

public class InterestTest {

	@Test
	public void shouldCreateCorrectInterest() throws Exception {

		Interest interest = new Interest(5, 5, 10000);

		assertTrue(interest.getRate() == 5);
		assertTrue(interest.getNoOfYears() == 5);
		assertTrue(interest.getPrincipleAmount() == 10000);

	}

	@Test
	public void shpuldReturnInterest() throws Exception {

		Interest interest = new Interest(5, 5, 10000);

		assertTrue(interest.getInterest() == 2500);

	}

}
