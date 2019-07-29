package com.github.holidayapi.holidayapi.api;

import com.github.holidayapi.holidayapi.model.FestivoAPIResponse;
import com.github.holidayapi.holidayapi.model.QueryParams;

import java.io.IOException;

/**
 * This interface defines methods to consume the Festivos API
 *
 * @author rakesh
 */
public interface APIConsumer {

    /**
     * Call the holidays api and send back the response encapsulatd in a {@link FestivoAPIResponse} object
     *
     * @param queryParams - the params encapsulated in an object
     * @return an object representation of the response
     * @throws IOException - when there are connection issues or the URL is malformed
     */
    FestivoAPIResponse getFestivos(QueryParams queryParams) throws IOException;

    /**
     * Call the holidays api and send back the response as a json string
     *
     * @param queryParams - the params encapsulated in an object
     * @return an object representation of the response
     * @throws IOException - when there are connection issues or the URL is malformed
     */
    String getFestivosAsString(QueryParams queryParams) throws IOException;
}
