package jakubstelmach.test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jakubstelmach.dto.AuthDto;
import jakubstelmach.dto.BookingDto;
import jakubstelmach.request.DeleteBookingRequest;
import jakubstelmach.request.PostBookingRequest;
import jakubstelmach.request.auth.PostAuthRequest;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DeleteBookingTest {
    private static String token;

    @BeforeAll
    static void setUp() {
        JSONObject authObject = AuthDto.getAuthObject();
        String token = PostAuthRequest.postAuth(authObject);
    }

    @Test
    void deleteBooking() {
        JSONObject bookingObject = BookingDto.getBookingObject();
        Response postBooking = PostBookingRequest.postBooking(bookingObject);
        String bookingId = postBooking.jsonPath().getString("bookingId");

        Response response = DeleteBookingRequest.deleteBooking(token, bookingId);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);

    }
}
