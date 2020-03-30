package com.sophos.www.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features= "src/test/resources/com/sophos/www/features/MetroShopping.feature",
        glue="com.sophos.www.stepdefinitions",
        snippets= SnippetType.CAMELCASE)

public class ShoppingCart {

}
