package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import gbsio.esiclient.api.domain.response.character.PortraitURLs;
import gbsio.esiclient.api.request.specific.GetRequest;

final public class PortraitsRequest implements GetRequest<PortraitURLs> {
    private final int characterID;

    public PortraitsRequest(final int characterID) {
        this.characterID = characterID;
    }

    @Override
    public String getURL() {
        return String.format("/v2/characters/%d/portrait/", characterID);
    }

    @Override
    public TypeReference<PortraitURLs> getExpectedType() {
        return new TypeReference<PortraitURLs>() {
        };
    }
}
