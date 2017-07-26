package authentication;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class IWebRequests {

    RequestSpecification rspec;
    RequestSpecBuilder build;
    AuthenticationSpecification login;
    IWebAuth iwa;


    @BeforeClass
    public void requestSpec() {
        build  = new RequestSpecBuilder();
        build.setBaseUri("IWEB URLS");
        build.setBasePath("/verify/iweb");

        rspec = build.build();

    }

    @Test
    public void authTest() {
        iwa = new IWebAuth();
        iwa.getToken();


    }

    @Test
    public void iwebDirectAccess() {
        given()
                .auth().preemptive().oauth2(iwa.accessIWebToken)
                .when()
                .get("")
                .then()
                .log()
                .body();
    }

}
