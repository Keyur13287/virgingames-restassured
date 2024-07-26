package com.virgingames.demo.gamesinfo;


import com.virgingames.demo.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;

/**
 * Created by keyur
 */
public class StudentSteps {


    @Step ("Getting the currency of GBP")
    public  ValidatableResponse getThecurrencyData(){
        return SerenityRest.given().log().all()
                .queryParam("currency", "GBP")
                .when()
                .get(EndPoints.GET_ALL_BINGO)
                .then();
    }

    @Step ("Getting the currency of ")
    public HashMap<String,Object> getThecurrencyMultipleData(String currency){
        String s1 = "data.pots.findAll{it.currency == '";
        String s2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .queryParam("currency", currency)
                .when()
                .get(EndPoints.GET_ALL_BINGO)
                .then().statusCode(200)
                .extract()
                .path(s1 + currency + s2);
    }

}
