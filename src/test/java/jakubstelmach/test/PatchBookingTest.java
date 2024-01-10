package jakubstelmach.test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jakubstelmach.dto.AuthDto;
import jakubstelmach.dto.BookingDto;
import jakubstelmach.dto.PatchDto;
import jakubstelmach.request.PatchBookingRequest;
import jakubstelmach.request.PostBookingRequest;
import jakubstelmach.request.auth.PostAuthRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PatchBookingTest {
    private static String token;

    @BeforeAll
    static void setUp() {
        JSONObject authObject = AuthDto.getAuthObject();
        String token = PostAuthRequest.postAuth(authObject);
    }
    @Test
    void partialUpdateBooking() {
        JSONObject bookingObject = BookingDto.getBookingObject();
        Response response = PostBookingRequest.postBooking(bookingObject);
        String bookingId = response.jsonPath().getString("bookingId");

        JSONObject patchObject = PatchDto.getPatchObject();

        Response patchBooking = PatchBookingRequest.patchBooking(patchObject, bookingId, token);
        JsonPath path = patchBooking.jsonPath();


        assertThat(path.getString("booking.firstname")).isEqualTo("James");
        assertThat(path.getString("booking.lastname")).isEqualTo("Brown");
    }

}
