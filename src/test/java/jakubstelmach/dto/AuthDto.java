package jakubstelmach.dto;

import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class AuthDto {
    public static JSONObject getAuthObject() {
        JSONObject authObject = new JSONObject();
        authObject.put("username", "admin");
        authObject.put("password", "password123");

        return authObject;
    }

}
