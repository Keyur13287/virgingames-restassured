package com.virgingames.demo.steps;

import com.virgingames.demo.gamesinfo.StudentSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {
    static ValidatableResponse response;
    @Steps
    StudentSteps steps;

    @When("User sends a GET request to jackpots endpoint")
    public void userSendsAGETRequestToJackpotsEndpoint() {
        response= steps.getThecurrencyData();
    }

    @Then("User must get back a valid status code {int}")
    public void userMustGetBackAValidStatusCode(int statusCode) {
        response.statusCode(statusCode);

    }

    @Then("User must get back a valid status code {int} as per{string}")
    public void userMustGetBackAValidStatusCodeAsPer(int statusCode, String currency) {


        HashMap<String,Object> currencyList = steps.getThecurrencyMultipleData(currency);
        Assert.assertThat(currencyList, hasValue(currency));
    }


}
