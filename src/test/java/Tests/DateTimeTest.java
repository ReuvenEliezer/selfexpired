package Tests;

import app.TestApp;
import entities.DateTimeEntity;
import entities.SelfExpiringData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import utils.WsAddressConstants;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = TestApp.class)
public class DateTimeTest {


    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void postEntityTest(){
        restTemplate.postForObject(WsAddressConstants.dateTimeFullUrl + "entity", new DateTimeEntity(LocalDateTime.now()), Void.class);
    }

    @Test
    public void localDateTimeTest(){
        restTemplate.postForObject(WsAddressConstants.dateTimeFullUrl + "localDateTime",LocalDateTime.now(), Void.class);
    }

    @Test
    public void durationTest() {
        restTemplate.postForObject(WsAddressConstants.dateTimeFullUrl + "duration", Duration.ofHours(2), Void.class);
    }

    @Test
    public void dateTest() {
        restTemplate.postForObject(WsAddressConstants.dateTimeFullUrl + "date", Date.valueOf(LocalDate.now()), Void.class);
    }
}
