package com.sophos.www.userinterfaces;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.metro.pe")
public class MetroPeHomePage extends PageObject {

	public static final Target CLOSE_NOTIFICATION = Target.the("Cerrar Notificacion").located(By.id("onesignal-popover-cancel-button"));
	public static final Target FIELD_SEARCH = Target.the("Buscar Producto").located(By.id("search-autocomplete-input"));
	public static final Target CLOSE_X = Target.the("Cerrar Modal").located(By.className("btn-close-popup"));
	
}
