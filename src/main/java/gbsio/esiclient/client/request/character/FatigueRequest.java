package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.character.FatigueInformation;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

final public class FatigueRequest implements GetRequest<FatigueInformation> {
    private final int characterID;
    private final String accessToken;

    public FatigueRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/fatigue/", characterID);
    }

    @Override
    public TypeReference<FatigueInformation> getExpectedType() {
        return new TypeReference<FatigueInformation>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
