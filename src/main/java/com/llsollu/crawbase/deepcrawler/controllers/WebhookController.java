package com.llsollu.crawbase.deepcrawler.controllers;

import com.llsollu.crawbase.deepcrawler.services.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @Autowired
    private WebhookService webhookService;

    @PostMapping("/crawbase")
    public ResponseEntity<Void> crawbaseCrawlerResponse(@RequestHeader HttpHeaders headers, @RequestBody byte[] compressedBody){
        try{
            if(!headers.getFirst(HttpHeaders.USER_AGENT).equalsIgnoreCase("Crawlbase Monitoring Bot 1.0") &&
            "gzip".equalsIgnoreCase(headers.getFirst(HttpHeaders.CONTENT_ENCODING))&&
            headers.getFirst("pc_status").equals("200")){
                webhookService.handleWebhookResponse(headers, compressedBody);
            }
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            //log.error("Error in crawlbaseCrawlerResponse function: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
