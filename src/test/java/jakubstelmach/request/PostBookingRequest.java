package jakubstelmach.request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jakubstelmach.url.BookingUrl;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {
    public static Response postBooking(JSONObject bookingObject) {
        return given()
                .contentType(ContentType.JSON)
                .body(bookingObject.toString())
                .when()
                .post(BookingUrl.BASE_URL + "/" + BookingUrl.BOOKING)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
