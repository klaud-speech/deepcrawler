package com.llsollu.crawbase.deepcrawler.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class CrawlerResponse {
    @Id
    @GeneratedValue
    private Long id;

    private Integer pcStatus;
    private Integer originStatus;

    @Column(columnDefinition = "LONGTEXT")
    private String pageHtml;

    @OneToOne
    @JoinColumn(name = "request_id" )
    private CrawlerRequest crawlerRequest;

}
