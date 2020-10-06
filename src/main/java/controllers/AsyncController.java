package controllers;

import entities.SelfExpiringData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import services.selfexpired.SelfExpiredDataManager;
import utils.WsAddressConstants;

import java.time.Duration;

@RestController
@RequestMapping(WsAddressConstants.aSyncLogicalUrl)
public class AsyncController {

    private static final Duration sleepDuration= Duration.ofSeconds(5);

    @GetMapping(value = "doAsync")
    @Async
    public void doAsync() throws InterruptedException {
        Thread.sleep(sleepDuration.toMillis());
    }

    @GetMapping(value = "doSync")
    public void doSync() throws InterruptedException {
        Thread.sleep(sleepDuration.toMillis());
    }



}
