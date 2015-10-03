package RestTesting.ResourcesTesting;

import AbstractClasses.AbstractCRUD;
import com.fasterxml.jackson.databind.JsonNode;
import CommonUtils.Constants;
import CommonUtils.Logging;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import RestTesting.JSONParsers.URLParser.JSONURLReader;
import RestTesting.JSONParsers.URLParser.JSONURLMapper;
import RestTesting.JSONParsers.PhotosParser.JSONPhotosReader;
import RestTesting.JSONParsers.PhotosParser.JSONPhotosMapper;
import RestTesting.RestServiceComponent.RestService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Alin on 4/26/2015.
 */
public class PhotosCRUD extends AbstractCRUD {

    String allowedMethods;
    private static final Logger LOGGER = Logger.getLogger(PhotosCRUD.class);
    private static final JSONURLMapper jsonURLReader = JSONURLReader.parseURL(JSONURLReader.ResourceName.PHOTOS, "urls.json");

    @Test
    public void testPost() throws ClientProtocolException, IOException {
        String URL = jsonURLReader.getTestPOST();
        Logging logger = new Logging();
        JSONPhotosReader.parserPhoto("photo.json");
        JSONPhotosMapper photosMapper = new JSONPhotosMapper();
        RestService restService = new RestService();


        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("albumId", String.valueOf(photosMapper.getAlbumId())));
        params.add(new BasicNameValuePair("id", String.valueOf(photosMapper.getId())));
        params.add(new BasicNameValuePair("title", photosMapper.getTitle()));
        params.add(new BasicNameValuePair("url", photosMapper.getUrl()));
        params.add(new BasicNameValuePair("thumbnailUrl",photosMapper.getThumbnailUrl()));

        restService.sendPostRequest(URL, params);

        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), Constants.applicationReturnJSON);
        logger.info(LOGGER, "testPost\n"+String.valueOf(restService.getStatusCode())+"\n"+restService.sendPostRequest(URL, params));
    }

    @Test
    public void testGETWithParameters() throws ClientProtocolException, IOException, URISyntaxException {
        //http://jsonplaceholder.typicode.com/photos?albumId=2&id=54
        String URL = jsonURLReader.getTestGetWithParameters();

        RestService restService = new RestService();
        String response = restService.sendGetRequest(URL);
        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), Constants.applicationReturnJSON);


    }

    @Test
    public void testGET() throws ClientProtocolException, IOException {

        //instantiate the base rest service class
        RestService restService = new RestService();
        //send in the get request
        String response = restService.sendGetRequest(jsonURLReader.getTestGET());
        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), Constants.applicationReturnJSON);

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

        String URL = jsonURLReader.getTestPUT();
        RestService restService = new RestService();
        JSONPhotosReader.parserPhoto("photo.json");
        JSONPhotosMapper photosMapper = new JSONPhotosMapper();
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("albumId", String.valueOf(photosMapper.getAlbumId())));
        params.add(new BasicNameValuePair("id", String.valueOf(photosMapper.getId())));
        params.add(new BasicNameValuePair("title", photosMapper.getTitle()));
        params.add(new BasicNameValuePair("url", photosMapper.getUrl()));
        params.add(new BasicNameValuePair("thumbnailUrl",photosMapper.getThumbnailUrl()));



        restService.sendPutRequest(URL, params);

        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), Constants.applicationReturnJSON);

    }

    @Test
    public void testPATCH() throws ClientProtocolException, IOException {
        String URL = jsonURLReader.getTestPATCH();
        RestService restService = new RestService();

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("title", "alin"));

        restService.sendPatchRequest(URL, params);

        //verify request comes back as 200 ok
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);
        //verify format response is json
        Assert.assertEquals(restService.getResponseFormat(), Constants.applicationReturnJSON);

    }

    @Test
    public void testDELETE() throws ClientProtocolException, IOException {
        String URL = jsonURLReader.getTestDELETE();
        RestService restService = new RestService();

        restService.sendDeleteRequest(URL);
        String response = restService.sendGetRequest(URL);
        //verify request comes back as 204
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_OK);

        //verify format response is text/plain
        Assert.assertEquals(restService.getResponseFormat(), Constants.applicationReturnJSON);

    }

    @Test
    public void testOPTIONS() throws ClientProtocolException, IOException {

        String URL = jsonURLReader.getTestOPTIONS();
        RestService restService = new RestService();

        Header[] headers = restService.sendOptionsRequest(URL);

        //verify request comes back as 204
        System.out.println(restService.getStatusCode());
        Assert.assertEquals(restService.getStatusCode(), HttpStatus.SC_NO_CONTENT);
        //verify format response is text/plain
        Assert.assertEquals(restService.getResponseFormat(), Constants.applicationReturnText);

        for (Header header : headers) {
            if (header.getName().equalsIgnoreCase("Access-Control-Allow-Methods")) {
                allowedMethods = header.getValue();
                System.out.println("Allowed rest methods for this service: " + allowedMethods);
            }
        }


    }
}
