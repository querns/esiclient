package gbsio.esiclient.api.domain.response.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.character.PortraitURLsImpl;

import java.net.URL;
import java.util.Optional;

/**
 * Represents URLs to the character's portrait in different resolutions.
 */
@JsonDeserialize(as = PortraitURLsImpl.class)
public interface PortraitURLs {
    /**
     * Gets the URL for the 128x128 portrait.
     * @return the portrait URL
     */
    Optional<URL> get128x128();

    /**
     * Gets the URL for the 256x256 portrait.
     * @return the portrait URL
     */
    Optional<URL> get256x256();

    /**
     * Gets the URL for the 512x512 portrait.
     * @return the portrait URL
     */
    Optional<URL> get512x512();

    /**
     * Gets the URL for the 64x64 portrait.
     * @return the portrait URL
     */
    Optional<URL> get64x64();
}
