package dmitriy.daniel.API.CRM;

import Dmitriy.Daniel.models.CRM.CreateCaseForm.DataCase;
import Dmitriy.Daniel.models.CRM.GetCasesByEmail.CasesByEmailParams;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Dmitriy.Daniel.Specification.requestCrmApi;
import static Dmitriy.Daniel.Specification.requestSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class CreateCaseAPI {
    private String caseGid;
    DataCase dataCase = new DataCase();


    @Test

    public void createCaseSuccesses() {

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
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(200),
                        "message", equalTo("OK"),
                        "request.contact_email", equalTo(dataCase.contact_email),
                        "request.contact_phone", equalTo(dataCase.contact_phone),
                        "request.category_key", equalTo(dataCase.category_key),
                        "request.project_key", equalTo(dataCase.project_key),
                        "request.order_uid", equalTo(dataCase.order_uid),
                        "request.subject", equalTo(dataCase.subject),
                        "request.description", equalTo(dataCase.description))

                .extract().path("data.case_gid");
        System.out.println(caseGid);
    }
    @Test
    public void createCasesValidationError() {

        dataCase.setContact_phone("+38098342927"); // "The format of Contact Phone is invalid."
        given()
                .spec(requestCrmApi)
                .contentType(ContentType.JSON)
                .body(dataCase)
                .when()
                .post("/v2/cases/create")

                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)

                .body("status", equalTo(422),
                        "message", equalTo("Validation error"),
                        "errors.contact_phone[0" +
                                "]", equalTo("The format of Contact Phone is invalid."));

    }


    @Test(dependsOnMethods = {"createCaseSuccesses"})
    public void getCaseSuccess() {
        given()
                .spec(requestCrmApi)
                .param("gid", caseGid)

                .when()
                .get("/v2/case/get")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(200),
                        "message", equalTo("OK"),
                        "data.gid", equalTo(caseGid));
    }

    @Test
    @Story("Case with this gid not found.")
    public void caseWithThisGIDnotFound() {

        given()
                .spec(requestCrmApi)
                .param("gid", "ffa95a370fbf3216936e33398d4a70f5")
                .when()
                .get("/v2/case/get")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)

                .body("status", equalTo(422),
                "message", equalTo("Validation error"),
                "errors[0]", equalTo("Case with this gid not found."));

    }

    @Test(dependsOnMethods = {"createCaseSuccesses"}
    )
    public void getCasesByEmail() {
        given()
                .spec(requestCrmApi)
                .param("contact_email", dataCase.contact_email)
                .param("active_only", 1)
                .param("department_key", dataCase.category_key)
                .param("project_key", dataCase.project_key)
                .param("oresults_limit", 10)

                .when()
                .get("/v2/case/get-list-by-email")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(200),
                        "message", equalTo("OK"),
                        "data[0].order_uid", not(empty()));
    }

    @Test
    public void getCasesByEmailValidationError() {
        given()
                .spec(requestCrmApi)
                .param("contact_email", "")
                .param("active_only", 1)
                .param("department_key", dataCase.category_key)
                .param("project_key", dataCase.project_key)
                .param("oresults_limit", 10)

                .when()
                .get("/v2/case/get-list-by-email")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)

                .body("status", equalTo(422),
                        "message", equalTo("Validation error"),
                        "errors.contact_email[0]", equalTo("Contact Email cannot be blank."),
                        "code", equalTo("21303"));
    }
    @Test//Відпрацьовує коли запускаеш не в сьюті, а окремо. РОЗІБРТ-СЯ!!!
    public void getCasesByPhone() {
        given()
                .spec(requestCrmApi)
                .param("contact_phone", "+380983429271")
                .param("active_only", 1)
                .param("department_key", dataCase.category_key)
                .param("project_key", dataCase.project_key)
                .param("oresults_limit", 10)

                .when()
                .get("/v2/case/get-list-by-phone")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(200),
                        "message", equalTo("OK"),
                        "data[0].order_uid", not(empty()));
    }

    @Test
    public void getCasesByPhoneValidationError() {
        given()
                .spec(requestCrmApi)
                .param("contact_phone", "")
                .param("active_only", 1)
                .param("department_key", dataCase.category_key)
                .param("project_key", dataCase.project_key)
                .param("oresults_limit", 10)

                .when()
                .get("/v2/case/get-list-by-phone")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)

                .body("status", equalTo(422),
                        "message", equalTo("Validation error"),
                        "errors.contact_phone[0]", equalTo("Contact Phone cannot be blank."));
    }

    @Test//Відпрацьовує коли запускаеш не в сьюті, а окремо. РОЗІБРТ-СЯ!!!
    public void getCasesGidListByEmail() {
        given()
                .spec(requestCrmApi)
                .param("contact_email", dataCase.contact_email)
                .param("active_only", 1)
                .param("department_key", dataCase.category_key)
                .param("project_key", dataCase.project_key)
                .param("oresults_limit", 10)

                .when()
                .get("/v2/case/find-list-by-email")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(200),
                        "message", equalTo("OK"));

    }


    @Test
    public void getCasesGidListByEmailValidationError() {
        given()
                .spec(requestCrmApi)
                .param("contact_email", "")
                .param("active_only", 1)
                .param("department_key", dataCase.category_key)
                .param("project_key", dataCase.project_key)
                .param("oresults_limit", 10)

                .when()
                .get("/v2/case/find-list-by-email")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)

                .body("status", equalTo(422))
                .body( "message", equalTo("Validation error"))
                .body("errors.contact_email[0]", equalTo("Contact Email cannot be blank."));
    }

    @Test
    public void getCasesGidListByPhone() {
        given()
                .spec(requestCrmApi)
                .param("contact_phone", "+380983429271")
                .param("active_only", 1)
                .param("department_key", dataCase.category_key)
                .param("project_key", dataCase.project_key)
                .param("oresults_limit", 10)

                .when()
                .get("/v2/case/find-list-by-phone")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)

                .body("status", equalTo(200),
                        "message", equalTo("OK"));
    }

    @Test
    public void getCasesGIDlistByPhoneValidationError() {
        given()
                .spec(requestCrmApi)
                .contentType(ContentType.JSON)

                .param("contact_phone", "")
                .param("active_only", 1)
                .param("department_key", dataCase.category_key)
                .param("project_key", dataCase.project_key)
                .param("oresults_limit", 10)

                .when()
                .get("/v2/case/find-list-by-phone")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)

                .body("status", equalTo(422),
                "message", equalTo("Validation error"),
                "errors.contact_phone[0]", equalTo("Contact Phone cannot be blank."));
    }


}
