package Dmitriy.Daniel.pages;

import Dmitriy.Daniel.models.CRM.CreateCaseForm.DataCase;

import io.restassured.http.ContentType;

import static Dmitriy.Daniel.Specification.requestCrmApi;
import static Dmitriy.Daniel.Specification.requestSpec;
import static io.restassured.RestAssured.given;

public class CreateCaseApiPage {
    private String caseGid;
    DataCase dataCase = new DataCase();

    public void createCaseSuccessesApi(){

        caseGid = given()
                .spec(requestCrmApi)
                .contentType(ContentType.JSON)
                .body(dataCase)
                .when()
                .post("/v2/cases/create")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()

                .extract().path("data.case_gid");
    }
}
