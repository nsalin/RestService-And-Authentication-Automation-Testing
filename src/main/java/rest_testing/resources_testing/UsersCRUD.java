package rest_testing.resources_testing;

import abstract_classes.Abstract_CRUD;
import com.fasterxml.jackson.databind.JsonNode;
import common_utils.Logging;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
//import rest_testing.jsons_parsers.user_parser.User;
import rest_testing.rest_service_component.RestService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Win81 on 4/26/2015.
 */
public class UsersCRUD extends Abstract_CRUD {

    String allowedMethods;
    private static final Logger LOGGER = Logger.getLogger(UsersCRUD.class);

    @Test
    public void testPost() throws ClientProtocolException, IOException {
        String URL = "http://jsonplaceholder.typicode.com/users";
        Logging logger = new Logging();
        RestService restService = new RestService();

        List<NameValuePair> paramsParent = new ArrayList<NameValuePair>();
        List<NameValuePair> paramsChildAddress = new ArrayList<>();
        List<NameValuePair> paramsChildGeo = new ArrayList<>();
        List<NameValuePair> paramsChildCompany = new ArrayList<>();

        paramsChildAddress.add(new BasicNameValuePair("street","Ripensia"));
        paramsChildAddress.add(new BasicNameValuePair("suite","A11"));
        paramsChildAddress.add(new BasicNameValuePair("city","TM"));
        paramsChildAddress.add(new BasicNameValuePair("zipcode","019245"));
        paramsChildGeo.add(new BasicNameValuePair("lat","1935933"));
        paramsChildGeo.add(new BasicNameValuePair("lng","456231"));
        paramsChildCompany.add(new BasicNameValuePair("name","DE"));
        paramsChildCompany.add(new BasicNameValuePair("catchPhrase","Be the one"));
        paramsChildCompany.add(new BasicNameValuePair("bs","harness real time"));

        paramsParent.add(new BasicNameValuePair("name", "Alin"));
        paramsParent.add(new BasicNameValuePair("username", "Stelian"));
        paramsParent.add(new BasicNameValuePair("email", "asd@yahoo.com"));
        paramsParent.add(new BasicNameValuePair("address", paramsChildAddress.toString()));
        paramsParent.add(new BasicNameValuePair("geo",paramsChildGeo.toString()));
        paramsParent.add(new BasicNameValuePair("phone","79854654"));
        paramsParent.add(new BasicNameValuePair("website","jdjr.ro"));
        paramsParent.add(new BasicNameValuePair("company",paramsChildCompany.toString()));

        restService.sendPostRequest(URL, paramsParent);

        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), "json");
        logger.info(LOGGER, "testPost\n"+String.valueOf(restService.getStatusCode())+"\n"+restService.sendPostRequest(URL, paramsParent));
    }

    @Test
    public void testGETWithParameters() throws ClientProtocolException, IOException, URISyntaxException {
        //http://jsonplaceholder.typicode.com/users/1/posts?name=alin&id=3
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("jsonplaceholder.typicode.com")
                .setPath("/users")
                .setParameter("id", "3")
                .setParameter("username", "Samantha")
                .build();

        RestService restService = new RestService();
        String response = restService.sendGetRequest(uri.toString());
        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), "json");


    }

    @Test
    public void testGET() throws ClientProtocolException, IOException {

        //instantiate the base rest service class
        RestService restService = new RestService();
        //send in the get request
        String response = restService.sendGetRequest("http://jsonplaceholder.typicode.com/users/1");
        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), "json");

        //create a tree of json response
        JsonNode node = restService.mapJSONToTree();

        //create an iterator of all the repo nodes
        Iterator<JsonNode> nodeIterator = node.iterator();

        //playing around with it
        while (nodeIterator.hasNext()) {
            JsonNode rootNode = nodeIterator.next();
            // what is its type
            System.out.println(rootNode.getNodeType());
            // Prints Object
            System.out.println(rootNode.toString());
        }
    }

    @Test
    public void testPUT() throws ClientProtocolException, IOException {

        String URL = "http://jsonplaceholder.typicode.com/users/1";
        RestService restService = new RestService();


        List<NameValuePair> paramsParent = new ArrayList<>();
        List<NameValuePair> paramsChildAddress = new ArrayList<>();
        List<NameValuePair> paramsChildGeo = new ArrayList<>();
        List<NameValuePair> paramsChildCompany = new ArrayList<>();

        paramsChildAddress.add(new BasicNameValuePair("street","boss"));
        paramsChildAddress.add(new BasicNameValuePair("suite","A11"));
        paramsChildAddress.add(new BasicNameValuePair("city","TM"));
        paramsChildAddress.add(new BasicNameValuePair("zipcode","019245"));
        paramsChildGeo.add(new BasicNameValuePair("lat","1935933"));
        paramsChildGeo.add(new BasicNameValuePair("lng","456231"));
        paramsChildCompany.add(new BasicNameValuePair("name","DE"));
        paramsChildCompany.add(new BasicNameValuePair("catchPhrase","Be the one"));
        paramsChildCompany.add(new BasicNameValuePair("bs","harness real time"));

        paramsParent.add(new BasicNameValuePair("id", "1"));
        paramsParent.add(new BasicNameValuePair("name", "Alin"));
        paramsParent.add(new BasicNameValuePair("username", "Stelian"));
        paramsParent.add(new BasicNameValuePair("email", "asd@yahoo.com"));
        paramsParent.add(new BasicNameValuePair("address", paramsChildAddress.toString()));
        paramsParent.add(new BasicNameValuePair("geo",paramsChildGeo.toString()));
        paramsParent.add(new BasicNameValuePair("phone","79854654"));
        paramsParent.add(new BasicNameValuePair("website","jdjr.ro"));
        paramsParent.add(new BasicNameValuePair("company",paramsChildCompany.toString()));


        restService.sendPutRequest(URL, paramsParent);

        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), "json");

    }

    @Test
    public void testPATCH() throws ClientProtocolException, IOException {
        String URL = "http://jsonplaceholder.typicode.com/users/1";
        RestService restService = new RestService();

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("name", "alin"));

        restService.sendPatchRequest(URL, params);

        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), "json");

    }

    @Test
    public void testDELETE() throws ClientProtocolException, IOException {
        String URL = "http://jsonplaceholder.typicode.com/users/4";
        RestService restService = new RestService();
        RestService restService2 = new RestService();

        restService.sendDeleteRequest(URL);
        String response = restService.sendGetRequest(URL);
        //verify request comes back as 204
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_NO_CONTENT);

        //verify format response is text/plain
        Assert.assertEquals(restService.getResponseFormat(), "json");

    }

    @Test
    public void testOPTIONS() throws ClientProtocolException, IOException {

        String URL = "http://jsonplaceholder.typicode.com/users/*";
        RestService restService = new RestService();

        Header[] headers = restService.sendOptionsRequest(URL);

        //verify request comes back as 204
        System.out.println(restService.getStatusCode());
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_NO_CONTENT);
        //verify format response is text/plain
        Assert.assertEquals(restService.getResponseFormat(), "text/plain");

        for (Header header : headers) {
            if (header.getName().equalsIgnoreCase("Access-Control-Allow-Methods")) {
                allowedMethods = header.getValue();
                System.out.println("Allowed rest methods for this service: " + allowedMethods);
            }
        }


    }

}
