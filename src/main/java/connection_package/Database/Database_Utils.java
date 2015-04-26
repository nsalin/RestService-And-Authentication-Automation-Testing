package connection_package.Database;

import java.sql.*;

/**
 * Created by Alin on 4/25/2015.
 */
public class Database_Utils {
    private static ResultSet resultSet = null;
    private static Statement statement = null;

    public static String dbStatementUserName(Connection connection,int id) {
        String stringUserName = null;

        try {
            statement = connection.createStatement();
            String table_name = "automation_user_table";

            String userName = "SELECT user from " + table_name + " WHERE id = " + id;
            resultSet = statement.executeQuery(userName);

            while (resultSet.next()) {

                stringUserName = resultSet.getString(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        return stringUserName;
    }

    public static String dbStatementPassword(Connection connection, int id) {

        String stringPassword = null;
        try {
            statement = connection.createStatement();
            String table_name = "automation_user_table";

            String password = "SELECT password from " + table_name + " WHERE id =  " + id;

            resultSet = statement.executeQuery(password);


            while (resultSet.next()) {

                stringPassword = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            return stringPassword;

        }


    }
}
