package com.llsollu.crawbase.deepcrawler.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CrawlerRequest {
    @Id
    @GeneratedValue
    private Long id;

    private String url;
    private String type;
    private Integer status;
    private String rid;

    @OneToOne(mappedBy = "crawlerRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CrawlerResponse crawlerResponse;


}
