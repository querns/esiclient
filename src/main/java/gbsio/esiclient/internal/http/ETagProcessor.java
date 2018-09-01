package gbsio.esiclient.internal.http;

/**
 * Processes a raw content response to either store a new ETag or pull a cached
 * object on the case of an ETag hit.
 */
public interface ETagProcessor {
    RawContentResponse processETags(RawContentResponse input, String url);
}
