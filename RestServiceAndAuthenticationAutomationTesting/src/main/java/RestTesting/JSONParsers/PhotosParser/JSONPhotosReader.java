package RestTesting.JSONParsers.PhotosParser;

import CommonUtils.Constants;
import CommonUtils.Logging;
import CommonUtils.Utils;
import org.apache.log4j.Logger;
import org.json.JSONObject;


/**
 * Created by Alin on 4/30/2015.
 */
public class JSONPhotosReader {
    private static final Logger LOGGER = Logger.getLogger(JSONPhotosReader.class);

    public static JSONPhotosMapper parserPhoto(String jsonFileName) {
        JSONPhotosMapper photosObjectMapper = null;
        Logging logging = new Logging();
        try{
            String stringJSON = Utils.readFile(Constants.jsonPhotoResource + jsonFileName);
            JSONObject jsonPhotos = new JSONObject(stringJSON);
            photosObjectMapper = new JSONPhotosMapper();

            photosObjectMapper.setAlbumId(jsonPhotos.getInt("albumId"));
            photosObjectMapper.setId(jsonPhotos.getInt("id"));
            photosObjectMapper.setTitle(jsonPhotos.optString("title",null));
            photosObjectMapper.setUrl(jsonPhotos.getString("url"));
            photosObjectMapper.setThumbnailUrl(jsonPhotos.optString("thumbnailUrl",null));
        }catch (Exception e){
            e.printStackTrace();
            logging.debug(LOGGER,e.getMessage());
        }
        return photosObjectMapper;
    }

}
