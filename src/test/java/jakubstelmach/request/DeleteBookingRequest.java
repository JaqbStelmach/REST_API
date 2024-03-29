package jakubstelmach.request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jakubstelmach.url.BookingUrl;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {
    public static Response deleteBooking(String token, String bookingId) {
        return given()
                .contentType(ContentType.JSON)
                .header("Cookie","token=" + token)
                .when()
                .delete(BookingUrl.BASE_URL + "/" + BookingUrl.BOOKING + "/" + bookingId)
                .then()
                .extract()
                .response();
    }
}
