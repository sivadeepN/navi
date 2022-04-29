package com.example.validators;

import com.example.constants.IConstants;
import com.example.exceptions.InvalidInputException;

public class InputValidator implements IConstants {

	public static void validateInput(String input, String type) throws InvalidInputException {

		switch (type) {
		case LOAN:
			if (input.split(" ").length != 5)
				throw new InvalidInputException(INVALID_INPUT);
			break;
		case PAYMENT:
			if (input.split(" ").length != 4)
				throw new InvalidInputException(INVALID_INPUT);
			break;
		case BALANCE:
			if (input.split(" ").length != 3)
				throw new InvalidInputException(INVALID_INPUT);
			break;

		default:
			break;
		}

	}

}
