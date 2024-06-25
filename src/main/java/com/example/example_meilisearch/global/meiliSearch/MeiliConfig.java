package com.example.example_meilisearch.global.meiliSearch;

import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MeiliConfig {

    // Meilisearch 클라이언트 설정
    @Bean
    public Client meiliSearchClient(){
        return new Client(new Config("http://localhost:7700", "masterKey"));
    }
}
