package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.universe.GraphicImpl;

import java.util.Optional;

/**
 * Gets information about a graphic.
 */
@JsonDeserialize(as = GraphicImpl.class)
public interface Graphic {
    Optional<String> getCollisionFile();
    Optional<String> getGraphicFile();

    /**
     * Gets the unique ID for this graphic.
     *
     * @return the ID
     */
    int getID();
    Optional<String> getIconFolder();
    Optional<String> getSofDna();
    Optional<String> getSofFactionName();
    Optional<String> getSofHullName();
    Optional<String> getSofRaceName();
}
