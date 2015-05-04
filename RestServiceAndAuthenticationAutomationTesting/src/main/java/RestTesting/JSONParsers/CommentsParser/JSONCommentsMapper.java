package RestTesting.JSONParsers.CommentsParser;

/**
 * Created by Alin on 4/30/2015.
 */
public class JSONCommentsMapper {
    private static Integer postId;
    private static Integer Id;
    private static String name;
    private static String email;
    private static String body;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        JSONCommentsMapper.postId = postId;
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
        JSONCommentsMapper.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        JSONCommentsMapper.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        JSONCommentsMapper.body = body;
    }
}
