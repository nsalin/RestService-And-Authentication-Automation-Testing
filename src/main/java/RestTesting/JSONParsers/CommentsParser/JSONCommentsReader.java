package RestTesting.JSONParsers.CommentsParser;

import CommonUtils.Constants;
import CommonUtils.Logging;
import CommonUtils.Utils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * Created by Alin on 4/30/2015.
 */
public class JSONCommentsReader {
    private static final Logger LOGGER = Logger.getLogger(JSONCommentsReader.class);

    public static JSONCommentsMapper parseComments(String jsonFileName){
        JSONCommentsMapper commentsMapping = null;
        Logging logging = new Logging();
        try{
            String jsonStringReader = Utils.readFile(Constants.jsonCommentsResource + jsonFileName);
            JSONObject jsonCommentsReader = new JSONObject(jsonStringReader);
            commentsMapping = new JSONCommentsMapper();

            commentsMapping.setPostId(jsonCommentsReader.getInt("postId"));
            commentsMapping.setId(jsonCommentsReader.getInt("id"));
            commentsMapping.setName(jsonCommentsReader.optString("name","Anonymous"));
            commentsMapping.setEmail(jsonCommentsReader.getString("email"));
            commentsMapping.setBody(jsonCommentsReader.optString("body", null));


        }catch (Exception e){
            e.printStackTrace();
            logging.debug(LOGGER,e.getMessage());
        }
        return commentsMapping;
    }

}
