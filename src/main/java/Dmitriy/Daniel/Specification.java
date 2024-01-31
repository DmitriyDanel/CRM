package Dmitriy.Daniel;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static Dmitriy.Daniel.constants.CrmConstants.*;
import static io.restassured.RestAssured.with;

public class Specification {
    public static RequestSpecification requestCrmApi = with()
            .auth().preemptive().basic(CRM_API_USER_STAGE, CRM_API_PASS_STAGE)
            .baseUri(CRM_API_URL_STAGE)
//            .basePath("/v2")
            .log().all();

    public static RequestSpecification requestCrmStage = with()
            .auth().oauth2("1bab42fad165f12c69d6786c27abf087")
            .baseUri(CRM_URL_STAGE)
            .basePath("/api/v1")
            .log().all();
//            .contentType(ContentType.JSON);
    public static ResponseSpecification requestSpec = new ResponseSpecBuilder()
            .build();


}
