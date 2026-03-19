package com.cardiza.portfolio.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.annotation.EnableCaching;

import java.time.Duration;
import java.util.List;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        Cache experiencesCache = new CaffeineCache(
                "experiences",
                Caffeine.newBuilder()
                        .maximumSize(1000)
                        .build()
        );

        Cache organizationsCache = new CaffeineCache(
                "organizations",
                Caffeine.newBuilder()
                        .maximumSize(1000)
                        .build()
        );

        Cache technologiesCache = new CaffeineCache(
                "technologies",
                Caffeine.newBuilder()
                        .maximumSize(1000)
                        .build()
        );

        Cache commentsCache = new CaffeineCache(
                "comments",
                Caffeine.newBuilder()
                        .expireAfterWrite(Duration.ofDays(1))
                        .maximumSize(1000)
                        .build()
        );

        Cache technologyCategoriesCache = new CaffeineCache(
                "technology-categories",
                Caffeine.newBuilder()
                        .expireAfterWrite(Duration.ofDays(1))
                        .maximumSize(1000)
                        .build()
        );

        cacheManager.setCaches(List.of(experiencesCache, commentsCache, organizationsCache, technologiesCache));
        return cacheManager;
    }
}