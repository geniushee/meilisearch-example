package com.example.example_meilisearch.global.ut;

import com.example.example_meilisearch.global.app.AppConfig;
import lombok.SneakyThrows;

import java.util.Map;

public class Util {

    public static class Json{
        @SneakyThrows
        public static String toString(Object object){
            return AppConfig.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
        }

        @SneakyThrows
        public static <T> T toObject(String json, Class<T> cls){
            return AppConfig.getObjectMapper().readValue(json, cls);
        }

        @SneakyThrows
        public static <T> T toObject(Map<String, Object> map, Class<T> cls){
            return AppConfig.getObjectMapper().convertValue(map, cls);
        }
    }
}
