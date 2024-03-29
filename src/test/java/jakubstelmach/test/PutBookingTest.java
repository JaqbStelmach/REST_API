package jakubstelmach.test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jakubstelmach.dto.AuthDto;
import jakubstelmach.dto.BookingDto;
import jakubstelmach.dto.PutDto;
import jakubstelmach.request.PostBookingRequest;
import jakubstelmach.request.PutBookingRequest;
import jakubstelmach.request.auth.PostAuthRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PutBookingTest {
    private static String token;

    @BeforeAll
    static void setUp() {
        JSONObject authObject = AuthDto.getAuthObject();
        String token = PostAuthRequest.postAuth(authObject);
    }
    @Test
    void updateBooking() {
        JSONObject bookingObject = BookingDto.getBookingObject();
        Response response = PostBookingRequest.postBooking(bookingObject);
        String bookingId = response.jsonPath().getString("bookingId");

        JSONObject putObject = PutDto.getPutObject();

        Response putBooking = PutBookingRequest.putBooking(putObject, token, bookingId);
        JsonPath path = putBooking.jsonPath();

        assertThat(path.getString("booking.firstname")).isEqualTo("Adam");
    }

}
