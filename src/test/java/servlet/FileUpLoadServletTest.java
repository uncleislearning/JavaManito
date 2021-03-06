package servlet;


import java.io.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by unclexiao on 2018/1/3.
 */
@RunWith(Arquillian.class)
public class FileUpLoadServletTest {

    @ArquillianResource
    private URL base;

    @Deployment(testable = false)
    public static WebArchive deploy() throws URISyntaxException {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(FileUpLoadServletTest.class);
    }


    @Test
    public void uploadFile() throws IOException, URISyntaxException {


                HttpClient client = new DefaultHttpClient();
                HttpPost postRequest = new HttpPost(new URL(base, "/fileupload").toURI());

                MultipartEntity multiPartEntity = new MultipartEntity();

                FileBody fileBody = new FileBody(new File("pom.xml"));
                multiPartEntity.addPart("attachment", fileBody);

                postRequest.setEntity(multiPartEntity);

                HttpResponse response = client.execute(postRequest);

                String servletOutput = EntityUtils.toString(response.getEntity());

                assertThat(response.getStatusLine().getStatusCode(), is(equalTo(200)));
                assertThat(servletOutput, containsString("Received 1 parts"));
                assertThat(servletOutput, containsString("writing pom.xml part"));
                assertThat(servletOutput, containsString("uploaded to: /tmp/pom.xml"));
    }
}
