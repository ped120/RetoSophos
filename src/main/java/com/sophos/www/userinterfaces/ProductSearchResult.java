package com.sophos.www.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class ProductSearchResult {
	
	public static final Target SELECT_PRODUCT_SCROLL = Target.the("Realizo Scroll").located(By.className("product-item__actions"));
	public static final Target SELECT_PRODUCT = Target.the("Selecciono el producto").located(By.className("add-to-cart"));
	public static final Target ADD_PRODUCT_TO_CAR = Target.the("Verifico seleccion del producto").located(By.xpath("//*[@id=\"search-results-page\"]/div[24]/div/div[2]/div[4]/div[5]/div[1]/div[2]/a"));
	public static final Target NAME_PRODUCT = Target.the("Obtengo el nombre del producto").located(By.xpath("//*[@id=\"cart-page\"]/div[8]/div/div[3]/div[1]/div[4]/div[2]/div/div[3]/a"));

}
