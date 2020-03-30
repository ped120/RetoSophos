package com.sophos.www.questions;

import com.sophos.www.userinterfaces.ProductSearchResult;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheNameProduct implements Question<String>{
	
	 public static String NameProductCompare = "PlayStation 4 Hits Bundle FIFA 20: Champions Edition";

	@Override
	public String answeredBy(Actor actor) {
		return ProductSearchResult.NAME_PRODUCT.resolveFor(actor).getText();
	}
	
	public static Question<String> value() { return new TheNameProduct(); }

}
