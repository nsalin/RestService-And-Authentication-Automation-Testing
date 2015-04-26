package tests_delete_when_deploy;

import java.util.List;

import static com.jayway.restassured.RestAssured.*;

/**
 * Created by Win81 on 4/25/2015.
 */
public class JSON_Schema_Validator {

    public static void main(String args[]){

        List<String> response = get("http://jsonplaceholder.typicode.com/users").jsonPath().getList("users.id");
        for (String l : response){
            System.out.println(l);
        }
    }



}
