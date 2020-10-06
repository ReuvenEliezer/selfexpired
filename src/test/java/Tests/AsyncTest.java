package Tests;

import app.TestApp;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import utils.WsAddressConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = TestApp.class)
public class AsyncTest {

    private static final Logger logger = Logger.getLogger(AsyncTest.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void asyncTest() {
        StopWatch stopWatch = new StopWatch("My Stop Watch");
        stopWatch.start("initializing");
        restTemplate.getForObject(WsAddressConstants.aSyncFullUrl + "doAsync", Void.class);
        restTemplate.getForObject(WsAddressConstants.aSyncFullUrl + "doAsync", Void.class);

        stopWatch.stop();
        Assert.assertTrue(stopWatch.getTotalTimeSeconds()<5);
        System.out.println(stopWatch.prettyPrint());
    }

    @Test
    public void syncTest() {
        StopWatch stopWatch = new StopWatch("My Stop Watch");
        stopWatch.start("initializing");
        restTemplate.getForObject(WsAddressConstants.aSyncFullUrl + "doSync", Void.class);
        restTemplate.getForObject(WsAddressConstants.aSyncFullUrl + "doSync", Void.class);

        stopWatch.stop();
        Assert.assertTrue(stopWatch.getTotalTimeSeconds()>5);
        System.out.println(stopWatch.prettyPrint());
    }
}
