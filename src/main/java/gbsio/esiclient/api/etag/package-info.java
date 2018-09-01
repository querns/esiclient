/**
 * Contains interfaces related to implementation of an ETag cache.
 * <p>
 * ETag caches are used by the client to store <a href="https://en.wikipedia.org/wiki/HTTP_ETag">ETags</a>
 * and cached object data, with the goal of reducing the amount of data transfer
 * the client performs.
 * <p>
 * Users may implement a custom {@link gbsio.esiclient.api.etag.ETagCache} and
 * supply it to a {@link gbsio.esiclient.api.config.ClientConfig#builder()} to
 * allow for persistence of ETags and cached objects.
 */
package gbsio.esiclient.api.etag;