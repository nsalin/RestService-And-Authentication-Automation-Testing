package rest_testing.json_parsers.comments_parser;

/**
 * Created by Win81 on 4/30/2015.
 */
public class Comments_Mapper {
    private static Integer postId;
    private static Integer Id;
    private static String name;
    private static String email;
    private static String body;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        Comments_Mapper.postId = postId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Comments_Mapper.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Comments_Mapper.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        Comments_Mapper.body = body;
    }
}
