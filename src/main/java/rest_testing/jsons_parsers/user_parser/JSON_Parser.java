package rest_testing.jsons_parsers.user_parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Win81 on 4/27/2015.
 */
public class JSON_Parser {
    public static JSONObject jsonParser(String jsonFile){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try{
            Object object = parser.parse(new FileReader(jsonFile));
            jsonObject = (JSONObject) object;


        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
