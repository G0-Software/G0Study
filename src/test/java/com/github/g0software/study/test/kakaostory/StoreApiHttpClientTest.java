package com.github.g0software.study.test.kakaostory;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hanoseok on 15. 4. 2..
 */
public class StoreApiHttpClientTest {

    @Test
    public void testHttpClient() throws IOException, InterruptedException {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://story-api.kakao.com/store/check_tab?current_account=387586");
        post.setRequestHeader(new Header("Connection", "Close"));
        int returnCode = client.executeMethod(post);
        System.out.println(returnCode);

        InputStream is = post.getResponseBodyAsStream();

        byte[] b = new byte[1];
        int i;
        while((i = is.read(b)) > 0){
            System.out.print(new String(b, 0, i));
            Thread.sleep(500);
        }
        post.releaseConnection();

    }
}
