package rest_testing.jsons_parsers.user_parser;

import common_utils.Utils;
import org.json.JSONObject;

/**
 * Created by Win81 on 4/27/2015.
 */
public class JSON_Parser {
    public static JSONObject jsonParser(String jsonFile){
        JSONObject jsonObject = null;
        try{
            String json = Utils.readFile(jsonFile);
            jsonObject = new JSONObject(json);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return jsonObject;
    }
}
