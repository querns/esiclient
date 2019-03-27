package gbsio.esiclient.client.request.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.character.Notification;
import gbsio.esiclient.api.request.specific.GetRequest;

import java.util.Optional;

final public class NotificationsRequest implements GetRequest<ImmutableList<Notification>> {
    private final int characterID;
    private final String accessToken;

    public NotificationsRequest(final int characterID, final String accessToken) {
        this.characterID = characterID;
        this.accessToken = Preconditions.checkNotNull(accessToken);
    }

    @Override
    public String getURL() {
        return String.format("/v4/characters/%d/notifications/", characterID);
    }

    @Override
    public TypeReference<ImmutableList<Notification>> getExpectedType() {
        return new TypeReference<ImmutableList<Notification>>() {
        };
    }

    @Override
    public Optional<String> getAccessToken() {
        return Optional.of(accessToken);
    }
}
