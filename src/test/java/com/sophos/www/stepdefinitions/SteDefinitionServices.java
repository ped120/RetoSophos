package com.sophos.www.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import com.sophos.www.models.Services;
import com.sophos.www.tasks.ConsumeService;
import static org.hamcrest.Matchers.hasItems;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class SteDefinitionServices {
	
	/**
	 * Este método se encarga de realizar el llamado a la Api
	 */

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Pedro").whoCan(CallAnApi.at(Services.URL_BASE));
    }
	
	@Given("^Pedro realiza el llamado a la api$")
	public void pedroRealizaElLlamadoALaApi() {
	}

	
	/**
	 * Este método realiza la petición GET
	 */
	@When("^realiza la peticion request$")
	public void realizaLaPeticionRequest() {
		theActorInTheSpotlight().attemptsTo(
				ConsumeService.poidComplement(Services.POID)
				);
	}
	
	
	/**
	 * Este método se encarga de validar la respuesta del servicio contenga los parametro name y surname
	 * @param name parametro que contiene el valor del nombre que se quiere validar
	 * @param surname parametro que contiene el valor del apellido que se quiere validar
	 */
	@Then("^Obtiene la respuesta con el nombre (.*) y apellido (.*)$")
	public void obtieneLaRespuestaConElNombreJuliusYApellidoO_Keefe(String name, String surname ) {
		  theActorInTheSpotlight().should(seeThatResponse(
  				"Conexion correcta",response  -> response.statusCode(200)
  					.body("result.first_name", hasItems(name))
  					.body("result.last_name", hasItems(surname))
  				)
  				);
	}
	
}
