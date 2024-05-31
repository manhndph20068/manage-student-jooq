package com.example.managestudentjooq.utils.json;

import com.example.managestudentjooq.config.JsonMapper;
import com.example.managestudentjooq.exception.DecodeException;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Json {

    public static <T> T decodeValue(String str, Class<T> clazz) {
        try {
            return JsonMapper.getObjectMapper().readValue(str, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new DecodeException("Failed to decode: " + e.getMessage());
        }
    }
}
