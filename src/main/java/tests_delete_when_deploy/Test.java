package tests_delete_when_deploy;

import org.apache.log4j.Logger;
import rest_testing.jsons_parsers.user_parser.User;

/**
 * Created by Win81 on 4/25/2015.
 */
public class Test {
    private static final Logger LOGGER = Logger.getLogger(Test.class);
    public static void main (String args[]){

        System.out.println(User.getAddress("street"));


    }
}
