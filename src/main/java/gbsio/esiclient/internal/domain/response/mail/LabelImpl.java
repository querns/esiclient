package gbsio.esiclient.internal.domain.response.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.common.mail.LabelColor;
import gbsio.esiclient.api.domain.response.mail.Label;

import java.util.Optional;

public class LabelImpl implements Label {
    private final LabelColor color;
    private final Integer ID;
    private final String name;
    private final Integer unreadCount;

    LabelImpl(
        @JsonProperty("color")
        final LabelColor color,
        @JsonProperty("label_id")
        final Integer id,
        @JsonProperty("name")
        final String name,
        @JsonProperty("unread_count")
        final Integer unreadCount
    ) {
        this.color = color;
        ID = id;
        this.name = name;
        this.unreadCount = unreadCount;
    }

    @Override
    public Optional<LabelColor> getColor() {
        return Optional.ofNullable(color);
    }

    @Override
    public Optional<Integer> getID() {
        return Optional.ofNullable(ID);
    }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Override
    public Optional<Integer> getUnreadCount() {
        return Optional.ofNullable(unreadCount);
    }
}
