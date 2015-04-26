package rest_testing.jsons_parsers.user_parser;

import javax.json.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Win81 on 4/26/2015.
 */
public class User_Reader {
    public static final String JSON_FILE = "src\\main\\resources\\json_files\\user.json";
    public static void user_reader() throws IOException{
        InputStream file = new FileInputStream(JSON_FILE);

        JsonReader jsonReader = Json.createReader(file);
        JsonObject jsonObject = jsonReader.readObject();

        jsonReader.close();
        file.close();

        User_Mapping user = new User_Mapping();
        user.setId(jsonObject.getInt("id"));
        user.setName(jsonObject.getString("name"));
        user.setUsername(jsonObject.getString("username"));
        user.setEmail(jsonObject.getString("email"));

        JsonObject jsonObjectAddress = jsonObject.getJsonObject("address");
        User_Address_Mapping address = new User_Address_Mapping();
        address.setStreet(jsonObjectAddress.getString("street"));
        address.setSuite(jsonObjectAddress.getString("suite"));
        address.setCity(jsonObjectAddress.getString("city"));
        address.setZipcode(jsonObjectAddress.getString("zipcode"));

        JsonObject jsonObjectGeo = jsonObject.getJsonObject("geo");
        User_Geo_Mapping location = new User_Geo_Mapping();
        location.setLat(jsonObjectGeo.getJsonNumber("lat").doubleValue());
        location.setLng(jsonObjectGeo.getJsonNumber("lng").doubleValue());

        user.setPhone(jsonObject.getString("phone"));
        user.setWebsite(jsonObject.getString("website"));

        JsonObject jsonObjectCompany = jsonObject.getJsonObject("company");
        User_Company_Mapping company = new User_Company_Mapping();
        company.setName(jsonObjectCompany.getString("name"));
        company.setCatchPhrase(jsonObjectCompany.getString("catchPhrase"));
        company.setBs(jsonObjectCompany.getString("bs"));


        System.out.println(user.toString());
    }
}
