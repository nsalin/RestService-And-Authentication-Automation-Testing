package rest_testing.json_parsers.comments_parser;

import common_utils.Constants;
import common_utils.Utils;
import org.json.JSONObject;

/**
 * Created by Win81 on 4/30/2015.
 */
public class JSON_Comments_Reader {
    public static Comments_Mapper parseComments(String jsonFileName){
        Comments_Mapper commentsMapping = null;
        try{
            String jsonStringReader = Utils.readFile(Constants.jsonResource + jsonFileName);
            JSONObject jsonCommentsReader = new JSONObject(jsonStringReader);
            commentsMapping = new Comments_Mapper();

            commentsMapping.setPostId(jsonCommentsReader.getInt("postId"));
            commentsMapping.setId(jsonCommentsReader.getInt("id"));
            commentsMapping.setName(jsonCommentsReader.optString("name","Anonymous"));
            commentsMapping.setEmail(jsonCommentsReader.getString("email"));
            commentsMapping.setBody(jsonCommentsReader.optString("body", null));


        }catch (Exception e){
            e.printStackTrace();
        }
        return commentsMapping;
    }

}
