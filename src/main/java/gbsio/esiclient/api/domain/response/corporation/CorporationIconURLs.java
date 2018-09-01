package gbsio.esiclient.api.domain.response.corporation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.corporations.CorporationIconURLsImpl;

import java.net.URL;
import java.util.Optional;

/**
 * Represents URLs to a corporation's logo.
 */
@JsonDeserialize(as = CorporationIconURLsImpl.class)
public interface CorporationIconURLs {
    /**
     * Get the URL to the 128x128 resolution icon.
     *
     * @return a URL
     */
    Optional<URL> getIcon128();

    /**
     * Get the URL to the 256x256 resolution icon.
     *
     * @return a URL
     */
    Optional<URL> getIcon256();

    /**
     * Get the URL to the 64x64 resolution icon.
     *
     * @return a URL
     */
    Optional<URL> getIcon64();
}
