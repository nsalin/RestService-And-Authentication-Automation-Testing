package rest_testing.json_parsers.photos_parser;

import common_utils.Constants;
import common_utils.Utils;
import org.json.*;

/**
 * Created by stelian.nitu on 4/30/2015.
 */
public class JSON_Photos_Reader {
    public static Photos_Mapper parserUser(String jsonFileName) {
        Photos_Mapper photosObjectMapper = null;
        try{
            String stringJSON = Utils.readFile(Constants.jsonResource + jsonFileName);
            JSONObject jsonPhotos = new JSONObject(stringJSON);
            photosObjectMapper = new Photos_Mapper();

            photosObjectMapper.setAlbumId(jsonPhotos.getInt("albumId"));
            photosObjectMapper.setId(jsonPhotos.getInt("id"));
            photosObjectMapper.setTitle(jsonPhotos.optString("title",null));
            photosObjectMapper.setUrl(jsonPhotos.getString("url"));
            photosObjectMapper.setThumbnailUrl(jsonPhotos.optString("thumbnailUrl",null));
        }catch (Exception e){
            e.printStackTrace();
        }
        return photosObjectMapper;
    }

}
