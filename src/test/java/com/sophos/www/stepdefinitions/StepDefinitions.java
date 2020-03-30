package com.sophos.www.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import com.sophos.www.models.ProductToBuy;
import com.sophos.www.questions.TheNameProduct;
import com.sophos.www.tasks.SearchProduct;
import com.sophos.www.userinterfaces.MetroPeHomePage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinitions {

	private MetroPeHomePage metroPeHomePage;

	@Before
	public void prepareStage() {
		OnStage.setTheStage(new OnlineCast());
	}

	/**
	 * Se enecarga de abrir abrir el navegador y asignarle el nombre al actor
	 * @param name nombre que se le asigna al actor
	 */
	@Given("(.*) ingresa a la pagina de metro")
	public void pedroIngresaALaPaginaDeMetro(String name) {
		theActorCalled(name).wasAbleTo(Open.browserOn(metroPeHomePage));
	}

	@When("Selecciona un (.*) para agregar al carro de compras")
	public void seleccionaUnProductoParaAgregarAlCarroDeCompras(String producto) {
		ProductToBuy.setGetProductBuy(producto);
		theActorInTheSpotlight().attemptsTo(SearchProduct.Product(ProductToBuy.getGetProductBuy()));
	}
	
	
	/**
	 * Este método realiza la función de verificar el nombre del producto que fue agregado al carrito
	 */
	@Then("El producto es agregado satisfactoriamente al carro de compras")
	public void elProductoEsAgregadoSatisfactoriamenteAlCarroDeCompras() {
		theActorInTheSpotlight().should(seeThat("Nombre del producto", TheNameProduct.value(), equalTo(TheNameProduct.NameProductCompare)));
	}
}