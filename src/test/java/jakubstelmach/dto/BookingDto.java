package jakubstelmach.dto;

import org.json.JSONObject;

public class BookingDto {
    public static JSONObject getBookingObject() {

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        JSONObject bookingObject = new JSONObject();
        bookingObject.put("firstname", "Jim");
        bookingObject.put("lastname", "Brown");
        bookingObject.put("totalprice", 111);
        bookingObject.put("depositpaid", true);
        bookingObject.put("additionalneeds", "Breakfast");
        bookingObject.put("bookingdates", bookingdates);

        return bookingObject;
    }
}
