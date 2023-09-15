package com.llsollu.crawbase.deepcrawler.requests;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ScrapeUrlRequest {
    private Integer pc_status;
    private Integer original_status;
    private String rid;
    private List<String> url;
    private String body;

}
