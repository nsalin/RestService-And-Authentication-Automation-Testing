package rest_testing.jsons_parsers.user_parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

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
        String name = (String) JSON_Parser.jsonParser(JSON_FILE).get("name");
        return name;
    }

    public static String getUsername() {
        String username = (String) JSON_Parser.jsonParser(JSON_FILE).get("username");
        return username;
    }

    public static String getEmail() {
        String email = (String) JSON_Parser.jsonParser(JSON_FILE).get("email");
        return  email;
    }

    public static String getAddress(String addressParameter){
        JSONObject address = (JSONObject) JSON_Parser.jsonParser(JSON_FILE).get("address");
        Iterator iterator = (Iterator) address.keySet();
        JSONArray addressParams = new JSONArray() ;
        JSONObject jsonObject = null;

        while (iterator.hasNext()){
            String param = (String) iterator.next();
            switch (param){
                case"street":
                    return String.valueOf(iterator);
            }
        }
        return String.valueOf(iterator);
    }

}
