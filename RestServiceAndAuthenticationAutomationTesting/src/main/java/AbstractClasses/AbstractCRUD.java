package AbstractClasses;

import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Alin on 4/26/2015.
 */
public abstract class AbstractCRUD {
    public abstract void testPost() throws ClientProtocolException,IOException;

    public abstract void testGETWithParameters() throws ClientProtocolException,IOException, URISyntaxException;

    public abstract void testGET() throws ClientProtocolException,IOException;

    public abstract void testPUT() throws ClientProtocolException,IOException;

    public abstract void testPATCH() throws ClientProtocolException,IOException;

    public abstract void testDELETE()throws ClientProtocolException,IOException;

    public abstract void testOPTIONS()throws ClientProtocolException,IOException;
}
