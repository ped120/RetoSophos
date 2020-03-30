package com.sophos.www.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;

import org.openqa.selenium.Keys;

import com.sophos.www.exceptions.MetroShoppingException;
import com.sophos.www.userinterfaces.MetroPeHomePage;
import com.sophos.www.userinterfaces.ProductSearchResult;

public class SearchProduct implements Task{
	
	private String product;
	
	public SearchProduct(String product) {
		this.product = product;
	}
	
	
	/** 
	 * El actor cierra la notifiación - cierra el modal - busca el producto Play 4 y da enter
	 * Realiza un scroll agrega el play 4 al carrito y presiona clic en ver carrito
	 */
	@Override
	public <T extends Actor> void performAs (T actor) {
		
		try {
			actor.attemptsTo(
					Click.on(MetroPeHomePage.CLOSE_NOTIFICATION),
					Click.on(MetroPeHomePage.CLOSE_X),
					Enter.theValue(product).into(MetroPeHomePage.FIELD_SEARCH),
					Hit.the(Keys.ENTER).into(MetroPeHomePage.FIELD_SEARCH),
					Scroll.to(ProductSearchResult.SELECT_PRODUCT_SCROLL),
					Click.on(ProductSearchResult.SELECT_PRODUCT),
					Click.on(ProductSearchResult.ADD_PRODUCT_TO_CAR)
			);
			
		} catch (Exception e) {
			throw new MetroShoppingException(MetroShoppingException.ELEMENT_NOT_FOUND,e);
		}
		 
	}
	
	/**
	 * Este método se encarga inicializar la clase y recibir el paramtero product
	 * @param product Contiene el valor del producto que se va a buscar 
	 * @return
	 */
	public static SearchProduct Product (String product) {
		return instrumented(SearchProduct.class, product);
	}

}
