// Запрацює після деплоя змін на Stage

package dmitriy.daniel.API.zohoIQ;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Dmitriy.Daniel.Specification.requestCrmApi;
import static Dmitriy.Daniel.Specification.requestSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LeadList {
    String projectKey = "ovago";
    String chatVisitorId = "00ea809c-319f-47d6-bc02";

    @Test
    public void seccuss() {
        given()
                .spec(requestCrmApi)
                .param("projectKey", projectKey)
                .param("chatVisitorId", chatVisitorId)
                .when()
                .log().body()
                .get("/v1/client-chat/lead-list")

                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(200),
                        "message", equalTo("OK"),
                        "data.leadGid",not(empty()),
                        "data.leadStatusName",not(empty()));
    }
    @Test
    public void validateFailed() {
        given()
                .spec(requestCrmApi)
                .param("projectKey", projectKey)
                .param("chatVisitorId", "00ea809c-319f-47d6-bc0")
                .when()
                .log().body()
                .get("/v1/client-chat/lead-list")

                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(422),
                        "message", equalTo("Validate failed"),
                        "errors.chatVisitorId", equalTo("Chat with specified project and visitor id does not exists"));

    }
    @Test
    public void ChatVisitorIdCannotBeBlank() {
        given()
                .spec(requestCrmApi)
                .param("projectKey", projectKey)
                .param("chatVisitorId", "")
                .when()
                .log().body()
                .get("/v1/client-chat/lead-list")

                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(422),
                        "message", equalTo("Validate failed"),
                        "errors.chatVisitorId", equalTo("Chat Visitor Id cannot be blank."));
    }
    @Test
    public void ProjectNotFound() {
        given()
                .spec(requestCrmApi)
                .param("projectKey", "ovago1")
                .param("chatVisitorId", "00ea809c-319f-47d6-bc02")
                .when()
                .log().body()
                .get("/v1/client-chat/lead-list")

                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(422),
                        "message", equalTo("Validate failed"),
                        "errors.projectKey", equalTo("Project not found"));
    }
    @Test
    public void ProjectKeyCannotBeBlank() {
        given()
                .spec(requestCrmApi)
                .param("projectKey", "")
                .param("chatVisitorId", "00ea809c-319f-47d6-bc02")
                .when()
                .log().body()
                .get("/v1/client-chat/lead-list")

                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(422),
                        "message", equalTo("Validate failed"),
                        "errors.projectKey", equalTo("Project Key cannot be blank."));
    }
}


