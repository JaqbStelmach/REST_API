package jakubstelmach.request;

import io.restassured.response.Response;
import jakubstelmach.url.BookingUrl;

import static io.restassured.RestAssured.given;

public class HealthCheckRequest {
    public static Response getHealthCheck() {
        return given()
                .when()
                .get(BookingUrl.BASE_URL + "/" + BookingUrl.PING)
                .then()
                .extract()
                .response();
    }
}
