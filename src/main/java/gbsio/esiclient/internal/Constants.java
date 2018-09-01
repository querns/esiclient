package gbsio.esiclient.internal;

import java.time.ZoneId;

/**
 * Contains various constants used by the client.
 */
final public class Constants {
    public static final ZoneId TIMEZONE_UTC = ZoneId.of("UTC");
    public static final int MAX_ERROR_LIMIT = 100;
    public static final String DATE_HEADER = "date";
    public static final String REMAINING_ERROR_LIMIT_HEADER = "X-ESI-Error-Limit-Remain";
    public static final String ERROR_LIMIT_RESET_HEADER = "X-ESI-Error-Limit-Reset";
    public static final String ETAG_REQUEST_HEADER = "If-None-Match";
    public static final String LANGUAGE_REQUEST_HEADER = "language";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_VALUE = "Bearer ";
    public static final String PAGE_COUNT_RESPONSE_HEADER = "x-pages";
    public static final String ETAG_HEADER = "ETag";
    public static final String EXPIRY_HEADER = "Expires";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String CONTENT_TYPE_VALUE = "application/json";
}
