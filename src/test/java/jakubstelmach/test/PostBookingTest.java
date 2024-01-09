package jakubstelmach.test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jakubstelmach.dto.BookingDto;
import jakubstelmach.request.PostBookingRequest;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PostBookingTest {
    @Test
    void createBooking() {
        JSONObject bookingObject = BookingDto.getBookingObject();
        Response response = PostBookingRequest.postBooking(bookingObject);
        JsonPath path = response.jsonPath();

        assertThat(path.getString("booking.firstname")).isEqualTo("Jim");
        assertThat(path.getString("booking.lastname")).isEqualTo("Brown");
    }
}
