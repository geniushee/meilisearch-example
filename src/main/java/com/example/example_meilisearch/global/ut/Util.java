package com.example.example_meilisearch.global.ut;

import com.example.example_meilisearch.global.app.AppConfig;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Util {

    public static class Json{
        public static String toString(Object object) throws JsonProcessingException {
            return AppConfig.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
        }
    }
}
