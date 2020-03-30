package com.sophos.www.exceptions;

import org.openqa.selenium.NoSuchElementException;

public class MetroShoppingException extends NoSuchElementException{
	
	public static final String ELEMENT_NOT_FOUND = "El elemento no fue localizado";

	public MetroShoppingException(String reason, Throwable cause) {
		super(reason, cause);
	}
	
	

}
