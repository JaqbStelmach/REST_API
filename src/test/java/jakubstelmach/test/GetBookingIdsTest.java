package jakubstelmach.test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jakubstelmach.request.GetBookingIdsRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GetBookingIdsTest {
    @Test
    void getBookingIdsTest() {
        Response bookingIds = GetBookingIdsRequest.getBookingIds();
        JsonPath path = bookingIds.jsonPath();

        assertThat(path.getList("booking").size()).isPositive();
    }
}
