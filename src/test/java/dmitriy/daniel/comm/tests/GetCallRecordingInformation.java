package dmitriy.daniel.comm.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static Dmitriy.Daniel.constants.CommConstants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetCallRecordingInformation {

    @Test
    void getRecordingInfo() {

        RestAssured.baseURI = COMM_API_URL_DEV_V1 + "/voip-recordings-info";

        given()
                .log().all()
                .auth().preemptive().basic(COMM_API_USER_DEV, COMM_API_PASSWORD_DEV)
                .param("recordingSid", "RE82b6f795d1c973a0fdf2c64528fbebdf")
                .when()
                    .get("/get-recording-info")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("recordingSid", equalTo("RE82b6f795d1c973a0fdf2c64528fbebdf"),
                        "isTwilio", equalTo(true),
                        "path", equalTo("/2010-04-01/Accounts/ACccea09933eaeec9b38659fc9d75a2a0b/Recordings/RE82b6f795d1c973a0fdf2c64528fbebdf"),
                        "status", equalTo(200),
                        "message", equalTo("OK"),
                        "isSuccess", equalTo(true));
    }
    @Test
    void getRecordingInfoWithInvalidRecordingSid() {

        RestAssured.baseURI = COMM_API_URL_DEV_V1 + "/voip-recordings-info";

        given()
                .auth().preemptive().basic(COMM_API_USER_DEV, COMM_API_PASSWORD_DEV)
                .param("recordingSid", "RE82b6f795d1c973a0fdf2c64528fbebdf1")
                .when()
                .get("/get-recording-info")
                .then()
                .assertThat()
                .statusCode(400)
                .body("recordingSid", equalTo("RE82b6f795d1c973a0fdf2c64528fbebdf1"),
                        "status", equalTo(400),
                        "message", equalTo("Recording sid is invalid. Error: the input value should contain 34 characters."),
                        "isSuccess", equalTo(false));
    }
}
