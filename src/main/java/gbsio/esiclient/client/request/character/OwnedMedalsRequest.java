package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.CharacterMedal;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

final public class OwnedMedalsRequest implements GetRequest<ImmutableList<CharacterMedal>> {
    private final int characterID;
    private final String authenticationToken;

    public OwnedMedalsRequest(final int characterID, final String authenticationToken) {
        this.characterID = characterID;
        this.authenticationToken = Preconditions.checkNotNull(authenticationToken);
    }

    @Override
    public String getURL() {
        return String.format("/v1/characters/%d/medals/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<CharacterMedal>> getExpectedType() {
        return new TypeReference<ImmutableList<CharacterMedal>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(authenticationToken);
    }
}
