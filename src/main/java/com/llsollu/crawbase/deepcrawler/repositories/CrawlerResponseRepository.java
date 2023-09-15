package com.llsollu.crawbase.deepcrawler.repositories;

import com.llsollu.crawbase.deepcrawler.models.CrawlerResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrawlerResponseRepository extends JpaRepository<CrawlerResponse, Long> {
}
