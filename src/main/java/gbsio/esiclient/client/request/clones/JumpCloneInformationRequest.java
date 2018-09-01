package gbsio.esiclient.client.request.clones;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import gbsio.esiclient.api.domain.response.clones.JumpCloneInformation;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

final public class JumpCloneInformationRequest implements GetRequest<JumpCloneInformation> {
    private final int characterID;
    private final String accessToken;

    public JumpCloneInformationRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v3/characters/%d/clones/", characterID);
    }

    @Override
    public TypeReference<JumpCloneInformation> getExpectedType() {
        return new TypeReference<JumpCloneInformation>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
