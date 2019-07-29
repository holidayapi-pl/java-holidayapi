package com.github.holidayapi.holidayapi.api.testutil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.holidayapi.holidayapi.model.FestivoAPIResponse;

import java.io.IOException;

/**
 * This util class consists of mock API responses for each status code.
 *
 */
public abstract class MockResponse {

    private static ObjectMapper mapper = new ObjectMapper();

    //Only the status code is important, the error message is irrelevant for testing
    public static String RESPONSE_200 = "{\"status\":200,\"holidays\":[{\"name\":\"May Day\",\"date\":\"2017-05-01\",\"observed\":\"2017-05-01\",\"public\":false}]}";
    public static String RESPONSE_400 = "{\"status\":400,\"error\":\"Something went wrong on your end\"}";
    public static String RESPONSE_401 = "{\"status\":401,\"error\":\"Unauthorized\"}";
    public static String RESPONSE_402 = "{\"status\":402,\"error\":\"Payment required\"}";
    public static String RESPONSE_403 = "{\"status\":403,\"error\":\"Forbidden\"}";
    public static String RESPONSE_429 = "{\"status\":429,\"error\":\"Exceeded free quota\"}";
    public static String RESPONSE_500 = "{\"status\":500,\"error\":\"Internal server error\"}";

    public static FestivoAPIResponse response200() throws IOException {
        return mapper.readValue(RESPONSE_200, FestivoAPIResponse.class);
    }

    public static FestivoAPIResponse response400() throws IOException {
        return mapper.readValue(RESPONSE_400, FestivoAPIResponse.class);
    }

    public static FestivoAPIResponse response401() throws IOException {
        return mapper.readValue(RESPONSE_401, FestivoAPIResponse.class);
    }

    public static FestivoAPIResponse response402() throws IOException {
        return mapper.readValue(RESPONSE_402, FestivoAPIResponse.class);
    }

    public static FestivoAPIResponse response403() throws IOException {
        return mapper.readValue(RESPONSE_403, FestivoAPIResponse.class);
    }

    public static FestivoAPIResponse response429() throws IOException {
        return mapper.readValue(RESPONSE_429, FestivoAPIResponse.class);
    }

    public static FestivoAPIResponse response500() throws IOException {
        return mapper.readValue(RESPONSE_500, FestivoAPIResponse.class);
    }

}
