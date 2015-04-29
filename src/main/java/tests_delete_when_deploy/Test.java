package tests_delete_when_deploy;

import org.apache.log4j.Logger;
import rest_testing.json_parsers.user_parser.JSON_User_Reader;
import rest_testing.json_parsers.user_parser.User_Mapping;

/**
 * Created by Win81 on 4/25/2015.
 */
public class Test {
    private static final Logger LOGGER = Logger.getLogger(Test.class);
    public static void main (String args[]){
        JSON_User_Reader.parserUser("src\\main\\resources\\json_files\\user.json");
        User_Mapping userMapping = new User_Mapping();
        System.out.println(userMapping.getCity());


    }
}
