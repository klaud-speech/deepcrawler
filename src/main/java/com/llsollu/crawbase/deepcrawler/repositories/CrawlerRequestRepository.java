package com.llsollu.crawbase.deepcrawler.repositories;

import com.llsollu.crawbase.deepcrawler.models.CrawlerRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrawlerRequestRepository extends JpaRepository<CrawlerRequest, Long> {

    List<CrawlerRequest> findByRid(String value);

}
