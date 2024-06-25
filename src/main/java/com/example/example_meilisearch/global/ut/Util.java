package com.example.example_meilisearch.global.ut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Util {

    public static class Json{
        public static String toString(Object object) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        }
    }
}
