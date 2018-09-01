package gbsio.esiclient.client.request.universe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.universe.Structure;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

/**
 * Retrieves information about a player-owned structure.
 * <p></p>
 * If the authenticating character isn't on the structure's ACL, the response
 * will return {@link gbsio.esiclient.api.domain.response.errors.ErrorType#FORBIDDEN}.
 */
final public class StructureRequest implements GetRequest<Structure> {
    private final long structureID;
    private final String accessToken;

    /**
     * @param structureID the ID of the structure to query
     * @param accessToken an OAuth2 access token belonging to a character on the
     *                    ACL for the structure
     */
    public StructureRequest(final long structureID, final String accessToken) {
        this.structureID = structureID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v2/universe/structures/%d/", structureID);
    }

    @Override
    public TypeReference<Structure> getExpectedType() {
        return new TypeReference<Structure>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
