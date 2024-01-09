package jakubstelmach.request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jakubstelmach.url.BookingUrl;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {
    public static Response putBooking(JSONObject json, String token, String bookingId) {
        return given()
                .contentType(ContentType.JSON)
                .body(json.toString())
                .header("Cookie","token=" + token)
                .when()
                .put(BookingUrl.BASE_URL + "/" + BookingUrl.BOOKING +"/" + bookingId)
                .then()
                .extract()
                .response();
    }
}
