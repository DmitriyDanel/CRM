package dmitriy.daniel.API.zohoIQ;

import Dmitriy.Daniel.models.zoho.ObjectRequestLeadForm;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

import static Dmitriy.Daniel.Specification.requestCrmApi;
import static Dmitriy.Daniel.Specification.requestSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateLeadWithChat {

    ObjectRequestLeadForm objectRequestLead = new ObjectRequestLeadForm();
        public void leadCreateWithChat() {
        given()
                .spec(requestCrmApi)
                .contentType(ContentType.JSON)
                .body(objectRequestLead)
                .post("/v2/object-request/create")
                .then()
                .spec(requestSpec)
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void createLeadWithChatSuccesses() {
        leadCreateWithChat();
        given()
                .then()
                .body("status", equalTo(200),
                        "message", equalTo("OK"),
                        "technical.action", equalTo("v2/object-request/create"));
    }

    @Test
    public void createLeadWithChatWithIncorrectProjectKey() {

        String projectKey = "ovagos"; // project Source Cid - Source not found
        objectRequestLead.setProjectKey(projectKey);

        leadCreateWithChat();
        given()
                .then()
                .body("status", equalTo(422),
                        "message", equalTo("Validation error"),
                        "errors.projectKey[0]", equalTo("Project Key is invalid."),
                        "technical.action", equalTo("v2/object-request/create"));
    }

    @Test

    public void createLeadWithChatWithIncorrectProjectSourceCid() {
        String projectKey = "hop2"; // project Source Cid - Source not found
        objectRequestLead.setProjectKey(projectKey);

        leadCreateWithChat();
        given()
                .then()

                .body("status", equalTo(422),
                        "message", equalTo("Validation error"),
                        "errors.projectSourceCid[0]", equalTo("Source not found"),
                        "technical.action", equalTo("v2/object-request/create"));
    }


//    @Test
//    public void createLeadBody() {
//        ObjectRequestLeadForm objectRequest = new ObjectRequestLeadForm();
//        objectRequest.getType();
//        objectRequest.setProjectKey("ovago");
//        objectRequest.setProjectSourceCid("I1B1L1");
//
//        ObjectRequestLeadForm.DataBody dataBody = new ObjectRequestLeadForm.DataBody();
//        dataBody.setRid("213537545129");
//        dataBody.setChannel(1);
//        dataBody.setVersion(1);
//
//        ObjectRequestLeadForm.Owner owner = new ObjectRequestLeadForm.Owner();
//        owner.setId("48233000000293319");
//        owner.setName("dmitriy.daniel.admin");
//        owner.setEmail("dmitriy.danel@kiv.dev");
//        owner.setBot(false);
//        dataBody.setOwner(owner);
//
//        ObjectRequestLeadForm.Visitor visitor = new ObjectRequestLeadForm.Visitor();
//        visitor.setId("00ea809c-319f-47d6-bc02");
//        visitor.setUuid("78187292-9665-4f3e-a927-8001b7895d99");
//        visitor.setName("Captain Morgan");
//        visitor.setEmail("danel9@gmail.com");
//        visitor.setPhone("+380989830009");
//        visitor.setCountryCode("UA");
//        visitor.setIp("46.173.98.154");
//        dataBody.setVisitor(visitor);
//
//        ObjectRequestLeadForm.Lead lead = new ObjectRequestLeadForm.Lead();
//        lead.setUid("6580080d99114");
//        lead.setCurrency("USD");
//        lead.setTripType("OW");
//        lead.setCabin("E");
//        lead.setAdults(1);
//        lead.setChildren(0);
//        lead.setInfants(0);
//
//        ObjectRequestLeadForm.Flight flight = new ObjectRequestLeadForm.Flight();
//        flight.setOrigin("LGW");
//        flight.setDestination("CDG");
//        flight.setDeparture("2024-01-26");
//        lead.setFlights(List.of(flight));
//
//        dataBody.setLead(lead);
//        objectRequest.setData(dataBody);
//
//        given()
//                .spec(requestCrmApi)
//                .contentType(ContentType.JSON)
//                .body(objectRequest)
//                .post("/v2/object-request/create")
//                .then()
//                .spec(requestSpec)
//                .assertThat()
//                .log().body()
//                .statusCode(HttpStatus.SC_OK)
//
//                .body("status", equalTo(200),
//                        "message", equalTo("OK"),
//                        "technical.action", equalTo("v2/object-request/create"));
//    }
}


