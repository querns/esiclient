package gbsio.esiclient.api.domain.response.alliance;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.alliance.AllianceLogoURLsImpl;

import java.net.URL;
import java.util.Optional;

/**
 * Holds the URLs to alliance logos.
 */
@JsonDeserialize(as=AllianceLogoURLsImpl.class)
public interface AllianceLogoURLs {
    /**
     * Gets the 128x128 logo for an alliance.
     *
     * @return the URL to the logo
     */
    Optional<URL> getLogo128();

    /**
     * Gets the 64x64 logo for an alliance.
     *
     * @return the URL to the logo
     */
    Optional<URL> getLogo64();
}
