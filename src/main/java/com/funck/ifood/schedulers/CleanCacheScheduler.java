package com.funck.ifood.schedulers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CleanCacheScheduler {

    private final CacheManager cacheManager;

    @Scheduled(fixedRate = 10000)
    public void cleanCacheScheduler() {
        log.info("Cleaning all cache");

        cacheManager.getCache("weatherInfo").clear();
    }

}
