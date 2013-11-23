package ws.soap;

import org.junit.Test;
import ws.api.UserWebService;
import ws.config.WsConstants;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.URL;

import static org.junit.Assert.assertNotNull;

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13
 */
public class WebServiceIntegrationTest {

    private UserWebService userServiceRemote = new UserWebServiceImpl();

    @Test(timeout = 10000)
    public void test() throws Exception {
        Endpoint endpoint = Endpoint.publish("http://localhost:36484/user", userServiceRemote);

        Service service = Service.create(new URL("http://localhost:36484/user?wsdl"),
                new QName(WsConstants.USER_SERVICE_NAMESPACE, WsConstants.USER_SERVICE_NAME));

        assertNotNull(service.getPort(UserWebService.class));

        endpoint.stop();
    }
}
