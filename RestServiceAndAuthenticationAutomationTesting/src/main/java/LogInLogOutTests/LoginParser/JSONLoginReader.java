package LogInLogOutTests.LoginParser;

import CommonUtils.Constants;
import CommonUtils.Logging;
import CommonUtils.Utils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * Created by Alin on 5/2/2015.
 */
public class JSONLoginReader {
    private static final Logger LOGGER = Logger.getLogger(JSONLoginReader.class);

    public static JSONUserMapper jsonParserLogin(String fileName){
        JSONUserMapper jsonLoginMapper = null;
        Logging logger = new Logging();

        try{
            String jsonString = Utils.readFile(Constants.loginResource + fileName);
            JSONObject jsonObject = new JSONObject(jsonString);
            jsonLoginMapper = new JSONUserMapper();

            jsonLoginMapper.setUser(jsonObject.getString("user"));
            jsonLoginMapper.setPassword(jsonObject.getString("password"));
        }catch (Exception ex){
            ex.printStackTrace();
            logger.debug(LOGGER,ex.getMessage());
        }
        return jsonLoginMapper;
    }
}
