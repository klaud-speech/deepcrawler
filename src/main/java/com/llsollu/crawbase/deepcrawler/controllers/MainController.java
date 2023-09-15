package com.llsollu.crawbase.deepcrawler.controllers;

import com.llsollu.crawbase.deepcrawler.requests.ScrapeUrlRequest;
import com.llsollu.crawbase.deepcrawler.services.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scrape")
@Slf4j
public class MainController {

    @Autowired
    private MainService mainService;

    @PostMapping("/push-urls")
    public ResponseEntity<Void> purshUrlsToCrawler(@RequestBody ScrapeUrlRequest request ){
        try{
            if(!request.getUrl().isEmpty()){
                mainService.pushUrlsToCrawler( request.getUrl(), "parent");
            }
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch ( Exception e){
            log.error("Error in pushUrlsToCrawler function: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
