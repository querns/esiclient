package gbsio.esiclient.api.domain.response.planetaryinteraction;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.planetaryinteraction.SchematicImpl;

/**
 * Represents a schematic employed by factory buildings in Planetary
 * Interaction.
 *
 * "Here's a schematic for you -- my ass!" - TF2's Scout
 */
@JsonDeserialize(as = SchematicImpl.class)
public interface Schematic {
    /**
     * Gets the cycle time of this schematic.
     *
     * @return the cycle time in seconds
     */
    int getCycleTime();

    /**
     * Gets the name of this schematic.
     *
     * @return the name
     */
    String getName();
}
