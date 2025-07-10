package com.sun.apps.jackson;
/*
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonService {

    private final ObjectMapper objectMapper;

    public JsonService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.error("Invalid JSON input: {}", json, e);
            throw new IllegalArgumentException("Invalid JSON format", e);
        } catch (Exception e) {
            log.error("Unexpected error while deserializing JSON", e);
            throw new RuntimeException("Deserialization failed", e);
        }
    }

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Unable to serialize object: {}", object, e);
            throw new RuntimeException("Serialization failed", e);
        }
    }
}
*/