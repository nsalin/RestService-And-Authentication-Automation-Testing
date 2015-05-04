package RestTesting.JSONParsers.URLParser;

import CommonUtils.Constants;
import CommonUtils.Logging;
import CommonUtils.Utils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * Created by Alin on 4/30/2015.
 */
public class JSONURLReader {
    private static final Logger LOGGER = Logger.getLogger(JSONURLReader.class);
    public enum ResourceName {
        USERS,COMMENTS,PHOTOS
    }

    ResourceName resourceName;


    public static JSONURLMapper parseURL(ResourceName resourceName, String jsonFileName){
        JSONURLMapper urlMapper = null;
        Logging logging = new Logging();
        String stringJson = null;
        try {
            switch (resourceName){
                case USERS: stringJson = Utils.readFile(Constants.jsonUserResource+jsonFileName);
                    break;
                case COMMENTS:stringJson= Utils.readFile(Constants.jsonCommentsResource+jsonFileName);
                    break;
                case PHOTOS: stringJson = Utils.readFile(Constants.jsonPhotoResource+jsonFileName);
                    break;
                default: System.out.println("This resource doesn't exists"); stringJson = null;
            }
            JSONObject jsonResource = new JSONObject(stringJson);
            urlMapper = new JSONURLMapper();

            urlMapper.setTestDELETE(jsonResource.getString("testDELETE"));
            urlMapper.setTestGET(jsonResource.getString("testGET"));
            urlMapper.setTestGetWithParameters(jsonResource.getString("testGETWithParameters"));
            urlMapper.setTestOPTIONS(jsonResource.getString("testOPTIONS"));
            urlMapper.setTestPUT(jsonResource.getString("testPUT"));
            urlMapper.setTestPATCH(jsonResource.getString("testPATCH"));
            urlMapper.setTestPOST(jsonResource.getString("testPOST"));

        }catch (Exception ex){
            ex.printStackTrace();
            logging.debug(LOGGER, ex.getMessage());
        }
        return  urlMapper;
    }

}
