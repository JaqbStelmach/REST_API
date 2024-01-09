package jakubstelmach.dto;

import org.json.JSONObject;

public class PutDto {
    public static JSONObject getPutObject() {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        JSONObject putObject = new JSONObject();
        putObject.put("firstname", "Adam");
        putObject.put("lastname", "Brown");
        putObject.put("totalprice", 111);
        putObject.put("depositpaid", true);
        putObject.put("additionalneeds", "Breakfast");
        putObject.put("bookingdates", bookingdates);

        return putObject;
    }
}
