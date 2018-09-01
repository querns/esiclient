package gbsio.esiclient.api.domain.response.fittings;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.api.domain.common.fittings.Fitting;
import gbsio.esiclient.internal.domain.response.fitting.RetrievedFittingImpl;

/**
 * Represents a saved ship fitting belonging to a character.
 */
@JsonDeserialize(as = RetrievedFittingImpl.class)
public interface RetrievedFitting extends Fitting {
    /**
     * Get the unique ID of this fitting.
     *
     * @return the ID
     */
    int getID();

}
