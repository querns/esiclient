package gbsio.esiclient.api.domain.response.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.common.BlueprintImpl;

@JsonDeserialize(as = BlueprintImpl.class)
public interface Blueprint extends ContainerItem {
    /**
     * Gets the level of material efficiency research.
     *
     * @return the material efficiency research level
     */
    int getMaterialEfficiency();

    /**
     * Get the level of time efficiency research.
     *
     * @return the time efficiency research level
     */
    int getTimeEfficiency();

    /**
     * Get the number of runs left on a blueprint copy.
     *
     * @return the number of runs remaining, or -1 on an original blueprint.
     */
    int getRuns();
}
