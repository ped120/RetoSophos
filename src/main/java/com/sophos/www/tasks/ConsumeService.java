package com.sophos.www.tasks;

import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsumeService implements Task {

	private String poid = "";

	public ConsumeService(String poid) {
		this.poid = poid;
	}

	/**
	 * Realiza la petición Get
	 */
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
		Get.resource(poid)
		);
	}


	public static ConsumeService poidComplement(String poid) {
		return instrumented(ConsumeService.class, poid);
	}

}
