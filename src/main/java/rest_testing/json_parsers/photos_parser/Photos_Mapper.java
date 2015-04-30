package rest_testing.json_parsers.photos_parser;

/**
 * Created by stelian.nitu on 4/30/2015.
 */
public class Photos_Mapper {
    private static Integer albumId;
    private static Integer id;
    private static String title;
    private static String url;
    private static String thumbnailUrl;


    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        Photos_Mapper.thumbnailUrl = thumbnailUrl;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        Photos_Mapper.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Photos_Mapper.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        Photos_Mapper.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        Photos_Mapper.url = url;
    }


}
