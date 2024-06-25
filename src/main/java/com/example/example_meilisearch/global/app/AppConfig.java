package com.example.example_meilisearch.global.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
//    @Getter
//    private static ObjectMapper objectMapper;

    private static String activeProfile;

    @Value("${spring.profiles.active}")
    public void setActiveProfile(String activeProfile) {
        this.activeProfile = activeProfile;
    }

    public static boolean isTest() {
        return activeProfile.equals("Test");
    }

//    @Autowired
//    public void setObjectMapper(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//        this.objectMapper.registerModule(new JavaTimeModule());
//    }
}
