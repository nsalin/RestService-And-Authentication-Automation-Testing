package rest_testing.json_parsers.user_parser;

import common_utils.Constants;
import common_utils.Utils;
import org.json.JSONObject;

/**
 * Created by Win81 on 4/27/2015.
 */
public class JSON_User_Reader {
    public static User_Mapper parserUser(String jsonFileName){
        User_Mapper userMapping = null;
        try{
            String stringJson = Utils.readFile(Constants.jsonResource + jsonFileName);
            JSONObject jsonUserReader = new JSONObject(stringJson);
            userMapping = new User_Mapper();

            userMapping.setId(jsonUserReader.getInt("id"));
            userMapping.setName(jsonUserReader.getString("name"));
            userMapping.setUsername(jsonUserReader.getString("username"));
            userMapping.setEmail(jsonUserReader.getString("email"));
            userMapping.setStreet(jsonUserReader.getJSONObject("address").optString("street", null));
            userMapping.setSuite(jsonUserReader.getJSONObject("address").optString("suite", null));
            userMapping.setCity(jsonUserReader.getJSONObject("address").optString("city", null));
            userMapping.setZipcode(jsonUserReader.getJSONObject("address").optInt("zipcode", 0));
            userMapping.setLat(jsonUserReader.getJSONObject("address").getJSONObject("geo").optDouble("lat"));
            userMapping.setLng(jsonUserReader.getJSONObject("address").getJSONObject("geo").optDouble("lat"));
            userMapping.setPhone(jsonUserReader.optString("phone", null));
            userMapping.setWebsite(jsonUserReader.optString("website",null));
            userMapping.setCompanyName(jsonUserReader.getJSONObject("company").optString("name",null));
            userMapping.setCatchPhrase(jsonUserReader.getJSONObject("company").optString("catchPhrase",null));
            userMapping.setBs(jsonUserReader.getJSONObject("company").optString("bs",null));



        }catch (Exception e){
            e.printStackTrace();
        }
        return userMapping;
    }
}
