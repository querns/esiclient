package gbsio.esiclient.internal.response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.request.ListRequest;
import gbsio.esiclient.api.response.BooleanResponse;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.internal.http.RawContentResponse;

import java.util.List;

/**
 * A class that takes a raw response and refines it into a more useful form.
 */
public interface ResponseProcessor {
    /**
     * Refines a raw response, parsing JSON into an object.
     *
     * @param <T> the expected type of object
     * @param response a raw response from the client
     * @param typeReference the original request
     * @return a response containing objects parsed from the server's message
     */
    <T> Response<T> deserializeResponse(RawContentResponse response, TypeReference<T> typeReference);

    /**
     * Processes a raw response, returning a response that has succeeded or
     * failed.
     *
     * @param response a raw response from the client
     * @return a boolean response
     */
    BooleanResponse deserializeResponse(RawContentResponse response);

    /**
     * Deserializes a list of responses and flattens the responses into a single
     * list.
     *
     * @param responses a list of responses to parse
     * @param request the original request
     * @param <U> the type contained in the list of response objects
     * @param <T> the type of list containing said objects
     * @return a response containing objects parsed from the server's message
     */
    <U, T extends ImmutableList<U>> Response<ImmutableList<U>> deserializeAndFlatten(List<RawContentResponse> responses, ListRequest<U, T> request);
}
