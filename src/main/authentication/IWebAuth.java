package authentication;

import static io.restassured.RestAssured.given;

public class IWebAuth {

    private static String KEYCLOAK_URL = "URL";
    private static String KEYCLOAK_REALM = "REALM";
    private static String KEYCLOAK_SN_IWEB_USER = "user";
    private static String KEYCLOAK_SN_IWEB_PASSWORD = "pw";
    private static String KEYCLOAK_CLIENT = "client";
    private static String KEYCLOAK_SECRET = "secret";
    private static String KEYCLOAK_GRANT_TYPE = "password";

    public String accessIWebToken;

    public void getToken() {
        accessIWebToken = given()
                .formParam("grant_type", KEYCLOAK_GRANT_TYPE, "clientId", KEYCLOAK_CLIENT)
                .params("username", KEYCLOAK_SN_IWEB_USER, "password", KEYCLOAK_SN_IWEB_PASSWORD)
                .auth()
                .preemptive()
                .basic(KEYCLOAK_CLIENT, KEYCLOAK_SECRET)
                .when()
                .post(KEYCLOAK_URL)
                .then()
                .log()
                .all()
                .extract()
                .path("access_token");
        System.out.println(accessIWebToken);

    }
}
