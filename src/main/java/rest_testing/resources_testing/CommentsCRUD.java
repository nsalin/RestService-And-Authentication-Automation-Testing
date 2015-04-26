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
public class CommentsCRUD extends Abstract_CRUD {

    /**
     *
     */

    String allowedMethods;
    private static final Logger LOGGER = Logger.getLogger(CommentsCRUD.class);

    @Test
    public void testPost() throws ClientProtocolException, IOException {
        String URL = "http://jsonplaceholder.typicode.com/comments";
        Logging logger = new Logging();
        RestService restService = new RestService();

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("postId", "1"));
        params.add(new BasicNameValuePair("id", "1"));
        params.add(new BasicNameValuePair("name", "John"));
        params.add(new BasicNameValuePair("email", "alo@g.ro"));
        params.add(new BasicNameValuePair("body", "asaas"));

        restService.sendPostRequest(URL, params);

        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), "json");
        logger.debug(LOGGER,"A trecut testPost");
    }

    @Test
    public void testGETWithParameters() throws ClientProtocolException, IOException, URISyntaxException {
        //http://jsonplaceholder.typicode.com/comments?postId=1&id=1
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("jsonplaceholder.typicode.com")
                .setPath("/comments")
                .setParameter("postId", "1")
                .setParameter("id", "1")
                .build();

        RestService restService = new RestService();
        String response = restService.sendGetRequest(uri.toString());
        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), "json");


    }

    @Test
    public void testGET() throws ClientProtocolException, IOException{

        //instantiate the base rest service class
        RestService restService = new RestService();
        //send in the get request
        String response = restService.sendGetRequest("http://jsonplaceholder.typicode.com/comments/1");
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
    public void testPUT() throws ClientProtocolException, IOException{

        String URL = "http://jsonplaceholder.typicode.com/comments/1";
        RestService restService = new RestService();

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("postId", "1"));
        params.add(new BasicNameValuePair("id", "1"));
        params.add(new BasicNameValuePair("name", "John"));
        params.add(new BasicNameValuePair("email", "alo@g.ro"));
        params.add(new BasicNameValuePair("body", "asaas"));

        restService.sendPutRequest(URL, params);

        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), "json");

    }

    @Test
    public void testPATCH() throws ClientProtocolException, IOException{
        String URL = "http://jsonplaceholder.typicode.com/comments/1";
        RestService restService = new RestService();

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("body", "Hola"));

        restService.sendPatchRequest(URL, params);

        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), "json");

    }

    @Test
    public void testDELETE() throws ClientProtocolException, IOException{
        String URL = "http://jsonplaceholder.typicode.com/comments/1";
        RestService restService = new RestService();

        restService.sendDeleteRequest(URL);
        String response = restService.sendGetRequest(URL);
        //verify request comes back as 204
        System.out.println(restService.getStatusCode());
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_NO_CONTENT);
        //verify format response is text/plain
        Assert.assertEquals(restService.getResponseFormat(), "json");

    }

    @Test
    public void testOPTIONS() throws ClientProtocolException, IOException{

        String URL = "http://jsonplaceholder.typicode.com/comments/200";
        RestService restService = new RestService();

        Header[] headers = restService.sendOptionsRequest(URL);

        //verify request comes back as 204
        System.out.println(restService.getStatusCode());
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_NO_CONTENT);
        //verify format response is text/plain
        Assert.assertEquals(restService.getResponseFormat(), "text/plain");

        for (Header header :headers){
            if (header.getName().equalsIgnoreCase("Access-Control-Allow-Methods")){
                allowedMethods = header.getValue();
                System.out.println("Allowed rest methods for this service: " + allowedMethods);
            }
        }


    }

}

