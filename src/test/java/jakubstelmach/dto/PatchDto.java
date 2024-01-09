package jakubstelmach.dto;

import org.json.JSONObject;

public class PatchDto {
    public static JSONObject getPatchObject() {
        JSONObject patchObject = new JSONObject();
        patchObject.put( "firstname", "James");
        patchObject.put( "lastname", "Brown");

        return patchObject;
    }
}
