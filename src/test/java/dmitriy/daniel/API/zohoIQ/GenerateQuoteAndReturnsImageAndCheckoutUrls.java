package dmitriy.daniel.API.zohoIQ;

import Dmitriy.Daniel.models.zoho.GenerateQuote;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.Arrays;

import static Dmitriy.Daniel.Specification.requestCrmStage;
import static Dmitriy.Daniel.Specification.requestSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.internal.matchers.StringContains.containsString;
import static org.junit.matchers.JUnitMatchers.everyItem;

public class GenerateQuoteAndReturnsImageAndCheckoutUrls {

    String gid = "0738bdc851c4a77d9b4554c2fc3f4acd";
    int quotesIds = 322465;

        @Test
    public void successes() {
        GenerateQuote generateQuote = new GenerateQuote();
        generateQuote.setQuotesIds(Arrays.asList(quotesIds));

        given()
                .spec(requestCrmStage)
                .contentType(ContentType.JSON)
                .body(generateQuote)
                .when()
                .post("leads/" + gid + "/flight-quotes/generate-capture")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("data", notNullValue(),
                        "data.captures.img", everyItem(notNullValue()), // Проверка, что у каждого объекта в массиве captures есть img
                        "data.captures.img", everyItem(startsWith("https://comms.stage.travel-dev.com/imgs/tplc/")),
                        "data.captures.checkoutUrl", everyItem(startsWith
                                ("https://ovago-hybrid-stage.travel-dev.com/checkout/quote/")));
    }

    @Test
    public void QuotesCannotBeBlank() {

        GenerateQuote generateQuote = new GenerateQuote();
        generateQuote.setQuotesIds(Arrays.asList());

        given()
                .spec(requestCrmStage)
                .contentType(ContentType.JSON)
                .body(generateQuote)
                .when()
                .post("leads/" + gid + "/flight-quotes/generate-capture")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)

                .body("violations[0].field", equalTo("quotesIds"),
                        "violations[0].message", equalTo("Quotes cannot be blank."),
                        "type", equalTo("about:blank"),
                        "title", equalTo("Validation error"),
                        "status", equalTo(422));
    }
    @Test
    public void theNumberOfQuotesIdsShouldNotBeMoreThanFive() {

        GenerateQuote generateQuote = new GenerateQuote();
        generateQuote.setQuotesIds(Arrays.asList(quotesIds,quotesIds,quotesIds,quotesIds,quotesIds,quotesIds));

        given()
                .spec(requestCrmStage)
                .contentType(ContentType.JSON)
                .body(generateQuote)
                .when()
                .post("leads/" + gid + "/flight-quotes/generate-capture")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)

                .body("violations[0].field", equalTo("quotesIds"),
                        "violations[0].message", equalTo("The number of quotesIds should not be more than 5"),
                        "type", equalTo("about:blank"),
                        "title", equalTo("Validation error"),
                        "status", equalTo(422));
    }
}
