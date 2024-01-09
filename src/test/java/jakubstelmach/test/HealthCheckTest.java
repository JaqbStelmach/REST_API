package jakubstelmach.test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jakubstelmach.request.HealthCheckRequest;
import jakubstelmach.url.BookingUrl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HealthCheckTest {
    @Test
    void healthCheckTest() {
        Response healthCheck = HealthCheckRequest.getHealthCheck();
        JsonPath path = healthCheck.jsonPath();

        assertThat(healthCheck.getStatusCode()).isEqualTo(201);
    }
}
