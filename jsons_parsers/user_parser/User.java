package rest_testing.jsons_parsers.user_parser;

import org.json.*;

/**
 * Created by Win81 on 4/26/2015.
 */
public class User {
    private static final String JSON_FILE = "src\\main\\resources\\json_files\\user.json";

    public static long getId() {
        Long id = (Long) JSON_Parser.jsonParser(JSON_FILE).get("id");
        return id;
    }

    public static String getName() {
        return (String) JSON_Parser.jsonParser(JSON_FILE).get("name");
    }

    public static String getUsername() {
        return (String) JSON_Parser.jsonParser(JSON_FILE).get("username");
    }

    public static String getEmail() {
        String email = (String) JSON_Parser.jsonParser(JSON_FILE).get("email");
        return email;
    }

    public static String getAddress(String addressParameter) {
        JSONObject address = JSON_Parser.jsonParser(JSON_FILE).getJSONObject("address");
        JSONObject geo = address.getJSONObject("geo");

        String addressParam ;
        switch (addressParameter){
            case"street": addressParam = (String) address.get("street");break;
            case"suite":addressParam = (String) address.get("suite");break;
            case"city":addressParam =  (String) address.get("city");break;
            case"zipcode":addressParam =  (String) address.get("zipcode");break;
            case"lat": addressParam =  (String) geo.get("lat");break;
            case"lng":addressParam =  (String) geo.get("lng");break;
            default: addressParam = "This parameter doesn't exists !";
        }

        return addressParam;
    }
}

