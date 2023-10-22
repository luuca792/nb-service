package com.ctu.se.oda.model11.api;

import com.ctu.se.oda.model11.AppInformationService;
import com.ctu.se.oda.model11.models.commands.responses.AppInfoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev")
public class DevApi {

    @GetMapping(value = "/test", produces = "application/json")
    public ResponseEntity<AppInfoResponse> callTest() {
        return new ResponseEntity<>(AppInformationService.getAppInfo(), HttpStatus.OK);
    }
}