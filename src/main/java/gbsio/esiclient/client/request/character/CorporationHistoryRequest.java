package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CorporationHistoryEntry;
import gbsio.esiclient.api.request.specific.GetRequest;

/**
 * Gets the corporation history of a character.
 */
final public class CorporationHistoryRequest implements GetRequest<ImmutableList<CorporationHistoryEntry>> {
    private final int characterID;

    /**
     * @param characterID the ID of the character to query
     */
    public CorporationHistoryRequest(final int characterID) {
        this.characterID = characterID;
    }

    @Override
    public String getURL() {
        //noinspection SpellCheckingInspection
        return String.format("/v1/characters/%d/corporationhistory/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<CorporationHistoryEntry>> getExpectedType() {
        return new TypeReference<ImmutableList<CorporationHistoryEntry>>() {
        };
    }

}
