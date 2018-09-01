package gbsio.esiclient.internal.domain.response.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import gbsio.esiclient.api.domain.response.mail.Label;
import gbsio.esiclient.api.domain.response.mail.LabelDataContainer;

import java.util.Optional;

public class LabelDataContainerImpl implements LabelDataContainer {
    private final ImmutableList<Label> labels;
    private final Integer totalUnreadCount;

    LabelDataContainerImpl(
        @JsonProperty("labels")
        final ImmutableList<Label> labels,
        @JsonProperty("total_unread_count")
        final Integer totalUnreadCount
    ) {
        this.labels = MoreObjects.firstNonNull(labels, ImmutableList.of());
        this.totalUnreadCount = totalUnreadCount;
    }

    @Override
    public ImmutableList<Label> getLabels() {
        return labels;
    }

    @Override
    public Optional<Integer> getTotalUnreadCount() {
        return Optional.ofNullable(totalUnreadCount);
    }
}
