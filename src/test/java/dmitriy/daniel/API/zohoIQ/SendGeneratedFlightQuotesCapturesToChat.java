//package dmitriy.daniel.API.zohoIQ;
//
//import Dmitriy.Daniel.models.zoho.GenerateQuote;
//import io.qameta.allure.Story;
//import io.restassured.http.ContentType;
//import org.apache.http.HttpStatus;
//import org.testng.annotations.Test;
//
//import java.util.Arrays;
//
//import static Dmitriy.Daniel.Specification.requestCrmStage;
//import static Dmitriy.Daniel.Specification.requestSpec;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.startsWith;
//import static org.junit.internal.matchers.StringContains.containsString;
//import static org.junit.matchers.JUnitMatchers.everyItem;
//
//public class SendGeneratedFlightQuotesCapturesToChat {
//    // "This API endpoint facilitates the dissemination of generated flight quotes directly to a specified chat."
//    @Test
//    @Story("Send generated flight quotes captures to chat")
//    public void successes() {
//        // Створення екземпляра класу GenerateQuote
//        GenerateQuote generateQuote = new GenerateQuote();
//        generateQuote.setChatId(3820);
//        generateQuote.setQuotesIds(Arrays.asList(quotesIds));
//
//        given()
//                .spec(requestCrmStage)
//                .contentType(ContentType.JSON)
//                .body(generateQuote)
//                .when()
//                .post("leads/" + gid + "/flight-quotes/send-to-chat")
//                .then()
//                .spec(requestSpec)
//                .assertThat()
//                .log().body()
//                .statusCode(HttpStatus.SC_OK)
//
//                .body("status", equalTo(200),
//                        "success", equalTo(true),
//                        "message", equalTo("Quotes send successfully"),
//                        "warning", equalTo(""));
//    }
//
//    @Test
//    @Story("403 Result when lead with received gid is not available for user")
//    public void leadWithReceivedGidIsNotAvailableForUser() {
//        given()
//                .spec(requestCrmStage)
//                .contentType(ContentType.JSON)
//                .param("chatId", "17454")
//                .when()
//                .post("/leads/" + "bce2376453d3452ba827939f829a5e0c" + "/flight-quotes/send-to-chat")
//                .then()
//                .spec(requestSpec)
//                .assertThat()
//                .log().body()
//                .statusCode(HttpStatus.SC_FORBIDDEN)
//
//                .body("status", equalTo(403),
//                        "type", equalTo("about:blank"),
//                        "title", equalTo("Unprocessable entity"),
//                        "details", equalTo("Not found saved quote captures. Generate captures before call this action."));
//    }
//
//
//    @Test
//    @Story("422 Not found saved quote captures.")
//    public void notFoundSavedQuoteCaptures() {
//        given()
//                .spec(requestCrmStage)
//                .contentType(ContentType.JSON)
//                .param("chatId", "17454")
//                .when()
//                .post("/leads/" + "bce2376453d3452ba827939f829a5e0c" + "/flight-quotes/send-to-chat")
//                .then()
//                .spec(requestSpec)
//                .assertThat()
//                .log().body()
//                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)
//
//                .body("status", equalTo(422),
//                        "type", equalTo("about:blank"),
//                        "title", equalTo("Unprocessable entity"),
//                        "details", equalTo("Not found saved quote captures. Generate captures before call this action."));
//    }
//}
