package connection_package.Database;

import abstract_classes.Abstract_DatabaseConnection;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Alin on 4/25/2014.
 */
public class DatabaseConnection extends Abstract_DatabaseConnection {

    private static Connection connection = dbConnection();

    public static Connection dbConnection() {

        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        properties.put("characterEncoding", "ISO-8859-1");
        properties.put("useUnicode", "true");

        String url = "jdbc:mysql://localhost/epl";
        Connection connection = null;


        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, properties);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return connection;

    }

}


