package tests_delete_when_deploy;

import org.apache.log4j.Logger;
import rest_testing.json_parsers.user_parser.JSON_User_Reader;
import rest_testing.json_parsers.user_parser.User_Mapper;

/**
 * Created by Win81 on 4/25/2015.
 */
public class Test {
    private static final Logger LOGGER = Logger.getLogger(Test.class);
    public static void main (String args[]){
        JSON_User_Reader.parserUser("src\\main\\resources\\json_files\\user.json");
        User_Mapper userMapping = new User_Mapper();
        System.out.println(userMapping.getCity());


    }
}
