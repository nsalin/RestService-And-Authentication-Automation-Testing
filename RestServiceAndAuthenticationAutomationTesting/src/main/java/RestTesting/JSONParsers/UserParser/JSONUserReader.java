package RestTesting.JSONParsers.UserParser;

import CommonUtils.Constants;
import CommonUtils.Logging;
import CommonUtils.Utils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * Created by Alin on 4/27/2015.
 */
public class JSONUserReader {
    private static final Logger LOGGER = Logger.getLogger(JSONUserReader.class);
    public static JSONUserMapper parserUser(String jsonFileName){
        JSONUserMapper userMapping = null;
        Logging logging = new Logging();
        try{
            String stringJson = Utils.readFile(Constants.jsonUserResource + jsonFileName);
            JSONObject jsonUserReader = new JSONObject(stringJson);
            userMapping = new JSONUserMapper();

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
            logging.debug(LOGGER, e.getMessage());
        }
        return userMapping;
    }
}
