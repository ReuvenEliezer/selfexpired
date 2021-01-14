package controllers;

import entities.DateTimeEntity;
import entities.SelfExpiringData;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.web.bind.annotation.*;
import services.selfexpired.SelfExpiredDataManagerImpl;
import utils.WsAddressConstants;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping(WsAddressConstants.dateTimeLogicalUrl)
public class DateTimeController {

    private static final Logger logger = Logger.getLogger(DateTimeController.class.getName());

    @PostMapping(value = "entity")
    public void dateTimeFunc(@RequestBody DateTimeEntity DateTimeEntity) {
        logger.debug(DateTimeEntity.toString());
    }

    @PostMapping(value = "localDateTime")
    public void dateTimeFunc(@RequestBody LocalDateTime localDateTime) {
        logger.debug(localDateTime.toString());
    }

    @PostMapping(value = "duration")
    public void dateTimeFunc(@RequestBody Duration duration) {
        logger.debug(duration.toString());
    }

    @PostMapping(value = "date")
    public void dateTimeFunc(@RequestBody Date date) {
        logger.debug(date.toString());
    }

    @GetMapping("localDateTime/{value}")
    public String localDateTime(@PathVariable(name = "value")
//                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                      LocalDateTime localDateTime) {
        return localDateTime.toString();
    }

}
