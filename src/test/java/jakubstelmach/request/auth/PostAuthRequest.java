package jakubstelmach.request.auth;

import io.restassured.http.ContentType;
import jakubstelmach.url.BookingUrl;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PostAuthRequest {
    public static String postAuth(JSONObject json) {
        return given()
                .contentType(ContentType.JSON)
                .body(json.toString())
                .when()
                .post(BookingUrl.BASE_URL + "/" + BookingUrl.AUTH)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("token");
    }
}
