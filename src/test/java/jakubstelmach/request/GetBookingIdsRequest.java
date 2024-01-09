package jakubstelmach.request;

import io.restassured.response.Response;
import jakubstelmach.url.BookingUrl;

import static io.restassured.RestAssured.given;

public class GetBookingIdsRequest {
    public static Response getBookingIds() {
        return given()
                .when()
                .get(BookingUrl.BASE_URL + "/" + BookingUrl.BOOKING)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
