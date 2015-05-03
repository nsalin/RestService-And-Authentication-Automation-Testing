package LogInLogOutTests.LoginParser;

/**
 * Created by Alin on 5/2/2015.
 */
public class JSONUserMapper {
    private static String user;
    private static String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        JSONUserMapper.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        JSONUserMapper.user = user;
    }


}
