package com.example.example_meilisearch.global.meiliSearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Config;
import com.meilisearch.sdk.json.JacksonJsonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MeiliConfig {

    // Meilisearch 클라이언트 설정
    @Bean
    public Client meiliSearchClient(){
        // issue.1 java에서 Jackson을 사용하여 Json을 사용할 때, LocalDateTime 역직렬화 문제가 발생한다.
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // issue.1 이러한 문제를 해결하기 위해 JavaTimeModule을 등록해줘야만 한다.(빌드 참조)
        return new Client(new Config("http://localhost:7700", "masterKey", new JacksonJsonHandler(mapper)));
    }
}
