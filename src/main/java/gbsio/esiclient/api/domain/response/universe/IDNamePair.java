package gbsio.esiclient.api.domain.response.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gbsio.esiclient.internal.domain.response.universe.IDNamePairImpl;

/**
 * Represents a result from the bulk names-to-IDs lookup.
 */
@JsonDeserialize(as = IDNamePairImpl.class)
public interface IDNamePair {
    int getID();
    String getName();
}
