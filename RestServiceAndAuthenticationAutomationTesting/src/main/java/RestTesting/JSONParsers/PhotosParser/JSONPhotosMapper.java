package RestTesting.JSONParsers.PhotosParser;

/**
 * Created by Alin on 4/30/2015.
 */
public class JSONPhotosMapper {
    private static Integer albumId;
    private static Integer id;
    private static String title;
    private static String url;
    private static String thumbnailUrl;


    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        JSONPhotosMapper.thumbnailUrl = thumbnailUrl;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        JSONPhotosMapper.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        JSONPhotosMapper.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        JSONPhotosMapper.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        JSONPhotosMapper.url = url;
    }


}
