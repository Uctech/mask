package com.example.mask;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MaskController {
    public final ObjectLoggingHelper loggingHelper = ObjectLoggingHelper.getInstance();

    @GetMapping("mask")
    public ResponseEntity<User> mask(){

        User user = new User();
        user.setPassword("75830353");
        user.setSsn("6583ssn");
        user.setMsisdn("2348075645377");
        user.setName("John");
        log.info("User details: {}", MaskingUtil.toMaskedSensitiveFieldsString(user));
        loggingHelper.requestObject(log, user);
        log.info("Object for toString {}", user);
        return ResponseEntity.ok(user);
    }
}
